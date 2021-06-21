package DataStructureAndAlgorithm.Acwing.DP;
/*
完全背包的状态转移方程推导:
    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - i * 1] + dp[i - 1][j - i * 2] + .... + dp[i - 1][j - i * k];
    dp[i][j - i] =            dp[i - 1][j - i * 1] + dp[i - 1][j - i * 2] + .... + dp[i - 1][j - i * k];
    所以有dp[i][j] = dp[i - 1][j] + dp[i][j - i];

得到状态方程之后，再来考虑优化:
    由于每次都只要用到的i-1的值，因此，可以用滚动数组的方式优化，
    因而，在更新当前状态时，我们都希望未更新的数组中的值为上一次循环的值，因此，要从小到大循环
    从而可以将二维的状态方程优化为：
        dp[i][j] = dp[i-1][j] + dp[i][j-i];
*/

/*
将问题等价转换成1~n的完全背包问题，用完全背包问题的方法进行分析解决即可
dp中的j表示的是体积，由于需要用到当前第i次的状态。因此，要从小到大枚举
*/
import java.util.*;

public class dp_900{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double mod = 1e9 + 7;
        int n = in.nextInt();
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i <= n; i++)dp[i][0] = 1;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j <= n; j++){
                dp[i][j] = dp[i-1][j] % (int)mod;
                if (j >= i)
                    dp[i][j] = (dp[i-1][j] + dp[i][j-i]) % (int)mod;
            }
        }
        System.out.print(dp[n][n]);
    }
}

//优化后的版本
//import java.util.Scanner;
//class Main{
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int mod = 1000000000 + 7;
//        int[] dp = new int[n + 1];
//        //从前i个中选，恰好等于0的情况的总数为0
//        //此处的初始化相当于二维中初始化了dp[i][0] = 1;
//        dp[0] = 1;
//        for (int i = 1; i <= n; i++){
//            for (int j = i; j <= n; j++){
//                dp[j] = (dp[j] + dp[j - i]) % mod;
//            }
//        }
//        System.out.print(dp[n]);
//    }
//}