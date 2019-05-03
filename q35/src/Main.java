public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) return null;
        RandomListNode currentNode = pHead;
        //1.复制每一个节点，譬如复制节点A到节点A1，将节点A1插到节点A的后面,将指针指向NextNode位置，
        while(currentNode!=null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }
        currentNode = pHead;
        //2.重新遍历链表，复制老节点的随机指针给新节点，譬如A1.random = A.random.next;
        while(currentNode!=null){
            currentNode.next.random = currentNode.random == null?null:currentNode.random.next;
            currentNode = currentNode.next.next;
        }
        //3.拆分链表，将链表拆分为原链表和复制后得链表
        currentNode = pHead;
        RandomListNode pCloneNode = pHead.next;
        while(currentNode!=null){
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            currentNode = currentNode.next;
        }
        return pCloneNode;
    }
}
