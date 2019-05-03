import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int [] sequence = {1,2,5,4,3,8,10,9,7,6};
        System.out.println(VerifySquenceOfBST(sequence));
    }
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        int [] in = Arrays.copyOf(sequence,sequence.length);
        Arrays.sort(sequence);
        try {
            reConstructBinaryTree(sequence, in);
            return true;
        }catch (Exception e){
            return false;
        }
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
        //在后序中寻找第一个节点
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
        treeNode.right = construct(pre, pre_start + index - in_start + 1, pre_end, in, index + 1, in_end);
        return treeNode;
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
