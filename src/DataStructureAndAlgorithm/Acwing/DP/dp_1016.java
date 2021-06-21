package DataStructureAndAlgorithm.Acwing.DP;
import java.util.Scanner;

/*
    解题思路：
        本质还是求最长上升子序列，只不过此处不再是求长度，而是和，只需要求状态的定义改变一下即可，即：
        dp[i]：表示所有以nums[i]结尾的子序列中最长的上升子序列的和
        最长上升子序列和的状态定义：

    dp[i]：表示所有以nums[i]结尾的子序列中最长的上升子序列的和（即子问题是规模变小了的总问题，这也是可以用动态规划的前提）
    当nums[i] > nums[j] ：dp[i] = Math.max(dp[i],dp[j] + nums[i]);
    否则：dp[i] = nums[i]；
*/
public class dp_1016 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] dp = new int[n + 1];
        int[] nums = new int[n + 1];
        int res = 0;
        for (int i = 1; i <= n; i++){
            nums[i] = in.nextInt();
            dp[i] = nums[i];
            for (int j = 1; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + nums[i]);
                }
            }
            res = Math.max(res,dp[i]);
        }
        System.out.print(res);
    }
}
