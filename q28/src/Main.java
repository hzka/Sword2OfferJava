public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
//        Mirror(root);
        System.out.println(isSymmetrical(root));
    }

    private static boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot ==null)  return true;
        return compareWith(pRoot.left,pRoot.right);
    }

    private static boolean compareWith(TreeNode left, TreeNode right) {
        if(left ==null && right ==null) return true;
        if(left!=null && right!=null)
            return left.val == right.val && compareWith(left.left,right.right)
                    && compareWith(left.right,right.left);
        return false;
    }

//    static boolean isSymmetrical(TreeNode pRoot) {
//
//        TreeNode pRoot_Mirror = pRoot;
//        TreeNode pRoot_origin = CloneTree(pRoot);
//        GetMirror(pRoot_Mirror);
//        return getSimilarity(pRoot_origin, pRoot_Mirror);
//    }
//
//    private static TreeNode CloneTree(TreeNode pRoot) {
//        TreeNode node = null;
//        if (pRoot == null) return null;
//        node = new TreeNode(pRoot.val);
//        node.left = CloneTree(pRoot.left);
//        node.right = CloneTree(pRoot.right);
//
//        return node;
//    }
//
//    private static boolean getSimilarity(TreeNode pRoot, TreeNode pRoot_mirror) {
//        if (pRoot != null && pRoot_mirror == null) return false;
//        if (pRoot == null && pRoot_mirror != null) return false;
//        if (pRoot == null && pRoot_mirror == null) return true;
//        if (pRoot.val != pRoot_mirror.val) return false;
//        return getSimilarity(pRoot.left, pRoot_mirror.left) && getSimilarity(pRoot.right, pRoot_mirror.right);
//    }
//
//    private static void GetMirror(TreeNode pRoot_mirror) {
//        if (pRoot_mirror == null) return;
//        TreeNode treeNode = pRoot_mirror.left;
//        pRoot_mirror.left = pRoot_mirror.right;
//        pRoot_mirror.right = treeNode;
//        GetMirror(pRoot_mirror.left);
//        GetMirror(pRoot_mirror.right);
//    }

}
