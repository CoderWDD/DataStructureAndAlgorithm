package com.company;
import java.util.*;
public class NOIP2002_P1002 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int res = P1002(n,m,x,y);
        System.out.print(res);
    }
    //输入棋盘右下角的点的坐标，和🐎所在的点的坐标
    public static int P1002(int n,int m,int x,int y){
        //(n,m):表示棋盘大小
        //(x,y):表示马的坐标
        if (check(0,0,x,y,n,m))return 0;
        //dp[i][j] ：表示从(0,0)到达点(i,j)时的路径数
        int[][] dp = new int[n + 1][m + 1];
        //状态表示: dp[i][j] = dp[i-1][j] + dp[i][j-1];
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++){
            if (check(x,y,0,i,n,m)){
                dp[0][i] = 1;
            }else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i <= n; i++){
            if (check(x,y,i,0,n,m)){
                dp[i][0] = 1;
            }else {
                dp[i][0] = 0;
            }
        }
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (check(x,y,i,j,n,m)){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    System.out.println(dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[n-1][m-1];
    }
    private static boolean check(int a,int b,int x,int y,int n,int m){
        //(a,b):马所在的坐标
        //(x,y):要检验的点的坐标
        //(n,m):终点的坐标
        if (a - 2 >= 0){
            if (b - 1 >= 0){
                if (x == a - 2 && y == b - 1){
                    return false;
                }
            }
            if (b + 1 <= m){
                if (x == a - 2 && y == b + 1){
                    return false;
                }
            }
        }
        if (a - 1 >= 0){
            if (b - 2 >= 0){
                if (x == a - 1 && y == b - 2){
                    return false;
                }
            }
            if (b + 2 <= m){
                if (x == a - 1 && y == b + 2){
                    return false;
                }
            }
        }
        if (a + 1 <= n){
            if (b - 2 >= 0){
                if (x == a + 1 && y == b - 2){
                    return false;
                }
            }
            if (b + 2 <= m){
                if (x == a + 1 && y == b + 2){
                    return false;
                }
            }
        }
        if (a + 2 <= n){
            if (b - 1 >= 0){
                if (x == a + 2 && y == b - 1){
                    return false;
                }
            }
            if (b + 1 <= m){
                if (x == a + 2 && y == b + 1){
                    return false;
                }
            }
        }
        return true;
    }
}
