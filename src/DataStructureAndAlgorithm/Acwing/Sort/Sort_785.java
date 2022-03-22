package DataStructureAndAlgorithm.Acwing.Sort;

import java.util.*;

//快速排序  分界点+划分+递归

//暴力解法（需用到两个额外的空间）
//定义一个flag也就是参照值，然后开辟两个数组空间a[]和b[]
//将比flag小的数放在a[]里，将比flag大的数放在b[]里
//最后将a[]和b[]合并成为一个数组

//预期输入：5
//        3 1 2 3 5
//时间复杂度：O(nlog2n)

//问：为什么分界点不一定等于x

public class Sort_785 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, n - 1);

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }

    }

    public static void quickSort(int[] a,int l, int r){
        if(l >= r) return ;
        int flag = a[l], i = l - 1, j = r + 1;
        while(i < j){
            do i++; while (a[i] < flag);
            do j--; while (a[j] > flag);
            if(i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        quickSort(a,l,j);
        quickSort(a,j+1,r);
    }
}
