package DataStructureAndAlgorithm.GraphTheory;
import java.util.*;
//原题链接：https://www.acwing.com/problem/content/description/863/
public class 匈牙利算法 {
    //理解：姑娘 j 遇到新的追求者的心理活动：如果原来的男朋友有备胎，我就绿他，如果没有，那我看他太可怜了，就一直跟他在一起吧。
    static int N = 510,M = 200010;
    static int[] h = new int[N], e = new int[M],ne = new int[M];
    static int[] match = new int[N];
    static boolean[] st = new boolean[N];
    static int n1,n2,m,idx = 0;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n1 = in.nextInt();
        n2 = in.nextInt();
        m = in.nextInt();
        //初始化邻接表的所有头结点为-1
        Arrays.fill(h,-1);
        int a,b,res = 0;
        //读入所有的边，同时建图
        for(int i = 0; i < m; i++){
            a = in.nextInt();
            b = in.nextInt();
            add(a,b);
        }
        //遍历n1集合中的所有点，并将所有可以匹配的点进行匹配
        for (int i = 1; i <= n1; i++){
            //每次循环都要重置一次st数组，因为在find函数中，st数组是用于与指定点相连的点是否已经被该结点遍历过的，所有每次都要重置
            Arrays.fill(st,false);
            if (find(i))res++;
        }
        System.out.print(res);
    }
    //邻接表存图的经典模板
    static void add(int a,int b){
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
    }
    //判断是否可以找到可以与x点匹配的点
    static boolean find(int x){
        //遍历所有与x点相连的点
        for (int i = h[x]; i != -1; i = ne[i]){
            int j = e[i];
            //将当前结点置为已经使用过
            if (!st[j]){
                st[j] = true;
                //判断j结点是否为匹配，或者之前与j结点匹配的结点是否可以与其他结点匹配，从而把j点空出来
                if (match[j] == 0 || find(match[j])){
                    //将x与j结点匹配
                    match[j] = x;
                    return true;
                }
            }
        }
        return false;
    }
}
