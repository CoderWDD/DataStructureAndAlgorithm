package DataStructureAndAlgorithm.Acwing.Sort;

//已知a1,a2,a3,...,an
//构造b1,b2,b3,...,bn
//使b是a的差分，a是b的前缀和

import java.util.Scanner;

public class Sort_797 {
    static void inita(int[] a, int[] b, int n) {
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n + 2];
        int[] b = new int[n + 2];

        for (int i = 1; i < n + 1; i++) {
            a[i] = sc.nextInt();
            b[i] = a[i] - a[i - 1];
        }

        while (m-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int c = sc.nextInt();

            b[l] = b[l] + c;
            b[r + 1] = b[r + 1] - c;

        }
        inita(a, b, n + 1);


        for (int i = 1; i < n + 1; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
