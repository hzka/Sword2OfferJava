import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(10));
    }

    public static int GetUglyNumber_Solution(int index) {
        if (index == 0) return 0;
//        if (index < 7) return index;
        int p2 = 0, p3 = 0, p5 = 0, newNum = 1;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(newNum);
        while (arr.size() < index) {
            newNum = Math.min(arr.get(p2) * 2, Math.min(arr.get(p3) * 3, arr.get(p5) * 5));
            if (arr.get(p2) * 2 == newNum)
                p2++;
            if (arr.get(p3) * 3 == newNum)
                p3++;
            if (arr.get(p5) * 5 == newNum)
                p5++;
            arr.add(newNum);
        }
        return newNum;
    }


//    public static int GetUglyNumber_Solution(int index) {
//        if (index < 0) return -1;
//        ArrayList<Integer> arrayList = new ArrayList<Integer>();
//        int counting = 0;
//        for (int i = 1; i <= 5; i++) {
//            arrayList.add(i);
//            counting++;
//        }
//        int now_num = 6;
//        while (counting < index) {
//            int added_num = now_num;
//            while (Dealnow_num(added_num)) {
//                if (added_num % 2 == 0) added_num = added_num / 2;
//                if (added_num % 3 == 0) added_num = added_num / 3;
//                if (added_num % 5 == 0) added_num = added_num / 5;
//                if (added_num == 1) {
//                    arrayList.add(now_num);
//                    counting++;
//                }
//            }
//            now_num++;
//        }
//        return arrayList.get(index - 1);
//
//    }
//
//    private static boolean Dealnow_num(int now_num) {
//        if (now_num % 2 == 0 || now_num % 3 == 0 || now_num % 5 == 0)
//            return true;
//        else return false;
//    }
}
