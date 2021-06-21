package DataStructureAndAlgorithm.LeetCode.Tire;
//原题链接：https://leetcode-cn.com/problems/longest-word-in-dictionary/
public class LongestWordInDictionary {
    int[][] son = new int[300010][26];
    int[] cnt = new int[300010];
    int idx = 0;
    public String longestWord(String[] words) {
        String res = "";
        for (int i = 0; i < words.length; i++){
            insert(words[i]);
        }
        for (int i = 0; i < words.length; i++){
            if (query(words[i])){
                res = compare(res,words[i]);
            }
        }
        return res;
    }
    String compare(String str1,String str2){
        if (str1.length() == str2.length()){
            //长度相等，就放回字典序小的那个
            if (str1.compareTo(str2) > 0){
                return str2;
            }else if (str1.compareTo(str2) < 0){
                return str1;
            }else return str1;
        }else {
            System.out.print(str1 + " ");
            return str1.length() > str2.length() ? str1 : str2;
        }
    }
    void insert(String str){
        int p = 0;
        int u;
        for (int i = 0; i < str.length(); i++){
            u = str.charAt(i) - 'a';
            if (son[p][u] == 0)son[p][u] = ++idx;
            p = son[p][u];
        }
        cnt[p]++;
    }
    boolean query(String str){
        int p = 0;
        int u;
        for (int i = 0; i < str.length(); i++){
            u = str.charAt(i) - 'a';
            //字典中没有这个单词或者没有组成该单词的子单词，直接放回fasle
            if (son[p][u] == 0 || ( p != 0 && cnt[p] == 0))return false;
            p = son[p][u];
        }
        return true;
    }
}
