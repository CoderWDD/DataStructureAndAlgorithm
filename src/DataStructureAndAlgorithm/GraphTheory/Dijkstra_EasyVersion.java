package DataStructureAndAlgorithm.GraphTheory;
import java.util.*;
//原题链接：https://www.acwing.com/problem/content/851/
public class Dijkstra_EasyVersion {
    //不支持负权重和环
    //基于贪心的思想
    static int n,m;
    static int N = 510;
    static int[][] g = new int[N][N];//稠密图，用邻接矩阵存储
    static boolean[] st = new boolean[N];
    static int[] dist = new int[N];
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();//n个点
        m = in.nextInt();//m条边
        //下面初始化所有的结点未无穷大
        for (int i = 0; i <= n; i++){
            Arrays.fill(g[i],200000);
        }
        //下面读入所有的结点
        for (int i = 0; i < m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            g[a][b] = Math.min(g[a][b],c);//主要是处理重边的问题
        }
        int res = Dijkstra();
        System.out.print(res);
    }
    static int Dijkstra(){
        //初始化所有的边为无穷大
        //dist[j]:表示从结点1到结点j之间的最小距离
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;
        //循环n遍，即对所有的点都可以访问一次，并将其加入已经连通的路径中
        for (int i = 0; i < n; i++){
            //下面的循环用于找出还未加入连通集合中的点的权重的最小值点
            int t = -1;
            for (int j = 1; j <= n; j++){
                if (!st[j] && (t == -1 || dist[t] > dist[j])){
                    t = j;
                }
            }
            st[t] = true;//标记t结点已经被访问过，即已经加入连通的路径中
            //重新更新所有点到结点1（初始结点）的最短距离
            for (int j = 1; j <= n; j++){
                dist[j] = Math.min(dist[j],dist[t] + g[t][j]);
            }
        }
        if (dist[n] == 200000)return -1;//判断该结点是否是连通的，如果没有连通，则返回-1
        return dist[n];//如果结点已经连通，则直接放回其与初始结点的距离
    }
}
