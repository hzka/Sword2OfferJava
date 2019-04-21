public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    //采用递归的方式
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        if (pHead.val != pHead.next.val) {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        } else {
            //如果相等，下意识跳过第一个。自己是没有跳，所以报错。
            ListNode pNode= pHead.next;
            while (pNode !=null && pNode.val == pHead.val){
                pNode = pNode.next;
            }
            return deleteDuplication(pNode);
        }
    }
}
