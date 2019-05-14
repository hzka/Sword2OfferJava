public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

        public int Sum_Solution(int n) {
        int ans  = n;
        boolean flag = (ans>0) && ((ans+=Sum_Solution(n-1))>0);
        return ans;
    }
//    public int Sum_Solution(int n) {
//        return (int) (Math.pow(n, 2) + n) >> 1;
//    }
}
