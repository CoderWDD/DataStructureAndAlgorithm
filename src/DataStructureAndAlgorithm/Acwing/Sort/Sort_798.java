package DataStructureAndAlgorithm.Acwing.Sort;

import java.util.*;

public class Sort_798 {
    static Scanner sc = new Scanner(System.in);

    static void inita(int[][] a) {
        for (int i = 1; i < a.length - 1; i++) {
            for (int j = 1; j < a[0].length - 1; j++) {
                a[i][j] = sc.nextInt();
            }
        }
    }

    static void initb(int[][] a, int[][] b) {
        for (int i = 1; i < b.length - 1; i++) {
            for (int j = 1; j < b[0].length - 1; j++) {
                b[i][j] = a[i][j] - a[i - 1][j] - a[i][j - 1] + a[i - 1][j - 1];
            }
        }
    }

    static void result(int[][] a, int[][] b) {
        for (int i = 1; i < a.length - 1; i++) {
            for (int j = 1; j < a[0].length - 1; j++) {
                a[i][j] = a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1] + b[i][j];
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        int[][] a = new int[n + 2][m + 2];
        int[][] b = new int[n + 2][m + 2];

        inita(a);
        initb(a, b);

        while (q-- > 0) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int c = sc.nextInt();

            b[x1][y1] += c;
            b[x2 + 1][y1] -= c;
            b[x1][y2 + 1] -= c;
            b[x2 + 1][y2 + 1] += c;
        }
        result(a, b);


    }
}
