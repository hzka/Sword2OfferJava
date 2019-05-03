import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        GetLeastNumbers_Solution(new int[]{3,4,7,1,2,6},4);
    }
//    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
//        Arrays.sort(input);
//        ArrayList<Integer> arraylist = new ArrayList<Integer>();
//        if(k>input.length) return arraylist;
//        for(int i = 0;i < k;i++){
//            arraylist.add(input[i]);
//        }
//        return arraylist;
//    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
       ArrayList<Integer> result = new ArrayList<Integer>();
       int length = input.length;
       if(k>length||k==0||input ==null){
           return result;
       }
       //从大到小的n为优先数组，每次返回最大的值。
        Queue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
//        在方法调用返回一个比较器，它强行上实现Comparable接口的对象的集合的自然顺序相反。
        for(int i = 0;i<input.length;i++){
            if(maxHeap.size()<k){
                maxHeap.add(input[i]);
            }else{
                if(input[i]<maxHeap.peek()){
                    maxHeap.remove();
                    maxHeap.add(input[i]);
                }
            }
        }
        while (!maxHeap.isEmpty()){
            result.add(maxHeap.remove());
        }
        return result;
    }

}
