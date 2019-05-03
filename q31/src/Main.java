import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] pushB = {4, 5, 3, 2, 0};
        System.out.println(IsPopOrder(pushA, pushB));
    }

    static Stack<Integer> my_stack = new Stack<Integer>();

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length != popA.length) return false;
        if (pushA.length == popA.length && pushA.length == 0) return true;
        int i = 0, j = 0;
        while (i < pushA.length && j < popA.length) {
            my_stack.push(pushA[i]);
            while (my_stack.size() >= 1 && my_stack.peek() == popA[j]) {
                my_stack.pop();
                j++;
            }
            i++;
            if (i == pushA.length && j != popA.length) return false;
            if (i != pushA.length && j == popA.length)  return false;
        }
        return true;
    }
}
