package DataStructureAndAlgorithm.Acwing.Sort;

import java.util.*;
import java.text.DecimalFormat;

public class Sort_790 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();

        double l = -22, r = 22;
        DecimalFormat df = new DecimalFormat("0.000000");

        while(r - l > 1e-8){
            double mid = (r + l) / 2;
            if(mid * mid * mid >= x) r = mid;
            else l = mid;
        }

        System.out.println(df.format(l));
    }
}
