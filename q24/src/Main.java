
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        ReverseList(head);
    }

    public static ListNode ReverseList(ListNode head) {
        if(head==null || head.next ==null)  return head;
        ListNode pre = null;
        ListNode next =null;
        while (head!=null){
            next = head.next;//暂存下一个节点
            head.next = pre;//断链并进行反转
            pre = head;//将两个指针都往前移动一格
            head = next;
        }
        return next;
    }

    //利用栈的后进先出，但时间复杂度超过限制。
    public static ListNode ReverseList01(ListNode head) {
        if(head==null || head.next ==null)  return head;
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode reverstnode = stack.pop();
        ListNode returnnode = reverstnode;
        System.out.println(reverstnode.val);
        while (!stack.isEmpty()) {
            reverstnode.next = stack.pop();
            reverstnode = reverstnode.next;
            System.out.println(reverstnode.val);
        }
        return returnnode;
    }
}
