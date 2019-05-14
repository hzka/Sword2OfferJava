import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        System.out.println(Add(7, 6));
    }

//    public static int Add(int num1, int num2) {
//        while (num2 != 0) {
//            int temp = num1 ^ num2;//异或相加各位的值，不算进位。相等记为0，不等记为1。
//            num2 = (num1 & num2)<<1;//与操作计算进位值。
//            num1 = temp;
//        }
//        return num1;
//    }

//    public static int Add(int num1, int num2) {
//        BigInteger b1 = new BigInteger(String.valueOf(num1));
//        BigInteger b2 = new BigInteger(String.valueOf(num2));
//        return b1.add(b2).intValue();
//    }


    public static int Add(int num1, int num2) {
        if (num1 > 0) {
            while (num1-- != 0)
                num2++;
        } else if (num1 < 0) {
            while (num1++ != 0)
                num2--;
        }
        return num2;
    }

}
