public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
//        head.next.next = new ListNode(5);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
//        head2.next.next = new ListNode(6);
        head = Merge(head, head2);
        int i = 2;
    }

    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

//    public static ListNode Merge(ListNode list1, ListNode list2) {
//        ListNode mergeResult = new ListNode(-1);
//        mergeResult.next = null;
//        ListNode head = mergeResult;
//        while (list1 != null && list2 != null) {
//            if (list1.val < list2.val) {
//                mergeResult.next = list1;
//                mergeResult = mergeResult.next;
//                list1 = list1.next;
//            } else {
//                mergeResult.next = list2;
//                mergeResult = mergeResult.next;
//                list2 = list2.next;
//            }
//        }
//        if (list1 != null) {
//           mergeResult.next = list1;
//        }
//        if(list2!=null){
//            mergeResult.next = list2;
//        }
//        return head.next;
//    }
//
//    public static ListNode Merge(ListNode list1, ListNode list2) {
//        ListNode MergeResult = list1;
//        ListNode pre = list1;
//        ListNode next = list2;
//        while (list1 != null && list2 != null) {
//            if (list1.val < list2.val) {
//                pre = list1;
//                list1 = list1.next;
//            } else {
//                next = list2.next;
//                list2.next = list1;
//                pre.next = list2;
//                list2 = next;
//            }
//        }
//        if (list1 == null && list2 != null) {
//            pre.next = list2;
//        }
//        return MergeResult;
//    }
}
