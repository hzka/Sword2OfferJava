public class Main {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(13);
        root.left = new TreeNode(15);
        root.right = new TreeNode(18);
        root.left.left = new TreeNode(10);
        root.right.right = new TreeNode(19);
        String str = Serialize(root);
//        System.out.println(Serialize(root));
        TreeNode node = Deserialize(str);
        int t =4;
    }
    static int index = -1;
    static String Serialize(TreeNode root) {
       StringBuilder sb = new StringBuilder();
       if(root == null) return sb.append("#,").toString();
       sb.append(root.val+",");
       sb.append(Serialize(root.left));
       sb.append(Serialize(root.right));
       return sb.toString();
    }

    static TreeNode Deserialize(String str) {
        index++;
        String[] splits = str.split(",");
        TreeNode node = null;
        if(!splits[index].equals("#")){
            node = new TreeNode(Integer.valueOf(splits[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
