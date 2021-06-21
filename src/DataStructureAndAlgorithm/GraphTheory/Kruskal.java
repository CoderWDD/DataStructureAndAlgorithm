package DataStructureAndAlgorithm.GraphTheory;
import java.util.*;
class Edges implements Comparable <Edges>{
    int a,b,w;
    Edges(int a,int b,int w){
        this.a = a;
        this.b = b;
        this.w = w;
    }
    @Override
    public int compareTo(Edges temp){
        return this.w - temp.w ;
    }
    // @Override
    // public String toString(){
    //     return this.a + " " + this.b + " " + this.w;
    // }
}
//原题链接: https://www.acwing.com/problem/content/description/861/
public class Kruskal {
    static int N = 200010;
    static int n,m;
    static int[] p = new int[N];
    static Edges[] e;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        e = new Edges[m];
        int a,b,w;
        int res = 0,cnt = 0;
        for (int i = 0; i < m; i++){
            a = in.nextInt();b = in.nextInt(); w = in.nextInt();
            //将所有点之间的信息读入到一起
            e[i] = new Edges(a,b,w);
        }
        //将所有边按从小到大进行排序
        Arrays.sort(e);
        for (int i = 1; i <= n; i++){
            p[i] = i;
        }
        for (int i = 0; i < m; i++){
            a = e[i].a;
            b = e[i].b;
            w = e[i].w;
            //根据是否有相同的父节点，判断是否已经在一个集合中
            a = find(a);
            b = find(b);
            //若还不在同一个集合中，则将其中一个集合连入已有集合
            if (a != b){
                p[a] = b;
                res += w;
                cnt++;
            }
        }
        //N个点，最少要有n-1条边，才能保证所有的点是连通的
        if (cnt < n - 1)System.out.print("impossible");
        else System.out.print(res);
    }
    //并查集的模板
    static int find(int x){
        if(p[x] != x)
        {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
