package DataStructureAndAlgorithm.GraphTheory;
import java.util.*;
//原题链接：https://www.acwing.com/problem/content/description/862/
public class 染色法判定二分图 {
    static int N = 100010, M = 200010;
    static int idx = 0,n,m;
    static int[] e = new int[M] , ne = new int [M], h = new int[N];
    static int[] color = new int[N];
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h,-1);//初始化邻接表的所有头结点为-1
        int a,b;
        for (int i = 0; i < m; i++){
            a = in.nextInt();
            b = in.nextInt();
            //无向图，每两个点间添加两条边
            add(a,b);
            add(b,a);
        }
        boolean flag = true;
        //枚举每个点，对每个点进行染色
        for (int i = 1; i <= n; i++){
            //判断当前点是否已经染色
            if (color[i] == 0){
                //深搜对每个点进行染色
                if (!Dfs(i,1)){
                    //如果深搜染色过程存在矛盾，则说明不为二分图
                    flag = false;
                    break;
                }
            }
        }
        if (flag)System.out.print("Yes");
        else System.out.print("No");
    }
    //邻接表存储图的经典模板
    static void add(int a,int b){
        e[idx] = b;ne[idx] = h[a];h[a] = idx++;
    }
    static boolean Dfs(int u,int c){
        color[u] = c;
        //遍历所有与u结点相连的结点
        for (int i = h[u]; i != -1; i = ne[i]){
            int j = e[i];
            //判断结点是否已经染色
            if (color[j] == 0){
                //判断染色过程是否有矛盾
                //0：为染色；1：表示黑色；2：表示白色
                //3-c即可将1和2两种颜色进行间隔染色
                if (!Dfs(j,3-c)) return false;
                //如果遍历到与u相连的结点已经染色，且颜色与u结点的颜色相同，则说明存在矛盾，直接return false
            }else if (color[j] == c) return false;
        }
        return true;
    }
}
