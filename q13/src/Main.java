public class Main {
//
//    1.从(0,0)开始走，每成功走一步标记当前位置为true,然后从当前位置往四个方向探索，返回1 + 4 个方向的探索值之和。
//    2.探索时，判断当前节点是否可达的标准为：
//      1）当前节点在矩阵内；
//      2）当前节点未被访问过；
//      3）当前节点满足limit限制。

    private static int counting = 0;

    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 3));
    }

    public static int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return countingSteps(threshold, rows, cols, 0, 0, visited);
    }

    private static int countingSteps(int threshold, int rows, int cols, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j] || (bitSum(i) + bitSum(j) > threshold))
            return 0;
        visited[i][j] = true;
        return countingSteps(threshold, rows, cols, i - 1, j, visited) +
                countingSteps(threshold, rows, cols, i + 1, j, visited) +
                countingSteps(threshold, rows, cols, i, j - 1, visited) +
                countingSteps(threshold, rows, cols, i, j + 1, visited) + 1;
    }

    private static int bitSum(int i) {
        int count = 0;
        while (i != 0) {
            count += i % 10;
            i /= 10;
        }
        return count;
    }
//    public static int movingCount(int threshold, int rows, int cols) {
//        //第一个参数是数组是数字k，第二个是行，第三个是列。
//        boolean[] flags = new boolean[rows * cols];
//
//        howmanyblocks(threshold, rows, cols, 0, 0, flags);
//        return counting;
//    }
//
//    private static boolean howmanyblocks(int threshold, int rows, int cols, int i, int j, boolean[] flags) {
//        int index = i * cols + j;
//        //第一种判断各种越界情况
//        if (i < 0 || j < 0 || i >= rows || j >= cols) {
//            return false;
//        }
//        //第二种判断该位置是否满足要求
//        if (judgetruorfalse(i, j, threshold)) {
//            return false;
//        }
//        counting++;
//        flags[index] = true;
//        if (!judgetruorfalse(i - 1, j, threshold) && (((i - 1) * cols + j) >= 0) && (((i - 1) * cols + j) < rows * cols) && !flags[(i - 1) * cols + j]
//        ) {
//            howmanyblocks(threshold, rows, cols, i - 1, j, flags);
//        }
//        if (!judgetruorfalse(i + 1, j, threshold) && ((i + 1) * cols + j) >= 0 && ((i + 1) * cols + j) < rows * cols && !flags[(i + 1) * cols + j]
//        ) {
//            howmanyblocks(threshold, rows, cols, i + 1, j, flags);
//        }
//        if (!judgetruorfalse(i, j - 1, threshold) && (i * cols + j - 1) >= 0 && (i * cols + j - 1) < rows * cols && !flags[i * cols + j - 1]
//        ) {
//            howmanyblocks(threshold, rows, cols, i, j - 1, flags);
//        }
//        if (!judgetruorfalse(i, j + 1, threshold) && (i * cols + j + 1) >= 0 && (i * cols + j + 1) < rows * cols && !flags[i * cols + j + 1]
//        ) {
//            howmanyblocks(threshold, rows, cols, i, j + 1, flags);
//        }
//        return true;
//    }
//
//    private static boolean judgetruorfalse(int i, int j, int threshold) {
//        int rows_Num = String.valueOf(i).length();
//        int cols_Num = String.valueOf(j).length();
//        int add_result = 0;
//        for (int k = 0; k < rows_Num; k++) {
//            add_result += (String.valueOf(i).charAt(k) - '0');
//        }
//        for (int k = 0; k < cols_Num; k++) {
//            add_result += (String.valueOf(j).charAt(k) - '0');
//        }
//        if (add_result > threshold) return true;
//        else return false;
//    }
}
