package DataStructureAndAlgorithm.GraphTheory;
import java.util.*;
class str{
    int a;
    int b;
    int c;
    str(int a,int b,int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
//原题链接：https://www.acwing.com/problem/content/855/
public class Bellmanford {
    static int Max_Value = 800000;
    static int N = 510;
    static int M = 10010;
    static int n,m,k;
    static int[] dist = new int[N];
    static int[] back_up = new int[N];
    static str[] edges = new str[M];
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        for (int i = 0; i < m; i++){
            int a,b,c;
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            edges[i] = new str(a,b,c);
        }
        int res = bellman_ford();
        if (res == -1)System.out.print("impossible");
        else
            System.out.print(res);
    }
    static int bellman_ford(){
        //一定要记得初始化，支持存在负权重
        //可以用于判断负环，但不能用于有负环的求最短路径
        Arrays.fill(dist,Max_Value);
        dist[1] = 0;//这里dist[i] = 0，是指起点，修改i的值即可求不同起点到不同点的最短路径
        //进行n-1次松弛操作，即可将n个点的最短路径更新出来
        //back_up数组：用于限制边数时防止串联菜用到的
        //算法的重点在于对每一个点都循环访问，并依次松弛每个点，同时更新相邻点的最短距离
        //到最后一次循环结束时，所有的点都被松弛过了。也即起点到所有点的最短距离都被更新出来了
        for (int i = 0; i < n-1; i++){
            //back_up = Arrays.copyOf(dist,N);
            for (int j = 0; j < m; j++){
                int a,b,w;
                a = edges[j].a;
                b = edges[j].b;
                w = edges[j].c;
                dist[b] = Math.min(dist[b],dist[a] + w);
            }
        }
        if (dist[n] > Max_Value/2)return -1;
        return dist[n];
    }
}
