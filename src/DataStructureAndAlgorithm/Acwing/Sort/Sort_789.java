package DataStructureAndAlgorithm.Acwing.Sort;

import java.util.*;

//二分的本质不是单调性，有单调性一定可以二分，可以二分的题目不一定要有单调性
//整数二分
//可以找到某种性质使区间一分为二，二分可以找到边界点

public class Sort_789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//一共有多少个
        int m = sc.nextInt();//询问个数
        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();

        while (m-- > 0){
            int x = sc.nextInt();//标志的数

            int l = 0 ,r = n - 1;
            while(l < r){
                int mid = l + r >> 1;
                if(arr[mid] >= x) r = mid;
                else l = mid + 1;
            }

            if(arr[l] != x) System.out.println("-1 -1");
            else{
                System.out.print(l + " ");
                l = 0 ;
                r = n - 1;
                while(l < r){
                    int mid = l + r + 1 >> 1;
                    if(arr[mid] <= x) l = mid;
                    else r = mid - 1;
                }

                System.out.println(l);
            }
        }
    }
}

