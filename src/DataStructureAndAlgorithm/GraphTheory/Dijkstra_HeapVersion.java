package DataStructureAndAlgorithm.GraphTheory;
import java.util.*;
class pair{
    int distance;
    int node;
    pair(int distance,int node){
        this.distance = distance;
        this.node = node;
    }
}
//原题链接：https://www.acwing.com/problem/content/description/852/
public class Dijkstra_HeapVersion {
    static int Max_Value = 20000;//设置20000为无穷大
    static int n,m,idx;
    static int N = 150010;
    static int[] dist = new int[N];
    static int[] e = new int[N];
    static int[] h = new int[N];
    static int[] ne = new int[N];
    static int[] w = new int[N];
    static boolean[] st = new boolean[N];
    //h[]:表示邻接表的表头
    static void add(int a,int b,int c){
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    static int Dijkstra(){
        Arrays.fill(dist,Max_Value);
        dist[1] = 0;
        Deque<pair> deque = new LinkedList<>();
        deque.push(new pair(0,1));
        while(!deque.isEmpty()){
            pair t = deque.poll();
            int node = t.node;
            int distance = t.distance;
            if (st[node])continue;
            st[node] = true;
            for (int i = h[node]; i != -1; i = ne[i]){
                int j = e[i];
                if (dist[j] > distance + w[i]){
                    dist[j] = distance + w[i];
                    deque.offer(new pair(dist[j],j));
                }
            }
        }
        if (dist[n] == Max_Value)return -1;
        return dist[n];
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h,-1);//初始化所有的表头为空结点-1
        for (int i = 0; i < m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            add(a,b,c);
        }
        int res = Dijkstra();
        System.out.print(res);
    }
}
/*
import java.io.*;
import java.lang.*;
import java.util.*;

class Main{
    static int n = 0, m = 0, N = 1000010;
    static PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{return a[1] - b[1];});//堆
    static int[] dist = new int[N];//距离数组
    static boolean[] f = new boolean[N];//标记数组
    static int[] h = new int[N], ne = new int[N], e = new int[N], w = new int[N];//邻接表
    static int idx = 1;
    static int Dijkstra(){//类似广搜的过程
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;//初始化第一个点到自身的距离
        q.offer(new int[]{1, 0});
        while(q.size() != 0){
            int[] a = q.poll();
            int t = a[0], distance = a[1];
            if(f[t])continue;
            f[t] = true;
            for(int i = h[t]; i != -1; i = ne[i]){
               int j = e[i];
               if(dist[j] > distance + w[i]){
                   dist[j] = distance + w[i];
                   q.offer(new int[]{j, dist[j]});
               }
            }
        }
        if(dist[n] != 0x3f3f3f3f)return dist[n];
        return -1;
    }
    static void add(int a, int b, int c){
        e[idx] = b; w[idx] = c;ne[idx] = h[a]; h[a] = idx++;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String[] params = buf.readLine().split(" ");
        n = Integer.valueOf(params[0]);
        m = Integer.valueOf(params[1]);
        Arrays.fill(h, -1);
        for(int i = 1; i <= m; ++i){
            String[] info = buf.readLine().split(" ");
            int a = Integer.valueOf(info[0]);
            int b = Integer.valueOf(info[1]);
            int c = Integer.valueOf(info[2]);
            add(a, b, c);
        }
        System.out.print(Dijkstra());

    }
}
*/