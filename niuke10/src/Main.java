import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        int[] test = new int[]{2,3,4,2,6,2,5,1};

        System.out.println(maxInWindows(test, 3));
    }

    //    public static ArrayList<Integer> maxInWindows(int [] num, int size)
//    {
//        ArrayList<Integer> result = new ArrayList<>();
//        if(size==0 || num.length ==0) return result;
//        for(int i = 0;i<num.length-size+1;i++){
//            int MAX = Integer.MIN_VALUE;
//            for(int j = i;j<i+size;j++){
//                MAX = (MAX>num[j]?MAX:num[j]);
//            }
//            result.add(MAX);
//        }
//        return result;
//    }
//    思路：滑动窗口应当是队列，但为了得到滑动窗口的最大值，队列序可以从两端删除元素，因此使用双端队列。
//    原则：
//       对新来的元素k，将其与双端队列中的元素相比较
//      1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
//            2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
//      队列的第一个元素是滑动窗口中的最大值
    public static ArrayList<Integer> maxInWindows(int[] num, int size)

    {
        ArrayList<Integer> ret = new ArrayList<>();
        if (num == null) {
            return ret;
        }
        if (num.length < size || size < 1) {
            return ret;
        }

        LinkedList<Integer> indexDeque = new LinkedList<>();
        for (int i = 0; i < size - 1; i++) {
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
        }
        for (int i = size - 1; i < num.length; i++) {
            //前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
            //前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
            //队列的第一个元素是滑动窗口中的最大值
            if (i - indexDeque.getFirst() + 1 > size) {
                indexDeque.removeFirst();
            }
            ret.add(num[indexDeque.getFirst()]);
        }
        return ret;
    }
}