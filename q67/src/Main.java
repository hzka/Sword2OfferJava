public class Main {

    public static void main(String[] args) {
        System.out.println(StrToInt("-2147483648"));
    }

    public static int StrToInt(String str) {
        if (str.length() == 0) return 0;
        long results = 0;
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-' && i == 0) {
                flag = false;
                continue;
            } else if (str.charAt(i) == '+' && i == 0) {
                continue;
            }
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                int number = str.charAt(i) - '0';
                results = results * 10 + number;
            } else {
                return 0;
            }
        }
        if (flag) {
            if(results > Integer.MAX_VALUE){
                return 0;
            }else{
                return (int) results;
            }

        } else {
            if(-results >= Integer.MIN_VALUE){
                return 0;
            }else{
                return (int) -results;
            }
        }
    }
}
