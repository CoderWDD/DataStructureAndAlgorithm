package DataStructureAndAlgorithm.Acwing.Sort;

import java.util.*;

//找出第k小的数 快排➕快选

public class Sort_786 {
    public static int quick_sort(int[] arr,int l, int r, int k){
        if(l == r) return arr[l]; //区间为1则返回

        int flag = arr[l], i = l - 1, j = r + 1;
        while (i < j){
            while(arr[++i] < flag);
            while(arr[--j] > flag);
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int s1 = j - l + 1;
        if(k <= s1) return quick_sort(arr,l,j,k);
        return quick_sort(arr,j + 1,r,k - s1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(quick_sort(arr,0,n - 1,k));
    }
}
