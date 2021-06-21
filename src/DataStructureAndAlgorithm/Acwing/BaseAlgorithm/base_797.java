package DataStructureAndAlgorithm.Acwing.BaseAlgorithm;
import java.util.Scanner;

class base_797{
    static int[] a = new int[100010];
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        //创建a[]数组，使得nums[]数组为a[]数组的前缀和数组
        int num;
        for (int i = 1; i <= n; i++){
            num = in.nextInt();
            insert(i,i,num);
        }
        int l,r;
        for (int i = 1; i <= m; i++){
            l = in.nextInt();
            r = in.nextInt();
            num = in.nextInt();
            insert(l,r,num);
        }
        int sum = 0;
        for (int i = 1; i <= n; i++){
            sum = sum + a[i];
            System.out.print(sum + " ");
        }

    }
    public static void insert(int l,int r,int num){
        a[l] = a[l] + num;
        a[r + 1] = a[r + 1] - num;
    }
}