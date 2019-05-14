import java.util.ArrayList;

/**
 * 和为s的两个数字
 */
public class Main {

    public static void main(String[] args) {
        int []array = new int[]{1,2,4,7,11,15};
        System.out.println(FindNumbersWithSum(array,15));
    }

//    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
//        ArrayList<Integer> arraylist = new ArrayList<>();
//        for(int i = 0;i<array.length;i++){
//            for(int j = array.length-1;j>i;j--){
//                if(array[i]+array[j] < sum) break;
//                if(array[i] + array[j] ==sum){
//                    arraylist.add(array[i]);
//                    arraylist.add(array[j]);
//                    return arraylist;
//                }
//            }
//        }
//        return arraylist;
//    }

    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arraylist = new ArrayList<>();
        if(array ==null ||array.length <2) return arraylist;
        int i = 0,j = array.length-1;
        while (i<j){
            if(array[i]+array[j] == sum){
                arraylist.add(array[i]);
                arraylist.add(array[j]);
                return arraylist;
            }else if (array[i]+array[j] > sum){
                j--;
            }else{
                i++;
            }
        }
        return arraylist;
    }
}
