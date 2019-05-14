public class Main {

    public static void main(String[] args) {
        System.out.println(ReverseSentence("student. a am I"));
    }
//    public static String ReverseSentence(String str) {
//        if(str.length()== 0 ) return "";
//        //去掉字符串首尾的空格
//        if(str.trim().equals("")){
//            return str;
//        }
//        StringBuilder sb = new StringBuilder();
//        String[] allstyrings = str.split(" ");
//        for(int i = allstyrings.length-1;i>=0;i--){
//            sb.append(allstyrings[i]+" ");
//        }
//        int str_length = sb.toString().length();
//        return sb.toString().substring(0,str_length-1);
//    }

    public static String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int blank = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                int nextBlank = i;
                reverse(chars, blank + 1, nextBlank - 1);
                blank = nextBlank;
            }
        }
        reverse(chars,blank+1,chars.length-1);
        return new String(chars);
    }

    private static void reverse(char[] chars, int low, int high) {
        while (low < high) {
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }
}
