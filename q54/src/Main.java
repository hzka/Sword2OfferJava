import jdk.nashorn.api.tree.Tree;

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
        System.out.println(KthNode(root, 2).val);
//        inorder(root);
    }


    static TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode node = pRoot;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                count++;
                if(count == k)
                    return node;
                node = node.right;
            }
        }
        return null;
    }

//    int index = 0;
//    TreeNode KthNode(TreeNode root, int k)
//    {
//        if(root != null){ //中序遍历寻找第k个
//            TreeNode node = KthNode(root.left,k);
//            if(node != null) return node;
//            index ++;
//            if(index == k) return root;
//            node = KthNode(root.right,k);
//            if(node != null) return node;
//        }
//        return null;
//    }

//    static TreeNode KthNode(TreeNode pRoot, int k) {
//          Inorder(pRoot,k);
//          return returnnode;
//    }
//    static int count = 0;
//    static TreeNode returnnode;
//    private static void Inorder(TreeNode pRoot, int k) {
//        if (pRoot == null) return;
//        KthNode(pRoot.left, k);
//        count++;
//        if (count == k) {
//            returnnode = pRoot;
//        }
//        KthNode(pRoot.right, k);
//    }
//
//    public static void inorder(TreeNode root){
//        if(root == null) return;
//        inorder(root.left);
//        System.out.println(root.val+" ");
//        inorder(root.right);
//    }


}
