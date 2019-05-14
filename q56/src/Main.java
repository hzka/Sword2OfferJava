import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,6,4,3};
        int[] num1 = new int[]{0};
        int[] num2 = new int[]{0};
        FindNumsAppearOnce(array, num1, num2);
    }

    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null && array.length <= 1) {
            num1[0] = num2[0] = 0;
        }
        int len = array.length, index = 0, sum = 0;
        for (int i = 0; i < len; i++) {
            sum ^= array[i];
        }
        //sum的二进制表示中，1的位数，表示的是
        // 两个唯一数字二进制表示中不同的位，我们就找出第一个 b                                                 1所在的位数(index)
        for(index = 0;index<32;index++){
            if((sum & (1<<index))!=0)
                break;
        }
        //按照这个位将数组分成两个子数组，分组标准是数字在这个位上的值是否为1
        // （此时数字相同的各位也相同，在同一个组中；不同数字，也就不在同一组里）。
        // 之后按照异或分别找出那两个唯一数即可。
        for(int i =0;i<len;i++){
            if((array[i] & (1<<index))!=0){
                num2[0] ^= array[i];
            }else{
                num1[0] ^= array[i];
            }
        }
    }
    /***
     * 使用哈希表来实现。
     * @param array
     * @param num1
     * @param num2
     */
//    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
//        Queue<Integer> arr = new LinkedList<>();
//        HashMap<Integer,Integer> hashMap = new HashMap<>();
//        for(int i = 0;i<array.length;i++){
//            if(!hashMap.containsKey(array[i])){
//                hashMap.put(array[i],1);
//            }else{
//                hashMap.put(array[i],hashMap.get(array[i])+1);
//            }
//        }
//        for(int i = 0;i<array.length;i++){
//            if(hashMap.get(array[i])==1)
//                arr.add(array[i]);
//        }
//        num1[0] = arr.remove();
//        num2[0] = arr.remove();
//    }
//    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
//        Arrays.sort(array);
//        boolean flag = false;
//        for(int i = 0;i<array.length-1;i++){
//            if(array[i] == array[i+1]){
//                i++;
//            }else if(!flag){
//                num1[0] = array[i];
//                flag = true;
//            }else{
//                num2[0] = array[i];
//            }
//        }
//        if(array[array.length-1] != array[array.length-2]){
//            num2[0] = array[array.length-1];
//        }
//    }
}
