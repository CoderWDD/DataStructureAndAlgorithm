package DataStructureAndAlgorithm.Acwing.BaseAlgorithm;

import java.util.Scanner;

class base_796{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        int[][] react = new int[n + 1][m + 1];
        int[][] pre = new int[n + 1 ][m + 1];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                react[i][j] = in.nextInt();
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + react[i][j];
            }
        }
        int x1,y1,x2,y2;
        int res = 0;
        for (int i = 1; i <= q; i++){
            x1 = in.nextInt();
            y1 = in.nextInt();
            x2 = in.nextInt();
            y2 = in.nextInt();
            res = query(x1,y1,x2,y2,pre);
            System.out.println(res);
        }
    }
    private static int query(int x1,int y1,int x2,int y2,int[][] pre){
        return pre[x2][y2] - pre[x1 - 1][y2] - pre[x2][y1 - 1] + pre[x1 - 1][y1 - 1];
    }
}
