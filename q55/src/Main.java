import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        System.out.println(TreeDepth(root));
//        inorder(root);
    }
    public static int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0,count = 0,nextcount = 1;
        //使用队列来实现层次遍历
        while (queue.size()!=0){
            TreeNode top = queue.remove();
            count++;
            if(top.left!=null){
                queue.add(top.left);
            }
            if(top.right!=null){
                queue.add(top.right);
            }
            if(count == nextcount){
                nextcount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }
    /**
     * 递归遍历：如果该树只有一个结点，它的深度为1.如果根节点只有左子树没有右子树，
     * 那么树的深度为左子树的深度加1；同样，如果只有右子树没有左子树，
     * 那么树的深度为右子树的深度加1。如果既有左子树也有右子树，
     * 那该树的深度就是左子树和右子树的最大值加1.
     * @param root
     * @return
     */
//    public static int TreeDepth(TreeNode root) {
//        if (root == null)
//            return 0;
//        int left = TreeDepth(root.left);
//        int right = TreeDepth(root.right);
//        return Math.max(left, right) + 1;
//    }
}


