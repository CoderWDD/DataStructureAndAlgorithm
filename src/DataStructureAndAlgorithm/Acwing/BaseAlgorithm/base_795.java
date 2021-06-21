package DataStructureAndAlgorithm.Acwing.BaseAlgorithm;

import java.util.Scanner;

class base_795{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums = new int[n + 1];
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++){
            nums[i] = in.nextInt();
            pre[i] = pre[i - 1] + nums[i];
        }
        int l,r;
        for (int i = 0; i < m; i++){
            l = in.nextInt();
            r = in.nextInt();
            System.out.println(pre[r] - pre[l - 1]);
        }
    }
}