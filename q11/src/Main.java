public class Main {

    public static void main(String[] args) {
        int [] arrays = {13,4,5,1,2};

        System.out.println(minNumberInRotateArray(arrays));
    }

//    public static int minNumberInRotateArray(int[] array) {
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] < min) {
//                min = array[i];
//            }
//        }
//        return min;
//    }
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return Integer.MIN_VALUE;
        int index_first = 0, index_last = array.length - 1, index_mid = 0;
        while (array[index_first] >= array[index_last]) {
            if (index_last - index_first == 1) {
                index_mid = index_last;
                break;
            }
            index_mid = (index_first + index_last) / 2;
            if (array[index_first] == array[index_mid] && array[index_mid] == array[index_last]) {
                return GetMinInorder(array, index_first, index_last);
            }
            if (array[index_mid] >= array[index_first]) {
                index_first = index_mid;
            } else if (array[index_mid] <= array[index_first]) {
                index_last = index_mid;
            }
        }
        return  array[index_mid];
    }

    private static int GetMinInorder(int[] array, int index_first, int index_last) {
        int result = array[index_first];
        for(int i = index_first+1;i<=index_last;i++){
            if(result>array[i]){
                result  = array[i];
            }
        }
        return result;
    }
}
