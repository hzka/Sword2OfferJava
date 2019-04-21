public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail != null) {
                tail = tail.next;
            } else {
                return null;
            }
        }
        while (tail != null) {
            head = head.next;
            tail = tail.next;
        }
        return head;
    }

//    public static ListNode FindKthToTail(ListNode head,int k) {
//        //计算listnode的总长度
//        ListNode store_point = head;
//        int listnode_length = 0;
//        while(head!=null){
//            listnode_length++;
//            head = head.next;
//        }
//        if(k > listnode_length)  return null;
//        int real_pos = listnode_length - k;
//        for(int i = 0;i<real_pos;i++){
//            store_point = store_point.next;
//        }
//        return store_point;
//    }
}
