package DataStructureAndAlgorithm.LeetCode.Tire;
import java.util.*;
//原题链接：https://leetcode-cn.com/problems/camelcase-matching/

class node{
    char ch;
    boolean isEnd = false;
    node next  = null;
    public void ndoe(){
        this.next = new node();
    }
}


public class CamelcaseMatching {
    Boolean check(String str,node root){
        char ch ;
        node cur = root.next;
        for (int i = 0; i < str.length() && cur != null; i++){
            ch = str.charAt(i);
            //对于不是最后一个字符，而pattern的字符已经匹配完，但还有大写字母的情况
            if (ch >= 'A' && ch <= 'Z'){
                if (cur.isEnd == true || cur.ch != ch)
                    return false;
            }
            if (cur.ch == ch){
                cur = cur.next;
            }
        }
        if(cur.isEnd != true)return false;
        return true;
    }
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        node root = new node();
        node cur = root;
        char temp;
        //insert
        for (int i = 0; i < pattern.length(); i++){
            temp = pattern.charAt(i);
            cur.next = new node();
            cur = cur.next;
            cur.ch = temp;
            if (i == pattern.length() - 1){
                //到最后一个字符时，加一个结束结点作为标志
                cur.next = new node();
                cur = cur.next;
                cur.isEnd = true;
            }
        }
        //query
        for (int i = 0; i < queries.length; i++){
            res.add(check(queries[i],root));
        }
        return res;
    }
}
