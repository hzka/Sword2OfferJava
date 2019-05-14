public class Main {

    public static void main(String[] args) {
        int[] testing = {2, 3, 4, 5};
        System.out.println(multiply(testing));
    }

//    public static int[] multiply(int[] A) {
//        int length = A.length;
//        int[] B = new int[length];
//        if (length != 0) {
//            B[0] = 1;
//            //计算下三角连乘
//            for (int i = 1; i < length; i++) {
//                B[i] = B[i - 1] * A[i - 1];
//            }
//            int temp = 1;
//            //计算上三角连乘
//            for (int j = length - 2; j >= 0; j--) {
//                temp *= A[j + 1];
//                B[j] *= temp;
//            }
//        }
//        return B;
//    }

    public static int[] multiply(int[] A) {
        int len = A.length;
        int forword[] = new int[len];
        int backword[] = new int[len];
        int B[] = new int[len];
        forword[0] = 1;
        backword[0] = 1;
        for (int i = 1; i < len; i++) {
            forword[i] = A[i - 1] * forword[i - 1];
            backword[i] = A[len - i] * backword[i - 1];
        }
        for (int i = 0; i < len; i++) {
            B[i] = forword[i] * backword[len - i - 1];
        }
        return B;
    }


//    public int[] multiply(int[] A) {
//        int[] B = new int[A.length];
//        for (int i = 0; i < A.length; i++) {
//            B[i] = 1;
//        }
//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < A.length; j++) {
//                if (i != j) {
//                    B[i] = B[i] * A[j];
//                }
//            }
//        }
//        return B;
//    }
}
