import java.util.Queue;

//         对字符串中的每个字符进行判断分析
//        e（E）后面只能接数字，并且不能出现2次
//        对于+、-号，只能出现在第一个字符或者是e的后一位
//        对于小数点，不能出现2次，e后面不能出现小数点
public class Main {

    public static void main(String[] args) {
        char[] str = {'1', '2', 'e', '+', '4', '.', '3'};
        System.out.println(isNumeric(str));
    }

    public static boolean isNumeric(char[] str) {
        //标记符号、小数点、e是否出现过。
        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            //1.确保e后面必须有数字，2.确保不能同时存在两个e。
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == str.length - 1) return false;
                if (hasE) return false;
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                //1.第二次出现+-号，则其必须紧接在e之后。2.第一次出现+-时，且不是在字符串开头，
                // 则必须接在e之后
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                sign = true;
            } else if (str[i] == '.') {
                //e后面不能接小数点，小数点不能超过两次
                if (hasE || decimal) return false;
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') {
                //排除掉不合法字符
                return false;
            }
        }
        return true;
    }

}


//    public static boolean isNumeric(char[] str) {
//        String s1 = String.valueOf(str);
//        try {
//            Double var = Double.parseDouble(s1);
//        } catch (Exception e) {
//            return false;
//        }
//        return true;
//    }

