package DataStructureAndAlgorithm.Acwing.Sort;

import java.util.*;

//归并排序  确定分界点+递归排序+归并（归并排序是稳定的）
//分界点：mid = （l + r）/2
//时间复杂度：O(nlog2n)
//稳定：相同的值排序后位置不变

public class Sort_787 {
    public static void merge_Sort(int[] arr,int[] res,int l,int r){
        if(l >= r) return ;
        int mid = (l + r)/2;

        merge_Sort(arr,res,l,mid);
        merge_Sort(arr,res,mid+1,r);

        int k = 0, i = l, j = mid + 1;
        while(i <= mid && j <= r){
            if(arr[i] <= arr[j]) res[k++] = arr[i++];
            if(arr[i] > arr[j]) res[k++] = arr[j++];
        }
        while(i <= mid) res[k++] = arr[i++];
        while(j <= r) res[k++] = arr[j++];

        for(i = l,j = 0;i <= r;i++,j++) arr[i] = res[j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        int[] res = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        merge_Sort(arr,res,0,n - 1);

        for(int i = 0; i < n ; i++) System.out.print(arr[i] + " ");

    }
}
