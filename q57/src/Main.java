import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        FindContinuousSequence(15);
        System.out.println("Hello World!");
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        //存放结果
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 1, phigh = 2;
        while (phigh > plow) {
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if (cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = plow;i<=phigh;i++){
                    list.add(i);
                }
                result.add(list);
                plow++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            }else if (cur<sum){
                phigh++;
            }else{
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                plow++;
            }
        }
        return result;
    }
//    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
//        ArrayList<ArrayList<Integer>> allLists = new ArrayList<>();
//        if (sum <= 2) return allLists;
//        for (int i = 2; i <= sum; i++) {
//            ArrayList<Integer> arrayList = new ArrayList<>();
//            int midpos = sum / i;
//            int testsum = 0;
//            //如果是偶数的话
//            if (i % 2 == 0) {
//                for (int j = (-i / 2) + 1; j <= i / 2; j++) {
//                    arrayList.add(midpos + j);
//                    testsum += (midpos + j);
//                    if (midpos + j == 0) break;
//                }
//                if (testsum == sum) {
//                    allLists.add(arrayList);
//                }
//            } else {
//                for (int j = (-i / 2); j <= i / 2; j++) {
//                    arrayList.add(midpos + j);
//                    testsum += (midpos + j);
//                    if (midpos + j == 0) break;
//                }
//                if (testsum == sum) {
//                    allLists.add(arrayList);
//                }
//            }
//        }
//        for (int i = 0; i < allLists.size() - 1; i++) {
//            for (int j = i + 1; j < allLists.size(); j++) {
//                if (allLists.get(i).get(1) > allLists.get(j).get(1)) {
//                    ArrayList<Integer> arrayList_01 = new ArrayList<>();
//                    arrayList_01 = allLists.get(i);
//                    allLists.set(i, allLists.get(j));
//                    allLists.set(j, arrayList_01);
//                }
//            }
//        }
//        return allLists;
//    }
}
