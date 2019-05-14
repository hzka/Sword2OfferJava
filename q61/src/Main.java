import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] test = new int[]{1, 3, 0, 7, 0};
        System.out.println(isContinuous(test));
    }

    public static boolean isContinuous(int[] numbers) {
        if(numbers.length<=4) return false;
        int[] d = new int[14];//每个数字出现的次数的计数器
        d[0] = -5;
        int len = numbers.length;
        int max = -1, min = 14;
        for (int i = 0; i < len; i++) {
            d[numbers[i]]++;
            if (numbers[i] == 0) continue;
            if (d[numbers[i]] > 1) {
                return false;
            }
            max = numbers[i] > max ? numbers[i] : max;
            min = numbers[i] < min ? numbers[i] : min;
        }
        if(max - min<5)return true;
        else return false;
    }
//    public static boolean isContinuous(int[] numbers) {
//        if(numbers.length<=4) return false;
//        Arrays.sort(numbers);
//        int count = 0;
//        for (int i = 0; i < numbers.length - 1; i++) {
//            if (numbers[i] == 0)  count++;
//            if (numbers[i] != 0 && numbers[i] + 1 != numbers[i + 1]){
//                if(count>0){
//                    count--;
//                    numbers[i] = numbers[i] + 1;
//                    i--;
//                    continue;
//                }else{
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
}
