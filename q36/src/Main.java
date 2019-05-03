import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(7);
        root.right = new TreeNode(10);
        root.left.right = new TreeNode(8);
        Convert(root);
    }

//    方法一：非递归版
//    解题思路：
//       1.核心是中序遍历的非递归算法。
//       2.修改当前遍历节点与上一个历节点的指针指向。（1）使用堆栈暂存节点p，一直到p的左节点；
//    （2）弹栈判断是不是第一个节点；（3）若不是第一个节点，则改变指针指向。遍历到p的right节点。
//    public static TreeNode Convert(TreeNode root) {
//        if(root==null)  return null;
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        TreeNode p =root;
//        TreeNode pre = null;//用于保存中序遍历的上一节点
//        boolean isFirst = true;
//        while (p!=null || !stack.isEmpty()){
//            while (p!=null){
//                stack.push(p);
//                p = p.left;
//            }
//            p = stack.pop();
//            if(isFirst){
//                root = p;
//                pre = root;
//                isFirst = false;
//            }else{
//                pre.right = p;
//                p.left = pre;
//                pre = p;
//            }
//            p = p.right;
//        }
//       return root;
//    }

//        方法二：递归版
//    解题思路：
//       1.将左子树构造成双链表，并返回链表头节点。
//       2.定位至左子树双链表最后一个节点。
//       3.如果左子树链表不为空的话，将当前root追加到左子树链表。
//       4.将右子树构造成双链表，并返回链表头节点。
//       5.如果右子树链表不为空的话，将该链表追加到root节点之后。
//       6.根据左子树链表是否为空确定返回的节点。
    public static TreeNode Convert(TreeNode root) {
        if(root == null)  return null;
        if(root.left == null && root.right == null)  return root;
//        1.将左子树构造成双链表，并返回链表头节点。
        TreeNode left = Convert(root.left);
        TreeNode p = left;
//        2.定位至左子树双链表最后一个节点。
        while (p!=null && p.right!=null){
            p = p.right;
        }
//       3.如果左子树链表不为空的话，将当前root追加到左子树链表。
        if(left!=null){
            p.right = root;
            root.left = p;
        }
//       4.将右子树构造成双链表，并返回链表头节点。
        TreeNode right = Convert(root.right);
//       5.如果右子树链表不为空的话，将该链表追加到root节点之后。
       if(right!=null){
           right.left = root;
           root.right = right;
       }
       return left!=null?left:root;
    }
}
