package DataStructureAndAlgorithm.Acwing.Sort;

import java.util.*;
//逆序对：前一个数严格比后一个数大
//假设归并排序能在排序的同时求出逆序对的数量

public class Sort_788 {
    public static long merge_sort(int[] arr, int[] res, int l, int r) {
        if (l >= r) return 0;

        int mid = (l + r) / 2;
        long result = merge_sort(arr, res, l, mid) + merge_sort(arr, res, mid + 1, r);

        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) res[k++] = arr[i++];
            if (arr[j] < arr[i]) {
                res[k++] = arr[j++];
                result += mid - i + 1;
            }
        }

        while (i <= mid) res[k++] = arr[i++];
        while (j <= r) res[k++] = arr[j++];

        for (i = l, j = 0; i <= r; i++, j++) arr[i] = res[j];

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        int[] res = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(merge_sort(arr, res, 0, n - 1));
    }
}
