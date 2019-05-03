import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        ListNode pHead1 = new ListNode(3);
        pHead1.next = new ListNode(4);
        pHead1.next.next = new ListNode(5);
        pHead1.next.next.next = new ListNode(6);

        ListNode pHead2 = new ListNode(9);
        pHead2.next = new ListNode(2);
        pHead2.next.next = new ListNode(5);
        pHead2.next.next.next = new ListNode(6);

        ListNode t1 = FindFirstCommonNode(pHead1, pHead2);
        System.out.println(t1.val);
    }

    //1.暴力破解法
//    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
//        ListNode p1 = pHead1;
//        ListNode p2 = pHead2;
//        while (p1 != null) {
//            p2 = pHead2;
//            while (p2 != null) {
//                if (p1 == p2) return p1;
//                p2 = p2.next;
//            }
//            p1 = p1.next;
//        }
//        return null;
//    }

//    2.使用堆栈解决。
//    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
//        if (pHead1 == null || pHead2 == null) return null;
//        Stack<ListNode> stack1 = new Stack<>();
//        Stack<ListNode> stack2 = new Stack<>();
//        while (pHead1 != null) {
//            stack1.push(pHead1);
//            pHead1 = pHead1.next;
//        }
//        while (pHead2 != null) {
//            stack2.push(pHead2);
//            pHead2 = pHead2.next;
//        }
//        ListNode commonListNode = null;
//        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek()){
//            stack2.pop();
//            commonListNode = stack1.pop();
//        }
//        return commonListNode;
//    }


//       3.假定 List1长度: a+n  List2 长度:b+n, 且 a<b
//    那么 p1 会先到链表尾部, 这时p2 走到 a+n位置,将p1换成List2头部
//    接着p2 再走b+n-(n+a) =b-a 步到链表尾部,这时p1也走到List2的b-a位置，还差a步就到可能的第一个公共节点。
//    将p2 换成 List1头部，p2走a步也到可能的第一个公共节点。如果恰好p1==p2,那么p1就是第一个公共节点。或者p1和p2一起走n步到达列表尾部，二者没有公共节点，退出循环。 同理a>=b.
//    时间复杂度O(n+a+b)
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != p2) {
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
            if (p1 == null && p2 != null) p1 = pHead2;
            if (p2 == null && p1 != null) p2 = pHead1;
        }
        return p1;
    }
}


