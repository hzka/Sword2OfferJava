import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Insert(5);
        System.out.println(GetMedian());
        Insert(2);
        System.out.println(GetMedian());
        Insert(3);
        System.out.println(GetMedian());
        Insert(4);
        System.out.println(GetMedian());
        Insert(1);
        System.out.println(GetMedian());
        Insert(6);
        System.out.println(GetMedian());
        Insert(7);
        System.out.println(GetMedian());
        Insert(0);
        System.out.println(GetMedian());
        Insert(8);
        System.out.println(GetMedian());
    }

    private static int count = 0;
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();//小根堆
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, Collections.reverseOrder());

    public static void Insert(Integer num) {
        if (count % 2 == 0) {//当数据总数为偶数时，新加入的元素，应当进入小根堆
            //（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
            //1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
            maxHeap.add(num);
            int filteredMaxNum = maxHeap.remove();
            //2.筛选后的【大根堆中的最大元素】进入小根堆
            minHeap.add(filteredMaxNum);
        }else{//当数据总数为奇数时，新加入的元素，应当进入大根堆
            //（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
            //1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
            minHeap.add(num);
            int filteredMinNum = minHeap.poll();
            maxHeap.add(filteredMinNum);
        }
        count++;
    }

    public static Double GetMedian() {
        if(count%2 == 0){
            return new Double((minHeap.peek()+maxHeap.peek())/2);
        }else{
            return new Double(minHeap.peek());
        }
    }
//    static ArrayList<Double> arraylist = new ArrayList<Double>();
//    public static void Insert(Integer num) {
//        arraylist.add((double)num);
//    }
//
//    public static Double GetMedian() {
//        int length = arraylist.size();
//        double []allnum = new double[length];
//        for(int i =0;i<length;i++){
//            allnum[i] = arraylist.get(i);
//        }
//        Arrays.sort(allnum);
////        DecimalFormat df = new DecimalFormat("#0.00");
//        if(length%2 != 0){
//            return allnum[length/2];
////            return Double.valueOf(df.format(allnum[length/2]));
//        }else{
//            return (allnum[length/2] + allnum[length/2-1])/2;
////            return Double.valueOf(df.format((allnum[length/2] + allnum[length/2-1])/2));
//        }
//    }
}
