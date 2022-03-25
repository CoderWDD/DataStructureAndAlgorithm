package DataStructureAndAlgorithm.Acwing.Sort;

//高精度相加/相减：10^6
//A*a：len（A）<= 10^6  a<10000
//A/a
//大整数存储：把数的每一位存到数组里面（逆序存储：因为需要进位，在末尾加入数字比较容易）


import java.util.Scanner;

public class Sort_791 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextLine();
        String num2 = sc.nextLine();
        int[] nums1 = new int[num1.length()];
        int[] nums2 = new int[num2.length()];
        for (int i = 0; i < num1.length(); i++){
            nums1[i] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < num2.length(); i++){
            nums2[i] = num2.charAt(i) - '0';
        }
        int length = Math.max(num1.length(),num2.length()) + 1;
        int[] res = new int[length];
        int i = num1.length() - 1,j = num2.length() - 1;
        int flag = 0;
        int index = res.length - 1;
        for (; i >= 0 && j >= 0; i--,j--){
            res[index--] = (nums1[i] + nums2[j] + flag) % 10;
            flag = (nums1[i] + nums2[j] + flag) / 10;
        }
        while (i >= 0) {
            res[index--] = (nums1[i] + flag) % 10;
            flag = (nums1[i--] + flag) / 10;
        }

        while (j >= 0) {
            res[index--] = (nums2[j] + flag) % 10;
            flag = (nums2[j--] + flag) / 10;
        }

        if (flag != 0 && res[0] == 0) res[0] = flag;
        if (res[0] != 0) System.out.print(res[0]);
        for (int k = 1; k < res.length; k++){
            System.out.print(res[k]);
        }
    }
}


////自带函数处理
//BigInteger 只可用于整数
//        构造方法
//
//        BigInteger(byte[] val)
//        将包含BigInteger的二进制补码二进制表达式的字节数组转换为BigInteger
//        BigInteger(int numBits, Random rnd)
//        构造一个随机生成的BigInteger，均匀分布在0到（2 numBits - 1）的范围内。
//        BigInteger(String val)
//        将BigInteger的十进制字符串表示形式转换为BigInteger。
//
//        加法 add( )
//
//import java.math.BigInteger;
//import java.io.*;
//
//public class Sort_791 {
//    public static void main(String[] args) throws IOException{
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        BigInteger a = new BigInteger(reader.readLine());
//        BigInteger b = new BigInteger(reader.readLine());
//        System.out.println(a.add(b));
//        reader.close();
//    }
//}
//
//减法 subtract( )
//
//import java.io.*;
//        import java.math.BigInteger;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException{
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BigInteger a = new BigInteger(reader.readLine());
//        BigInteger b = new BigInteger(reader.readLine());
//        System.out.println(a.subtract(b));
//        reader.close();
//    }
//}
//    乘法 multiply( )
//
//import java.io.*;
//        import java.math.BigInteger;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException{
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BigInteger a = new BigInteger(reader.readLine());
//        BigInteger b = new BigInteger(reader.readLine());
//        System.out.println(a.multiply(b));
//        reader.close();
//    }
//}
//    除法 divideAndRemainder( )
//
//import java.io.*;
//        import java.math.BigInteger;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException{
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BigInteger a = new BigInteger(reader.readLine());
//        BigInteger b = new BigInteger(reader.readLine());
//        //divide 返回值为 a/b
//        BigInteger[] c = a.divideAndRemainder(b); //返回值为数组，分别为a/b和a%b
//        System.out.println(c[0]);
//        System.out.println(c[1]);
//        reader.close();
//    }
//}
//    取余 mod( )
//
//import java.io.*;
//        import java.math.BigInteger;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BigInteger a = new BigInteger(reader.readLine());
//        BigInteger b = new BigInteger(reader.readLine());
//        System.out.println(a.mod(b));
//        reader.close();
//    }
//}


//
//BigDecimal 处理浮点数运算
//        构造方法
//
//        BigDecimal(char[] in)
//        一个转换的字符数组表示 BigDecimal成 BigDecimal ，接受字符作为的相同序列 BigDecimal(String)构造。
//        BigDecimal(char[] in, int offset, int len)
//        一个转换的字符数组表示 BigDecimal成 BigDecimal ，接受字符作为的相同序列 BigDecimal(String)构造，同时允许一个子阵列被指定。
//        BigDecimal(double val)
//        将 double转换为 BigDecimal ，这是 double的二进制浮点值的精确十进制表示
//        BigDecimal(int val)
//        将 int成 BigDecimal
//        BigDecimal(long val)
//        将 long成 BigDecimal
//        BigDecimal(String val)
//
//        加法 add( )
//
//import java.io.*;
//import java.math.BigDecimal;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BigDecimal a = new BigDecimal(reader.readLine());
//        BigDecimal b = new BigDecimal(reader.readLine());
//        System.out.println(a.add(b));
//        reader.close();
//    }
//}
//
//取余 remainder( )
//
//import java.io.*;
//        import java.math.BigDecimal;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BigDecimal a = new BigDecimal(reader.readLine());
//        BigDecimal b = new BigDecimal(reader.readLine());
//        System.out.println(a.remainder(b));
//        reader.close();
//    }
//}
//    除法 divide( )
//
//import java.io.*;
//        import java.math.BigDecimal;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BigDecimal a = new BigDecimal(reader.readLine());
//        BigDecimal b = new BigDecimal(reader.readLine());
//        System.out.println(a.divide(b));
//        reader.close();
//    }
//}



