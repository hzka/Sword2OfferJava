import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> arraylist = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(6,7));
    }
//
//    public static int LastRemaining_Solution(int n, int m) {
//        if(n==0 || m== 0) return 0;
//        for (int i = 0; i < n; i++) {
//            arraylist.add(i);
//        }
//        int index = (m - 1) % arraylist.size();
//        while (arraylist.size() > 1) {
//            arraylist.remove(index);
//            index = (index + (m - 1)) % (arraylist.size());
//        }
//        return arraylist.get(0);
//    }

    public static int LastRemaining_Solution(int n, int m) {
        if(n==0)
            return -1;
        if(n==1)
            return 0;
        else
            return (LastRemaining_Solution(n-1,m)+m)%n;
    }
}
