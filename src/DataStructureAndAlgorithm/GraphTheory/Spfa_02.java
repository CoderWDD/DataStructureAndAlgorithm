package DataStructureAndAlgorithm.GraphTheory;
import java.util.*;
//原题链接：https://www.acwing.com/problem/content/854/
//判断图中是否存在负权回路
public class Spfa_02 {
    static int N = 10100,Max_Value = 999999;
    static int[] dist = new int[N];
    static int[] cnt = new int[N];
    static boolean[] st = new boolean[N];
    static int[] e = new int[N],ne = new int[N],h = new int[N],w = new int[N];
    static int n,m,idx=0;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h,-1);//初始化所有头结点
        for (int i = 0; i < m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            add(a,b,c);
        }
        boolean res = spfa();
        if (res)System.out.print("Yes");
        else System.out.print("No");
    }
    static void add(int a,int b,int c){
        e[idx] = b;w[idx] = c;ne[idx] = h[a];h[a] = idx++;
    }
    static boolean spfa(){
        Queue<Integer> queue = new LinkedList<>();
        //因为从每个点出发，都有可能有负环，因此，需要从所有的点都开始走一遍
        for (int i = 1; i <= n; i++){
            st[i] = true;
            queue.offer(i);
        }
        while (!queue.isEmpty()){
            int t = queue.poll();
            st[t] = false;
            for (int i = h[t]; i != -1; i = ne[i]){
                int j = e[i];
                if (dist[j] > dist[t] + w[i]){
                    dist[j] = dist[t] + w[i];
                    cnt[j] = cnt[t] + 1;
                    //判断负环的方法：由抽屉原理，已经连接的n-1条边中，必有n个结点，故，只要任意一个点的连桶的边大于n，则说明有负环
                    if (cnt[j] > n)return true;
                    if (!st[j]){
                        queue.offer(j);
                        st[j] = true;
                    }
                }
            }
        }
        return false;
    }
}
