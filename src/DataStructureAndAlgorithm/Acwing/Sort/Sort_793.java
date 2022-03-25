package DataStructureAndAlgorithm.Acwing.Sort;

import java.util.Scanner;

public class Sort_793 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextLine();
        String num2 = sc.nextLine();

        int nums2 = Integer.parseInt(num2);
        int length = num1.length() + num2.length();

        int[] nums1 = new int[length];
        for (int i = length - 1 ,j = num1.length() - 1; i >= length - num1.length(); i--,j--){
            nums1[i] = num1.charAt(j) - '0';
        }

        int[] res =  new int[length];
        int i = length - 1,t = 0;
        for(;i >= 0; i--){
            res[i] = (nums1[i] * nums2 + t) % 10;
            t = (nums1[i] * nums2 + t) / 10;
        }

        int flag = 0;
        for(int  k = 0; k < length;k++){
            if(flag == 0){
                while(res[k] == 0){
                    k++;
                    if(k == length - 1){
                        break;
                    }
                }
                flag = 1;
            }
            System.out.print(res[k]);
        }


    }
}

