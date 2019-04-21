import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }


//    public ListNode EntryNodeOfLoop(ListNode pHead){
//        if(pHead==null|| pHead.next==null|| pHead.next.next==null)return null;
//        ListNode fast=pHead.next.next;
//        ListNode slow=pHead.next;
//        //先判断有没有环
//        while(fast!=slow){
//            if(fast.next!=null&& fast.next.next!=null){
//                fast=fast.next.next;
//                slow=slow.next;
//            }else{
//                //没有环,返回
//                return null;
//            }
//        }
//        //循环出来的话就是有环，且此时fast==slow.
//        fast=pHead;
//        while(fast!=slow){
//            fast=fast.next;
//            slow=slow.next;
//        }
//        return slow;
//    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ArrayList<ListNode> arraylist = new ArrayList<ListNode>();
        arraylist.add(pHead);
        pHead = pHead.next;
        while (pHead != null) {
            if (arraylist.contains(pHead)) {
                return pHead;
            }
            arraylist.add(pHead);
            pHead = pHead.next;

        }
        return null;
    }
}
