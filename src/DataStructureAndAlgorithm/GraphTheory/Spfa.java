package DataStructureAndAlgorithm.GraphTheory;
import java.util.*;
//原题链接：https://www.acwing.com/problem/content/853/
public class Spfa {
    //spfa是对bellmanford算法的优化，与Dijkstra算法非常相似
    //但是Dijkstra算法不能针对负权，而spfa可以
    //并且,spfa的效率很高。最坏情况下为O(nm)
    static int N = 100010,Max_Value = 900000;
    static int[] e = new int[N],ne = new int[N],w = new int[N],h = new int[N];
    static int n,m,idx = 0;
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h,-1);
        for (int i = 0; i < m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            add(a,b,c);
        }
        int res = spfa();
        if (res == -1)System.out.print("impossible");
        else System.out.print(res);
    }
    static int spfa(){
        Arrays.fill(dist,Max_Value);
        dist[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        st[1] = true;
        //st[i] ： 用于判断是否已经加入队列，因为将一个点重复加入队列是没有意义的
        while(!queue.isEmpty()){
            int t = queue.poll();
            st[t] = false;
            //循环访问与t结点相邻的所有的结点，并将变短的路径更新
            //如果更新完的结点还没有加入队列中，则将其加入队列
            for (int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                if (dist[j] > dist[t] + w[i]){
                    dist[j] = dist[t] + w[i];
                    if (!st[j]){
                        queue.offer(j);
                        st[j] = true;
                    }
                }
            }
        }
        if (dist[n] > Max_Value/2)return -1;
        return dist[n];
    }
    //邻接表存图
    static void add(int a,int b,int c){
        //e[idx]:表示下一个点
        //w[idx]:表示到下一个点的权重
        //ne[idx]:表示到达下一个点的结点，即索引
        //h[idx]:表示头结点
        e[idx] = b; w[idx] = c;ne[idx] = h[a];h[a] = idx++;
    }
}
