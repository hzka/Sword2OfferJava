public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int target = 1;
        System.out.println(Find(target, array));
    }

    public static boolean Find(int target, int[][] array) {
//        if (array.length == 0 || array[0].length == 0) return false;
//        int flag = array.length;
//        for (int i = 0; i < array.length; i++) {
//            if (target == array[i][0]) {
//                return true;
//            } else if (target < array[i][0]) {
//                flag = i;
//                break;
//            }
//        }
//        for (int i = 0; i < flag; i++) {
//            for (int j = 0; j < array[0].length; j++) {
//                if (target == array[i][j]) {
//                    return true;
//                }
//            }
//        }
//        return false;

//        int row=0;
//        int col=array[0].length-1;
//        while(row<=array.length-1&&col>=0){
//            if(target==array[row][col])
//                return true;
//            else if(target>array[row][col])
//                row++;
//            else
//                col--;
//        }
//        return false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                int low = 0;
                int high = array[0].length - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (target < array[i][mid]) {
                        high = mid - 1;
                    } else if (target > array[i][mid]) {
                        low = mid + 1;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
