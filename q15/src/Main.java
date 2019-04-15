public class Main {

    public static void main(String[] args) {
        System.out.println(NumberOf1(-6));
    }

    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n-1)&n;
        }
        return count;
    }
//    public static int NumberOf1(int n) {
//        int count = 0;
//        int flag = 1;
//        while (flag != 0) {
//            if((flag & n)!=0) count++;
//            flag = flag << 1;
//        }
//        return count;
//    }
//    public static int NumberOf1(int n) {
//        int count = 0;
//        if (n > 0) {
//            while (n / 2 != 0) {
//                if (n % 2 == 1) count++;
//                n = n / 2;
//            }
//            if (n % 2 == 1) count++;
//        } else {
//            String s1 = Integer.toBinaryString(n);
//            System.out.println(s1);
//            for (int i = 0; i < s1.length(); i++) {
//                if (s1.charAt(i) == '1') count++;
//            }
//        }
//        return count;
//    }
}
