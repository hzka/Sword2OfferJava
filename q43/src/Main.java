public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String ttt = "helloworld";
        System.out.println(NumberOf1Between1AndN_Solution(13));
    }


    public static int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0)
            return 0;
        int count = 0;
        for(long i = 1; i <= n; i *= 10){
            long diviver = i * 10;
            count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
        }
        return count;
    }

//    public static int NumberOf1Between1AndN_Solution(int n) {
//        if (n <= 0) return 0;
//        int counting = 0;
//        for (int i = 1; i <= n; i++) {
//            int nownumber = i;
//            while (nownumber > 0) {
//                int remainder = nownumber % 10;
//                if (remainder == 1) {
//                    counting++;
//                }
//                nownumber = nownumber / 10;
//            }
//        }
//        return counting;
//    }
}
