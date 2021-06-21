package DataStructureAndAlgorithm.LeetCode.DynamicProgramming;
//原题链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs/
public class MinCostClimbingStairs {
    //优化的代码
    public int MinCostClimbingStairs(int[] cost) {
        int first = 0, second = 0;
        int temp;
        for (int i = 2; i <= cost.length; i++){
            temp = Math.min(second + cost[i-1],first + cost[i-2]);
            first = second;
            second = temp;
        }
        return second;
    }


//     未优化版本代码
//     public int MinCostClimbingStairs(int[] cost) {
//         //dp[i]：表示从第0/1阶到第i阶的最小消耗体力，因此dp[n]即为所求
//         //dp[i]  = Math.min(dp[i-1] + cost[i-1],dp[i-2] + cost[i-2]);
//         int len = cost.length;
//         int[] dp = new int[len + 1];
//         //显然，0/1阶是出发点，所以，到达0/1阶的体力消耗为0
//         dp[0] = 0;
//         dp[1] = 0;
//         for (int i = 2; i <= len; i++){
//             dp[i] = Math.min(dp[i-1] + cost[i-1],dp[i-2] + cost[i-2]);
//         }
//         return dp[len];
//     }
}
