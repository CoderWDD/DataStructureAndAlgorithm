package DataStructureAndAlgorithm.Acwing.DP;

import java.util.Scanner;
/*
最长上升子序列的状态定义：
    dp[i]：表示所有以nums[i]结尾的子序列中最长的上升子序列（即子问题是规模变小了的总问题，这也是可以用动态规划的前提）
    当nums[i] > nums[j] ：dp[i] = Math.max(dp[i],dp[j] + 1);
    否则：dp[i] = 1；
*/
class dp_1014{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n + 1];
        int[] dp_z = new int[n + 1];
        int[] dp_f = new int[n + 1];
        //正着求最长上升子序列
        for (int i = 1; i <= n; i++){
            nums[i] = in.nextInt();
            dp_z[i] = 1;
            for (int j = 1; j < i; j++){
                if (nums[i] > nums[j]){
                    dp_z[i] = Math.max(dp_z[i],dp_z[j] + 1);
                }
            }
        }
        //反着求最长上升子序列
        for (int i = n; i >= 1; i--){
            dp_f[i] = 1;
            for (int j = n; j > i; j--){
                if (nums[i] > nums[j]){
                    dp_f[i] = Math.max(dp_f[i],dp_f[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++){
            //因为状态定义中dp[i]是包含第i个数的，所以，第i个数会被算两遍，减1即可
            res = Math.max(res,dp_f[i] + dp_z[i] - 1);
        }
        System.out.print(res);
    }
}