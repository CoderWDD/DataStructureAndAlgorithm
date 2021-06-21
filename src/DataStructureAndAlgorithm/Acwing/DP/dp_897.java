package DataStructureAndAlgorithm.Acwing.DP;

import java.util.Scanner;

public class dp_897 {

    public static void main(String[] args){
        int N,M;
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        String As = in.next();
        String Bs = in.next();
        char[] A = new char[N+1];
        char[] B = new char[M+1];
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++){
            A[i] = As.charAt(i-1);
        }
        for (int i = 1; i <= M; i++){
            B[i] = Bs.charAt(i-1);
        }
        for (int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]);
                if (A[i] == B[j]){
                    dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - 1] + 1);
                }
            }
        }
        System.out.print(dp[N][M]);
    }
}
