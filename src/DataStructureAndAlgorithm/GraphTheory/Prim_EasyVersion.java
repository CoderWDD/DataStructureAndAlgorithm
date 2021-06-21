package DataStructureAndAlgorithm.GraphTheory;
import java.util.*;
//原题链接：https://www.acwing.com/problem/content/860/
public class Prim_EasyVersion {
    static int N = 510,Max_Value = 999999;
    static int[][] grid = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    static int n,m;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        //初始化所有的边为无穷大，无法到达
        for (int i = 0; i < N; i++){
            Arrays.fill(grid[i],Max_Value);
        }
        int a,b,c;
        for (int i = 0; i < m; i++){
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            //无向图，因此每两个点之间建立两条边
            grid[a][b] = grid[b][a] = Math.min(grid[a][b],c);
        }
        int res = Prim();
        if (res == Max_Value)System.out.print("impossible");
        else System.out.print(res);
    }
    static int Prim(){
        int res = 0;
        //初始化dist[]数组的距离为无穷大
        Arrays.fill(dist,Max_Value);
        //先随机选择一个点，作为最小生成树的一个点
        for (int i = 0; i < n; i++){
            int t = -1;
            //找出离最小生成树的集合中距离最短的一个点 ----》 区别于Dijkstra算法是找出里源点距离最短的点
            for (int j = 1; j <= n; j++){
                if (!st[j] && (t == -1 || dist[t] > dist[j])){
                    t = j;
                }
            }
            if (i != 0 && dist[t] == Max_Value)
                return Max_Value;
            //必须先把dist[t]加入res中，然后再更新其他的点，否则对于出现自环的情况，dist[t]可能会被改变，导致结果不正确
            if (i != 0)res = res + dist[t];
            //更新最小生成树集合外的所有点到集合的距离
            for (int j = 1; j <= n; j++){
                dist[j] = Math.min(dist[j],grid[t][j]);
            }
            //将加入状态置为true
            st[t] = true;
        }
        return res;
    }
}
