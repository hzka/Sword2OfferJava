import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        int[] test = new int[]{3,32,321};
        System.out.println(PrintMinNumber(test));
    }
    public static String PrintMinNumber(int[] numbers) {
        if(numbers == null || numbers.length == 0) return "";
        int len = numbers.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<len;i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1 = o1+o2;//332
                String c2 = o2+o1;//323
                return c1.compareTo(c2);
//                如果指定的数与参数相等返回0。如果指定的数小于参数返回 -1。
//                如果指定的数大于参数返回 1,如果不能理解的话想一想Arrays.sort自然排序的
           }
        });
        for(int i = 0;i<len;i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
//    public static String PrintMinNumber(int[] numbers) {
//        if(numbers.length == 0) return String.valueOf(new StringBuilder());
//        if(numbers.length == 1) return String.valueOf(numbers[0]);
//        int MAX = Integer.MIN_VALUE;
//        for (int i = 0; i < numbers.length; i++) {
//            if (numbers[i] > Integer.MIN_VALUE) {
//                MAX = numbers[i];
//            }
//        }
//        int MAX_length = String.valueOf(MAX).length();
//        for (int i = 0; i < numbers.length - 1; i++) {
//            for (int j = i + 1; j < numbers.length; j++) {
//                //填充数字
//                int length_i = MAX_length - String.valueOf(numbers[i]).length();
//                int length_j = MAX_length - String.valueOf(numbers[j]).length();
//                if (dealNum(numbers[i],length_i) > dealNum(numbers[j],length_j)) {
//                    int tmp = numbers[i];
//                    numbers[i] = numbers[j];
//                    numbers[j] = tmp;
//                }
//            }
//        }
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < numbers.length; i++) {
//            result.append(numbers[i]);
//        }
//        return result.toString();
//    }
//
//    private static int dealNum(int dealnum,int length) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(dealnum);
//        int circle = length/String.valueOf(dealnum).length();
//        int divider =  length%String.valueOf(dealnum).length();
//        for(int i = 0;i<circle;i++){
//            sb.append(dealnum);
//        }
//        sb.append(String.valueOf(dealnum).substring(0,divider));
//        return Integer.parseInt(sb.toString());
//    }
}
