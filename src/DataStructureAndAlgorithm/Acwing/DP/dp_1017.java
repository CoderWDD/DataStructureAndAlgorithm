package DataStructureAndAlgorithm.Acwing.DP;

import java.util.Scanner;
/*
最长上升子序列的状态定义：
    dp[i]：表示所有以nums[i]结尾的子序列中最长的上升子序列（即子问题是规模变小了的总问题，这也是可以用动态规划的前提）
    当nums[i] > nums[j] ：dp[i] = Math.max(dp[i],dp[j] + 1);
    否则：dp[i] = 1；
*/
public class dp_1017 {
    public static void main(String[] args){
        int[] dp = new int[110];
        int[] nums = new int[110];
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n,res = 0;
        while(k-- > 0){
            n = in.nextInt();
            //对于每一次求解，都要把res归零
            res = 0;
            //正着求一遍最长上升子序列
            for(int i = 1; i <= n; i++){
                nums[i] = in.nextInt();
                dp[i] = 1;
                for(int j = 1; j < i; j++){
                    if (nums[i] > nums[j]){
                        dp[i] = Math.max(dp[i],dp[j] + 1);
                    }
                }
                res = Math.max(res,dp[i]);
            }
            //反着求一遍最长上升自学列（相对于正着求最长下降子序列）
            for (int i = n; i >= 1; i--){
                dp[i] = 1;
                for (int j = n; j > i; j--){
                    if (nums[i] > nums[j]){
                        dp[i] = Math.max(dp[i],dp[j] + 1);
                    }
                }
                res = Math.max(res,dp[i]);
            }
            System.out.println(res);
        }
    }
}
