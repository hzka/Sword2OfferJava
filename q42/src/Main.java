public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
//        int[] array = new int[]{-2, -8, -1, -5, -9};
        System.out.println(FindGreatestSumOfSubArray(array));
    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        int res = array[0];//记录当前所有子数组的和的最大值
        int max = array[0];//包含array[i]的连续数组最大值
        for(int i = 1;i<array.length;i++){
            max = Math.max(max+array[i],array[i]);
            res = Math.max(max,res);
        }
        return res;
    }
//    public static int FindGreatestSumOfSubArray(int[] array) {
//        if (array.length == 0) return 0;
//        if (array.length == 1) return array[0];
//        int total = array[0], maxSum = array[0];
//        for (int i = 1; i < array.length; i++) {
//            if (total >= 0)
//                total += array[i];
//            else
//                total = array[i];
//            if (total > maxSum)
//                maxSum = total;
//        }
//        return maxSum;
//    }
//    public static int FindGreatestSumOfSubArray(int[] array) {
//        int MAX_VALUE = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] < 0) continue;
//            int nownum = 0;
//            for (int j = i; j < array.length; j++) {
//                //试探着走。
//                nownum += array[j];
//                if (nownum < 0) break;
//                if (nownum > MAX_VALUE) {
//                    MAX_VALUE = nownum;
//                }
//            }
//        }
//        if(MAX_VALUE == 0){
//            MAX_VALUE = array[0];
//            for (int i = 0; i < array.length; i++) {
//                 MAX_VALUE  = MAX_VALUE<array[i]?array[i]:MAX_VALUE;
//            }
//        }
//        return MAX_VALUE;
//    }
}
