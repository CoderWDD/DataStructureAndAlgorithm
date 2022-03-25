package DataStructureAndAlgorithm.Acwing.Sort;

import java.util.*;

public class Sort_792 {
    static boolean cmp(String num1,String num2){
        if(num1.length() != num2.length()) return num1.length() > num2.length();
        for(int i = 0;i < num1.length() ;i++){
            if(num1.charAt(i) - '0' != num2.charAt(i) - '0'){
                return num1.charAt(i) - '0' > num2.charAt(i) - '0';
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextLine();
        String num2 = sc.nextLine();

        boolean temp = cmp(num1,num2);
        if(temp == false){
            String num3 = num1;
            num1 = num2;
            num2 = num3;
        }

        int[] nums1 = new int[num1.length()];
        int[] nums2 = new int[num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            nums1[i] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < num2.length(); i++) {
            nums2[i] = num2.charAt(i) - '0';
        }

        int length = Math.max(num1.length(), num2.length());
        int[] res = new int[length];

        int i = num1.length() - 1, j = num2.length() - 1, t = 0, index = length - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            t = nums1[i] - t;
            t = t - nums2[j];
            res[index--] = (t + 10) % 10;
            if (t < 0) t = 1;
            else t = 0;
        }
        while (i >= 0) {
            t = nums1[i--] - t;
            res[index--] = (t + 10) % 10;
            if (t < 0) t = 1;
            else t = 0;
        }
        while (j >= 0) {
            t = nums2[j--] - t;
            res[index--] = (t + 10) % 10;
            if (t < 0) t = 1;
            else t = 0;
        }

        if (temp == false) System.out.print("-");

        int flag = 0;
        for (int k = 0; k < length; k++) {
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
