package DataStructureAndAlgorithm.Acwing.Sort;

//双指针算法模版
//for(int i = 0, j = 0 ; i < n;i++){
//        while (j < i && check(i,j)) j++;
//
//
//        每道题目的具体逻辑
//
//
//    }

import java.util.Scanner;

public class Sort_799 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] temp = new int[100010];

        for(int i = 0 ;i < n;i++){
            arr[i]=sc.nextInt();
        }

        int res = 0;
        for(int i = 0,j=0; i < n;i++){
            temp[arr[i]]++;
            while (j < i && temp[arr[i]] > 1){
                temp[arr[j]]--;
                j++;
            }
            res = Math.max(res,i-j+1);
        }

        System.out.println(res);
    }
}
