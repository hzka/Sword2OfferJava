//跳台阶
public class Main {

    public static void main(String[] args) {
        System.out.println(JumpFloor(4));
    }

//    public int JumpFloor(int target) {
//        if(target == 1)  return 1;
//        if(target == 2)  return 2;
//        return JumpFloor(target-1) + JumpFloor(target-2);
//    }

    public static int JumpFloor(int target) {
        if (target < 1) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        int t1 = 1, t2 = 2;
        for (int i = 3; i <= target; i++) {
            int tmp;
            tmp = t2;
            t2 += t1;
            t1 = tmp;
        }
        return t2;
    }
}
