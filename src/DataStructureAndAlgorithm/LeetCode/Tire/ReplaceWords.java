package DataStructureAndAlgorithm.LeetCode.Tire;
import java.util.*;
//原题链接：https://leetcode-cn.com/problems/replace-words/
public class ReplaceWords {
    int[][] son = new int[100010][26];
    int[] cnt = new int[100010];
    int idx = 0;
    public String replaceWords(List<String> dictionary, String sentence) {
        for (String e : dictionary){
            insert(e);
        }
        String[] str = sentence.split(" ");
        System.out.println(str.length);
        String temp = "";
        String res = "";
        for (int i = 0; i < str.length; i++){
            temp = query(str[i]);
            //找不到字根
            if (temp.equals("")){
                if (i != str.length - 1)
                    res = res + str[i] + " ";
                else res = res + str[i];
            }else{
                if (i != str.length - 1)
                    res = res + temp + " ";
                else res = res + temp;
            }
        }
        return res;
    }
    void insert(String str){
        int p = 0,u;
        for (int i = 0; i < str.length(); i++){
            u = str.charAt(i) - 'a';
            if (son[p][u] == 0)son[p][u] = ++idx;
            p = son[p][u];
        }
        cnt[p]++;
    }
    String query(String str){
        int p = 0, u;
        String res = "";
        for (int i = 0; i < str.length(); i++){
            u = str.charAt(i) - 'a';
            if (cnt[p] != 0)return res;
            if (son[p][u] == 0)return "";//判断找不到的情况
            res = res + str.charAt(i);
            p = son[p][u];
        }
        return res;
    }
}
