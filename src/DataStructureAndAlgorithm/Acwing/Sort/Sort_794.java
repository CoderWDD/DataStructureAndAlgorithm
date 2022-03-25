package DataStructureAndAlgorithm.Acwing.Sort;

import java.util.Scanner;

public class Sort_794 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextLine();
        String num2 = sc.nextLine();
        int[] nums1 = new int[num1.length()];

        for(int i = 0; i < num1.length();i++){
            nums1[i] = num1.charAt(i) - '0';
        }

        int[] res = new int[num1.length()];

        int nums2 = Integer.parseInt(num2);
        int length = num2.length();

        int sum = 0,flag = 0,temp = 0;
        for(int i = 0; i < num1.length();i++){
            sum = sum * 10 + nums1[i];
            if(sum >= nums2){
                temp = sum % nums2;
                res[i] = sum / nums2;
                if(temp != 0){
                    sum = temp;
                }
                else{
                    sum = 0;
                }
            }
            else res[i] = 0;
        }
        temp = sum;

        int k = 0;
        while (k < res.length && res[k] == 0){
            if(k == num1.length() - 1) {
                break;
            }
            k++;
        }

        for (; k < num1.length(); k++) {
            System.out.print(res[k]);
        }
        System.out.println();
        System.out.println(temp);
    }
}
