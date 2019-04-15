public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    //1、如果该结点有右子树，则该结点的下一个结点为该结点的右子树的最左结点。
//2、如果该结点没有右子树，则又分两种情况讨论：
//情况一：如果该结点为该结点的父结点的左孩子，则该结点的父结点pNode.next则为下一个结点。
//情况二：如果该结点为该结点的父结点的右孩子，则该结点的父结点的父结点的父结点，
// 直到其中的一个父结点是这个父结点的左孩子，则该父结点的父结点为下一个结点。
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //1.如果有右子树，那么下一个结点就是右子树最左边的节点。
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) pNode = pNode.left;
            return pNode;
        }
        //2.如果没有右子树，分两种情况，(1)如果该结点的为父结点的左孩子，则该结点的父节点pNode.next则为该结点的下一个结点。
        //(2)如果该结点的为父节点的右孩子，则向上找父节点，直到父节点为该父节点的左孩子，则该父节点的父节点为下一个结点。
        while (pNode.next != null) {
            if (pNode.next.left == pNode) return pNode.next;
            pNode = pNode.next;
        }
        //3.如果遍历到根节点，说明是从右边上来的，返回null。
        return null;
    }
}
