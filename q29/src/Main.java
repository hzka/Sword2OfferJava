import java.util.ArrayList;

public class Main {
//    private static ArrayList<Integer> arrayList = new ArrayList<Integer>();
//    private static int priority_judge = 0;

    public static void main(String[] args) {
        int[][] matrix = {{1, 2,3,4}, {5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrix(matrix);
    }

    public static ArrayList<Integer> printMatrix(int [][] array) {
        ArrayList<Integer> result = new ArrayList<Integer> ();
        if(array.length==0) return result;
        int n = array.length,m = array[0].length;//行数和列数
        if(m==0) return result;
        int layers = (Math.min(n,m)-1)/2+1;//圈数
        for(int i=0;i<layers;i++){
            //从左向右打印
            for(int k = i;k<m-i;k++)
                result.add(array[i][k]);
            //从上往下的每一列数据
            for(int j=i+1;j<n-i;j++)
                result.add(array[j][m-i-1]);
            //判断是否会重复打印(从右向左的每行数据),首先保证右边再保证左边
            for(int k=m-i-2;(k>=i)&&(n-i-1!=i);k--)
                result.add(array[n-i-1][k]);
            //判断是否会重复打印(从下往上的每一列数据),首先保证下边比上边大，再保证不要往上走越界了，
            for(int j=n-i-2;(j>i)&&(m-i-1!=i);j--)
                result.add(array[j][i]);
        }
        return result;
    }
//    public static ArrayList<Integer> printMatrix(int[][] matrix) {
//        if (matrix.length == 0 && matrix[0].length == 0) return null;
//        boolean[][] matrix_check = new boolean[matrix.length][matrix[0].length];
//
//        traversing(matrix, 0, 0, matrix_check, priority_judge);
//        return arrayList;
//    }
//
//    private static void traversing(int[][] matrix, int row, int column, boolean[][] matrix_check, int priority_judge) {
//        arrayList.add(matrix[row][column]);
//        matrix_check[row][column] = true;
//        boolean isValid = false;
//        switch (priority_judge) {
//            case 0:
//                if (column >= 0 && column < matrix[0].length - 1 && !matrix_check[row][column + 1]) {
//                    //优先级为0,向右走。
//                    traversing(matrix, row, column + 1, matrix_check, 0);
//                }
//                if (0 <= row && row < matrix.length - 1 && !matrix_check[row + 1][column]) {
//                    //优先级为1,向下走。
//                    traversing(matrix, row + 1, column, matrix_check, 1);
//                }
//                if (column - 1 >= 0 && !matrix_check[row][column - 1]) {
//                    //优先级为2,向左走。
//                    traversing(matrix, row, column - 1, matrix_check, 2);
//                }
//                if (row - 1 >= 0 && !matrix_check[row - 1][column]) {
//                    //优先级为3,向上走。
//                    traversing(matrix, row - 1, column, matrix_check, 3);
//                }
//                break;
//            case 1:
//                if (0 <= row && row < matrix.length - 1 && !matrix_check[row + 1][column]) {
//                    //优先级为1,向下走。
//                    traversing(matrix, row + 1, column, matrix_check, 1);
//                }
//                if (column - 1 >= 0 && !matrix_check[row][column - 1]) {
//                    //优先级为2,向左走。
//                    traversing(matrix, row, column - 1, matrix_check, 2);
//                }
//                if (row - 1 >= 0 && !matrix_check[row - 1][column]) {
//                    //优先级为3,向上走。
//                    traversing(matrix, row - 1, column, matrix_check, 3);
//                }
//                if (column >= 0 && column < matrix[0].length - 1 && !matrix_check[row][column + 1]) {
//                    //优先级为0,向右走。
//                    traversing(matrix, row, column + 1, matrix_check, 0);
//                }
//                break;
//            case 2:
//                if (column - 1 >= 0 && !matrix_check[row][column - 1]) {
//                    //优先级为2,向左走。
//                    traversing(matrix, row, column - 1, matrix_check, 2);
//                }
//                if (row - 1 >= 0 && !matrix_check[row - 1][column]) {
//                    //优先级为3,向上走。
//                    traversing(matrix, row - 1, column, matrix_check, 3);
//                }
//                if (column >= 0 && column < matrix[0].length - 1 && !matrix_check[row][column + 1]) {
//                    //优先级为0,向右走。
//                    traversing(matrix, row, column + 1, matrix_check, 0);
//                }
//                if (0 <= row && row < matrix.length - 1 && !matrix_check[row + 1][column]) {
//                    //优先级为1,向下走。
//                    traversing(matrix, row + 1, column, matrix_check, 1);
//                }
//                break;
//            case 3:
//                if (row - 1 >= 0 && !matrix_check[row - 1][column]) {
//                    //优先级为3,向上走。
//                    traversing(matrix, row - 1, column, matrix_check, 3);
//                }
//                if (column >= 0 && column < matrix[0].length - 1 && !matrix_check[row][column + 1]) {
//                    //优先级为0,向右走。
//                    traversing(matrix, row, column + 1, matrix_check, 0);
//                }
//                if (0 <= row && row < matrix.length - 1 && !matrix_check[row + 1][column]) {
//                    //优先级为1,向下走。
//                    traversing(matrix, row + 1, column, matrix_check, 1);
//                }
//                if (column - 1 >= 0 && !matrix_check[row][column - 1]) {
//                    //优先级为2,向左走。
//                    traversing(matrix, row, column - 1, matrix_check, 2);
//                }
//                break;
//        }
//        return;
//    }
}
