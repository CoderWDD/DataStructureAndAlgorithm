package DataStructureAndAlgorithm.GraphTheory;
import java.util.*;
//原题链接：https://www.acwing.com/problem/content/description/856/
public class Floyd {
    //适用范围：多源最短路径问题
    //如果要求任意一个点到其他点的最短路径，则可以使用Floyd算法。
    //算法复杂度:O(N^3)
    static int N = 210,Max_Value = Integer.MAX_VALUE/2;
    static int n,m,k;
    static int[][] d = new int[N][N];
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= n; j++){
                if (i == j)d[i][j] = 0;
                else d[i][j] = Max_Value;
            }
        }
        int a,b,c;
        for (int i = 0; i < m; i++){
            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            d[a][b] = Math.min(d[a][b],c);
        }
        floyd();
        for (int i = 0; i < k; i++){
            a = in.nextInt();
            b = in.nextInt();
            if (d[a][b] > Max_Value/2)System.out.println("impossible");
            else System.out.println(d[a][b]);
        }
    }
    //原理：基于动态规划实现的算法
    static void floyd(){
        for (int z = 1; z <= n; z++){
            for (int i = 1; i <= n; i++){
                for (int j = 1; j <= n; j++){
                    d[i][j] = Math.min(d[i][j],d[i][z] + d[z][j]);
                }
            }
        }
    }
}
