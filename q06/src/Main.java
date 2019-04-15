import java.util.ArrayList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ListNode listNode_01 = new ListNode(3);
//        listNode_01.next = new ListNode(4);
//        listNode_01.next = new ListNode(5);
//        printListFromTailToHead(listNode_01);
    }

    ArrayList<Integer> returnlist = new ArrayList<Integer>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> returnlist = new ArrayList<Integer>();
//        if(listNode==null) return returnlist;
//        for (; listNode != null; listNode = listNode.next) {
//            returnlist.add(listNode.val);
//        }
//        for(int i = 0;i<returnlist.size()/2;i++){
//            int temp = returnlist.get(i);
//            returnlist.set(i,returnlist.get(returnlist.size()-1-i));
//            returnlist.set(returnlist.size()-1-i,temp);
//        }
//        return returnlist;

//        ArrayList<Integer> returnlist = new ArrayList<Integer>();
        //借助递归实现（递归的本质还是使用了堆栈结构）
//        if (listNode != null) {
//            printListFromTailToHead(listNode.next);
//            returnlist.add(listNode.val);
//        }
//        return returnlist;

        //借用堆栈的先进后出
        ArrayList<Integer> returnlist = new ArrayList<Integer>();
        Stack <Integer> stack = new Stack<Integer>();
        while (listNode!=null){
            //堆栈压栈
            stack.push(listNode.val);
            //更新当前节点
            listNode = listNode.next;
        }
        while (!stack.isEmpty()){
            returnlist.add(stack.pop());
        }
        return returnlist;
    }
}
