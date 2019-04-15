public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode node = main.reConstructBinaryTree(pre,in);
        main.PrintTree(node);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        /**
         * 输入合法性判断
         */
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private static TreeNode construct(int[] pre, int pre_start, int pre_end, int[] in, int in_start, int in_end) {
        if (pre_start > pre_end) return null;
        //取前序遍历的第一个数字为根节点
        int value = pre[pre_start];
        //在中序中遍历寻找该根节点
        int index = in_start;
        while (index <= in_end && value != in[index]) {
            index++;
        }
        //判断溢出条件
        if (index > in_end) throw new RuntimeException("Invalid Input");
        //创建当前根节点，并为节点赋值
        TreeNode treeNode = new TreeNode(value);
        //递归调用构建当前节点的左子树
        treeNode.left = construct(pre, pre_start + 1, pre_start + index - in_start, in, in_start, index - 1);
        //先序遍历而言，左子树开始位置是pre_start+1，结束位置是pre_start+index-in_start;
        //中序遍历而言，左子树开始位置是in_start,结束位置是middle -1;

        //递归调用当前节点的右子树
        treeNode.right = construct(pre, pre_start + index - in_start + 1, pre_end, in, index + 1, in_end);
        return treeNode;
    }

    private void PrintTree(TreeNode treeNode){
        if(treeNode!=null){
            PrintTree(treeNode.left);
            PrintTree(treeNode.right);
            System.out.println(treeNode.val+" ");
        }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


