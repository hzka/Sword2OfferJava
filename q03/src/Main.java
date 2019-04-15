import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        for(int i = 0;i < length;i++){
            if(!hashmap.containsKey(numbers[i])){
                hashmap.put(numbers[i],i);
            }else{
                duplication[0] = numbers[i];
                System.out.print(duplication[0]);
                return true;
            }
        }
        return false;

//        if(length == 0 || length == 1)
//            return false;
//        Arrays.sort(numbers);
//        for(int i = 0;i < length-1;i++){
//            if(numbers[i] == numbers[i+1]){
//                duplication[0] = numbers[i];
//                return true;
//            }
//        }
//        return false;

//        boolean[] k = new boolean[length];
//        for (int i = 0; i < k.length; i++) {
//            if (k[numbers[i]] == true) {
//                duplication[0] = numbers[i];
//                return true;
//            }
//            k[numbers[i]] = true;
//        }
//        return false;
    }
}
