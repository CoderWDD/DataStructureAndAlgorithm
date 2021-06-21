package DataStructureAndAlgorithm.Acwing.BaseAlgorithm;

import java.util.Scanner;

//由于对于每个数，都可以认为是插入进去的，只需设定a[][]初始为0即可
class base_798{
    static int[][] a = new int[1010][1010];
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        int temp;
        //先把原数组创建出来
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                temp = in.nextInt();
                insert(i,j,i,j,temp);
            }
        }
        //将所有的操作都进行一遍
        int x1,x2,y1,y2,num;
        for (int i = 1; i <= q; i++){
            x1 = in.nextInt();
            y1 = in.nextInt();
            x2 = in.nextInt();
            y2 = in.nextInt();
            num = in.nextInt();
            insert(x1,y1,x2,y2,num);
        }
        //计算出矩阵的前缀和，即为操作后的结果
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                a[i][j] = a[i][j - 1] + a[i - 1][j] - a[i - 1][j - 1] + a[i][j];
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void insert(int x1,int y1,int x2,int y2,int num){
        a[x1][y1] += num;
        a[x1][y2 + 1] -= num;
        a[x2 + 1][y1] -= num;
        a[x2 + 1][y2 + 1] += num;
    }
}