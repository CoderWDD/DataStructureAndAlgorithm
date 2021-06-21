package DataStructureAndAlgorithm.Acwing.DP;

import java.util.Scanner;

class dp_272{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums1 = new int[n + 1];
        int[] nums2 = new int[n + 1];
        //读入两个数列
        for (int i = 1; i <= n; i++){
            nums1[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++){
            nums2[i] = in.nextInt();
        }
        //dp[i][j]：表示所有在nums1[1~i]和nums2[1~j]中都出现过，且以nums2[j]结尾的公共上升子序列的集合
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1;i <= n; i++){
            int max = 1;
            for (int j = 1; j <= n; j++){
                dp[i][j] = dp[i - 1][j];
                if (nums1[i] == nums2[j]){
                    dp[i][j] = Math.max(max,dp[i][j]);
                }
                if (nums2[j] < nums1[i]){
                    max = Math.max(max,dp[i - 1][j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++){
            res = Math.max(res,dp[n][i]);
        }
        System.out.print(res);
    }
}