package DataStructureAndAlgorithm.BaseAlgorithm;
import java.util.*;
//原题链接：https://www.acwing.com/problem/content/871/
public class 试除法求约数 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k ;
        for (int i = 0; i < n; i++){
            k = in.nextInt();
            Integer[] res = Get_divisors(k);
            for (Integer e : res){
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
    static Integer[] Get_divisors(int num){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1 ; i <= num / i; i++){
            if (num % i == 0){
                list.add(i);
                if (i != num / i) list.add(num/i);
            }
        }
        Integer[] res = new Integer[list.size()];
        list.toArray(res);
        Arrays.sort(res);
        return res;
    }
}
