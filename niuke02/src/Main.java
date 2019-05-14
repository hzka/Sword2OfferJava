public class Main {

    public static void main(String[] args) {
        System.out.println(JumpFloorII(3));
    }
//    public int JumpFloorII(int target) {
//        if(target <= 0)  return 0;
//        int result = 1;
//        for(int i = 1;i<target;i++){
//            result *= 2;
//        }
//        return result;
//    }

    public static int JumpFloorII(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }
    }
}
