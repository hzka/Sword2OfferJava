import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

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

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (pRoot == null)
            return results;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            ArrayList<Integer> layer = new ArrayList<Integer>();
            int cur = 0, size = queue.size();
            if ((depth & 1) == 0) {//偶数层倒序添加。
                Iterator<TreeNode> it = queue.descendingIterator();
                while (it.hasNext()) {
                    layer.add(it.next().val);
                }
            } else {//奇数层顺序添加
                Iterator<TreeNode> it = queue.iterator();
                while (it.hasNext()) {
                    layer.add(it.next().val);
                }
            }
            while (cur < size) {
                TreeNode node = queue.pop();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                cur++;
            }
            results.add(layer);
        }
        return results;
    }
//    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
//        int layer = 1;
//        //存奇数层节点
//        Stack<TreeNode> s1 = new Stack<>();
//        s1.push(pRoot);
//        //存偶数层节点
//        Stack<TreeNode> s2 = new Stack<>();
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        while (!s1.empty() || !s2.empty()) {
//            //对于奇数层的处理
//            if (layer % 2 != 0) {
//                ArrayList<Integer> temp = new ArrayList<>();
//                while (!s1.empty()) {
//                    TreeNode node = s1.pop();
//                    if (node != null) {
//                        temp.add(node.val);
//                        s2.push(node.left);
//                        s2.push(node.right);
//                    }
//                }
//                if(!temp.isEmpty()){
//                    list.add(temp);
//                    layer++;
//                }
//            } else {
//                ArrayList<Integer> temp = new ArrayList<>();
//                while (!s2.isEmpty()) {
//                    TreeNode node = s2.pop();
//                    if (node != null) {
//                        temp.add(node.val);
//                        s1.push(node.right);
//                        s1.push(node.left);
//                    }
//                }
//                if(!temp.isEmpty()){
//                    list.add(temp);
//                    layer++;
//                }
//            }
//        }
//        return list;
//    }

//    static LinkedList<TreeNode> queue = new LinkedList<>();
//
//    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
//        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//        queue.add(pRoot);
//        boolean flag = false;
//        ArrayList<Integer> arraylist = new ArrayList<>();
//        while (!queue.isEmpty()) {
//            TreeNode temp;
//            if (!flag) {
//                temp = queue.remove();
//                if (temp != null) {
//                    arraylist.add(temp.val);
//                    flag = true;
//                    queue.add(temp.right);
//                    queue.add(temp.left);
//                }
//            } else {
//                temp = queue.remove();
//                if (temp != null) {
//                    arraylist.add(temp.val);
//                    flag = false;
//                    queue.add(temp.left);
//                    queue.add(temp.right);
//                }
//            }
//        }
//        result.add(arraylist);
//        return result;
//    }
}
