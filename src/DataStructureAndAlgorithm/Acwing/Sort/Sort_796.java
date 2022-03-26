package DataStructureAndAlgorithm.Acwing.Sort;

import java.util.*;

public class Sort_796 {
    static Scanner sc = new Scanner(System.in);

    static void init(int[][] arr){
        for(int i = 1; i < arr.length;i++){
            for(int j = 1; j < arr[0].length;j++){
                arr[i][j] = sc.nextInt();
            }
        }
    }

    static void sinit(int[][] arr,int[][] res){
        for(int m = 1;m < arr.length;m++){
            for(int n = 1; n < arr[0].length;n++){
                res[m][n] = res[m-1][n] + res[m][n-1] - res[m-1][n-1] + arr[m][n];
            }
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int temp = sc.nextInt();

        int[][] arr = new int[n+1][m+1];
        int[][] res = new int[n+1][m+1];
        init(arr);
        sinit(arr,res);

        while(temp-- > 0){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int result = res[x2][y2] - res[x2][y1 - 1] - res[x1 - 1][y2] + res[x1-1][y1-1];


            System.out.println(result);
        }
    }
}
