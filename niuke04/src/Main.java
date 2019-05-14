public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(IsBalanced_Solution(root));
    }

    /**
     * 1.最直接的做法，遍历每个结点，借助一个获取树深度的递归函数，
     * 根据该结点的左右子树高度差判断是否平衡，然后递归地对左右子树进行判断。
     *
     * @param root
     * @return
     */
//    public static boolean IsBalanced_Solution(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 &&
//                IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
//    }
//
//    private static int maxDepth(TreeNode root) {
//        if(root ==null)
//            return 0;
//        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
//    }
    private static boolean isBalanced = true;

    public static boolean IsBalanced_Solution(TreeNode root)

}
