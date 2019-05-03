import java.util.ArrayList;

public class Main {

    private static ArrayList<Integer> array_pre = new ArrayList<Integer>();
    private static ArrayList<Integer> array_in = new ArrayList<Integer>();

    public static void main(String[] args) {
        System.out.println("Hello World!");
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        Mirror(root);
    }

    private static void Mirror(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode tmp =  root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }

//
//    public static void Mirror(TreeNode root) {
//        preorder(root);//根右左
//        inorder(root);//右根左
//        int[] pre = new int[array_pre.size()];
//        int[] in = new int[array_pre.size()];
//        for (int i = 0; i < pre.length; i++) {
//            pre[i] = array_pre.get(i);
//        }
//        for (int j = 0; j < in.length; j++) {
//            in[j] = array_in.get(j);
//        }
//        TreeNode t1 = reConstructBinaryTree(pre, in);
//        int i = 3;
//    }
//
//    private static void inorder(TreeNode root) {
//        if (root != null){
//            //右根左
//            inorder(root.right);
//            array_in.add(root.val);
//            inorder(root.left);
//        }
//    }
//
//    private static void preorder(TreeNode root) {
//        if (root != null) {
//            //根右左
//            array_pre.add(root.val);
//            preorder(root.right);
//            preorder(root.left);
//        }
//    }
//
//    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
//        /**
//                  * 输入合法性判断
//                  */
//        if (pre == null || in == null || pre.length != in.length) {
//            return null;
//        }
//        return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
//    }
//
//    private static TreeNode construct(int[] pre, int pre_start, int pre_end, int[] in, int in_start, int in_end) {
//        if (pre_start > pre_end) return null;
//        //取前序遍历的第一个数字为根节点
//        int value = pre[pre_start];
//        //在中序中遍历寻找该根节点
//        int index = in_start;
//        while (index <= in_end && value != in[index]) {
//            index++;
//        }
//        //判断溢出条件
//        if (index > in_end) throw new RuntimeException("Invalid Input");
//        //创建当前根节点，并为节点赋值
//        TreeNode treeNode = new TreeNode(value);
//        //递归调用构建当前节点的左子树
//        treeNode.left = construct(pre, pre_start + 1, pre_start + index - in_start, in, in_start, index - 1);
////先序遍历而言，左子树开始位置是pre_start+1，结束位置是pre_start+index-in_start;
////中序遍历而言，左子树开始位置是in_start,结束位置是middle -1;
//        //递归调用当前节点的右子树
//        treeNode.right = construct(pre, pre_start + index - in_start + 1, pre_end, in, index + 1, in_end);
//        return treeNode;
//    }
}
