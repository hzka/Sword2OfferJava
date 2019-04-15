import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = {'b', 'c', 'c', 'e', 'd'};
        char[] str01 = {'a', 'b', 'c', 'b'};
        System.out.println(hasPath(matrix, 3, 4, str));
        System.out.println(hasPath(matrix, 3, 4, str01));
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (judge(matrix, i, j, rows, cols, str, flag, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    //字符串索引初始为0即先判断字符串的第一位
    private static boolean judge(char[] matrix, int i, int j, int rows, int cols, char[] str, boolean[] flag, int k) {
        //转换一维数组位置
        int index = i * cols + j;
        //递归的终止条件
        if (i < 0 || j < 0 || j >= cols || i >= rows || matrix[index] != str[k] || flag[index] == true) {
            return false;
        }
        //若k已经到str末尾了，说明之前匹配都成功了，直接返回ture就可以了。
        if (k == str.length - 1) return true;
        flag[index] = true;

        //回溯，递归寻找，每次找到了就给k加一，找不到，还原
        if (judge(matrix, i - 1, j, rows, cols, str, flag, k + 1) ||
                judge(matrix, i + 1, j, rows, cols, str, flag, k + 1) ||
                judge(matrix, i, j - 1, rows, cols, str, flag, k + 1) ||
                judge(matrix, i, j + 1, rows, cols, str, flag, k + 1)) {
            return true;
        }
        //走到这，说明走不通，还原，再试试其他路径
        flag[index] = false;
        return false;
    }
}
