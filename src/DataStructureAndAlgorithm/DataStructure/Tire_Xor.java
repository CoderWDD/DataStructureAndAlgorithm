package DataStructureAndAlgorithm.DataStructure;
import java.util.*;
//原题链接：https://www.acwing.com/problem/content/145/
public class Tire_Xor {
    static int N = 100010 , M = 3100010;
    static int[][] son = new int[M][2];//把最大的结点空间全部提前申请出来
    static int idx = 0;
    static void insert(int x){
        int p = 0;
        for (int i = 30; i >= 0; i--){
            int  u = x >> i & 1;
            if (son[p][u] == 0){
                //如果当前结点下面没有u的分支，则创建一个
                son[p][u] = ++idx;
            }
            p = son[p][u];
        }
    }
    static int query(int x){
        int p = 0,res = 0;
        for (int i = 30; i >= 0; i--){
            int u = x >> i & 1;
            u = (~u) & 1;
            if (son[p][u] != 0){
                //如果当前结点下面有u的分支
                res = res * 2 + u;
                p = son[p][u];
            }else{
                u = (~u) & 1;
                res = res * 2 + u;
                p = son[p][u];
            }
        }
        return res;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int temp,res = 0,ret;
        for (int i = 0; i < n; i++){
            temp = in.nextInt();
            //一边插入，一边查询
            //因为先全部插入后，前面的会和后面的重复异或，没有意义（即a与b的异或和b与a的异或是一样的）
            //所以一边插入一边查询可以避免两次异或，提高效率
            insert(temp);
            ret = query(temp);
            res = Math.max(res,temp ^ ret);
        }
        System.out.print(res);
    }
}
