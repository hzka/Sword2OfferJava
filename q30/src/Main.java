import java.util.Arrays;
import java.util.Stack;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello World!");
    }


    private int size;
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> minStack = new Stack<Integer>();
    private Integer[] elements = new Integer[10];
    public void push(int node) {
        ensureCapacity(size+1);
        elements[size++] = node;
        if(node <= min){
            minStack.push(node);
            min = minStack.peek();
        }else{
            minStack.push(min);
        }
        //    System.out.println(min+"");
    }

    private void ensureCapacity(int size) {
        // TODO Auto-generated method stub
        int len = elements.length;
        if(size > len){
            int newLen = (len*3)/2+1; //每次扩容方式
            elements = Arrays.copyOf(elements, newLen);
        }
    }
    public void pop() {
        Integer top = top();
        if(top != null){
            elements[size-1] = (Integer) null;
        }
        size--;
        minStack.pop();
        min = minStack.peek();
        //    System.out.println(min+"");
    }

    public int top() {
        if(!empty()){
            if(size-1>=0)
                return elements[size-1];
        }
        return (Integer) null;
    }
    public boolean empty(){
        return size == 0;
    }

    public int min() {
        return min;
    }

//    private Stack<Integer> stack = new Stack<Integer>();
//    private Stack<Integer> min_stack = new Stack<Integer>();
//    private int min = Integer.MAX_VALUE;
//
//    public void push(int node) {
//        if (node <= min){
//            min = node;
//        }
//        min_stack.push(min);
//        stack.push(node);
//    }
//    //弹栈的时候有可能最小值就弹出去了。
//    public void pop() {
//        min_stack.pop();
//        min = min_stack.peek();
//        stack.pop();
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int min() {
//        return min;
//    }
}
