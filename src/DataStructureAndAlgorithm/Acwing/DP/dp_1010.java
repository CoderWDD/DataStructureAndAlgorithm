package DataStructureAndAlgorithm.Acwing.DP;

import java.util.Scanner;

public class dp_1010 {
    public static void main(String[] args){
        int[] nums = new int[1010];
        int[] dp = new int[1010];
        int i = 0,res = 0;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            nums[i] = in.nextInt();
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[j] >= nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            res = Math.max(res,dp[i++]);
        }
        System.out.println(res);

        //贪心的正确性证明：
        //1.A=B ：A >= B,B >= A
        //2.方法:调整法
        //贪心做第二问:
        //对于一个序列：
        //其最长上升子序列的方案数 = 覆盖他的所有非上升子序列的方案数的最小值
        //cnt表示需要的系统数
        int cnt = 0;
        //g[]数组存储cnt个合法子序列中结尾的数
        int[] g = new int[1010];

        for (int j = 0; j < i; j++){
            //k为g[]的下标，用于判断查找第一个大于当前数的最小的数
            int k = 0;
            //将k定位到第一个大于nums[i]的数的位置
            while (k < cnt && g[k] < nums[j])k++;
            //把g[k]用nums[i]替换
            g[k] = nums[j];
            //如果k已经移动到数组末尾了。则要重新创建一个新的子序列，即cnt++
            if (k >= cnt) cnt++;
        }
        System.out.println(cnt);
    }
}
