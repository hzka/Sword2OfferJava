import java.util.ArrayList;

public class Main {
    public static ArrayList<ArrayList<Integer>> alllist = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<Integer> arraylist = new ArrayList<Integer>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(4);
        FindPath(root, 22);
    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return alllist;
        arraylist.add(root.val);
        if (root.left == null && root.right == null) {
            int sum = 0;
            for (int i = 0; i < arraylist.size(); i++) {
                sum += arraylist.get(i);
            }
            if (sum == target) {
                alllist.add(new ArrayList<Integer>(arraylist));
            }
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        arraylist.remove(arraylist.size() - 1);
        return alllist;
    }
}
