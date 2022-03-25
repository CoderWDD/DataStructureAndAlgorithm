package DataStructureAndAlgorithm.Acwing.Sort;

import java.util.*;

//前缀和：对于给定数组a1，a2，……，an
//前缀和si = a1+a2+……+ai；
//作用：求数组内某一段区间的和

public class Sort_795 {
    static int N = 10010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[N];
        int[] s = new int[N];
        int n = sc.nextInt();
        int m = sc.nextInt();
        s[0] = 0;

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + a[i];

        while(m-- > 0){
            int l = sc.nextInt();
            int r = sc.nextInt();

            System.out.println(s[r] - s[l - 1]);
        }
    }
}

