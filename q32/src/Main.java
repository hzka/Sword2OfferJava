
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.left.left = new TreeNode(7);
        PrintFromTopToBottom(root);

    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        if(root == null){
            return arraylist;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode nowParent = queue.remove();
            arraylist.add(nowParent.val);
            if (nowParent.left != null) {
                queue.add(nowParent.left);
            }
            if (nowParent.right != null) {
                queue.add(nowParent.right);
            }
        }
        return arraylist;
    }
}
