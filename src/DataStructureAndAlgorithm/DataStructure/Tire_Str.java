package DataStructureAndAlgorithm.DataStructure;
import java.util.*;
//原题链接：https://www.acwing.com/problem/content/837/
public class Tire_Str {
    static int N = 100010;
    static int[] cnt = new int[N];//用于作为单词结束的标志
    static int[][] son = new int[N][26];//用于保存所有的结点，26为字母的个数，即为所有基本情况的总数即可
    static int idx;
    //insert用于向字典树中添加单词
    static void insert(String str){
        int p = 0;
        //遍历整个字符串，将其中的字符挨个存入
        for (int i = 0; i < str.length(); i++){
            int u = str.charAt(i) - 'a';
            //如果没有找到子结点，就创建一个
            if ( son[p][u] == 0 )son[p][u] = ++idx;
            //添加完结点之后将指针向下移动
            p = son[p][u];
        }
        cnt[p]++;
    }
    //query用于查找字典树中的单词
    public static int query (String str){
        int p = 0;
        for (int i = 0; i < str.length(); i ++){
            int u = str.charAt(i) - 'a';
            if (son[p][u] == 0)return 0;
            p = son[p][u];
        }
        return cnt[p];
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String a1,a2;
        for (int i = 0; i < n ; i++){
            a1 = in.next();
            a2 = in.next();
            if (a1.equals("I"))insert(a2);
            else System.out.println(query(a2));
        }

    }

}
