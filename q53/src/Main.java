public class Main {

    public static void main(String[] args) {
        int []array = {1,2,3,4,4,4,6,7,8};
        System.out.println(GetNumberOfK(array,4));
    }

    public static int GetNumberOfK(int[] array, int k) {
        int length = array.length;
        if (length == 0) return 0;
        int firstk = getFirstk(array, k, 0, length - 1);
        int lastk = getLastk(array, k, 0, length - 1);
        if (firstk != -1 && lastk != -1) {
            return lastk - firstk + 1;
        }
        return 0;
    }
    //循环二分法，找到第一个k出现的位置
    private static int getLastk(int[] array, int k, int start, int end) {
        int length = array.length;
        int mid = (start + end) >> 2;
        while (start <= end) {
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k) {
                start = mid + 1;
            } else if (mid + 1 < length && array[mid + 1] == k) {
                start = mid + 1;
            } else {
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }

    //递归二分法，找到第一个k出现的位置
    private static int getFirstk(int[] array, int k, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) >> 1;
        if (array[mid] > k) {
            return getFirstk(array, k, start, mid - 1);
        } else if (array[mid] < k) {
            return getFirstk(array, k, mid + 1, end);
        } else if (mid - 1 >= 0 && array[mid - 1] == k) {//左边还有值为k的元素呢
            return getFirstk(array, k, start, mid - 1);
        } else {
            return mid;
        }
    }



//        public int GetNumberOfK(int [] array , int k) {
//            int count = 0;
//            if(array.length== 0 ) return 0;
//            for(int i = 0;i < array.length;i++){
//                if(k==array[i])  count++;
//                if(i>=1){
//                    if(array[i] != array[i-1] && k == array[i-1]) return count;
//                }
//            }
//            return count;
//        }
}
