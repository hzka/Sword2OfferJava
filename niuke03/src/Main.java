public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

//    public int RectCover(int target) {
//        if (target < 1) return 0;
//        if (target == 1) return 1;
//        if (target == 2) return 2;
//        int t1 = 1, t2 = 2;
//        for (int i = 3; i <= target; i++) {
//            int tmp;
//            tmp = t2;
//            t2 += t1;
//            t1 = tmp;
//        }
//        return t2;
//    }

    public int RectCover(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        return RectCover(target - 1) + RectCover(target - 2);
    }

}
