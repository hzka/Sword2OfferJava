import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        Print(root);
    }

    static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot, 1, list);
        return list;
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0;i<num.length-size+1;i++){
            int MAX = Integer.MIN_VALUE;
            for(int j = i;j<size;j++){
                MAX = (MAX>num[j]?MAX:num[j]);
            }
            result.add(MAX);
        }
        return result;
    }

    private static void depth(TreeNode pRoot, int depth, ArrayList<ArrayList<Integer>> list) {
        if (pRoot == null) return;
        if (depth > list.size()) list.add(new ArrayList<>());
        list.get(depth - 1).add(pRoot.val);

        depth(pRoot.left, depth + 1, list);
        depth(pRoot.right, depth + 1, list);
    }
//    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
//        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
//        if (pRoot == null)
//            return results;
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.add(pRoot);
//        while (!queue.isEmpty()) {
//            ArrayList<Integer> layer = new ArrayList<Integer>();
//            int cur = 0, size = queue.size();
//            Iterator<TreeNode> it = queue.iterator();
//            while (it.hasNext()) {
//                layer.add(it.next().val);
//            }
//            while (cur < size) {
//                TreeNode node = queue.pop();
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//                cur++;
//            }
//            results.add(layer);
//        }
//        return results;
//    }
}
