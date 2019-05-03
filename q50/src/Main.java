import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    public static int FirstNotRepeatingChar(String str) {
        HashMap<Character,Integer>  map = new HashMap<Character, Integer>();
        for(int i = 0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int time = map.get(str.charAt(i));//获取map中键值为str.charAt(i)的值
                map.put(str.charAt(i),++time);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        for(int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            if(map.get(c)==1){
                return i;
            }
        }
        return -1;
    }

//    public static int FirstNotRepeatingChar(String str) {
//        for (int i = 0; i < str.length(); i++) {
//            if (str.indexOf(str.substring(i, i + 1)) == str.lastIndexOf(str.substring(i, i + 1))) {
//                return i;
//            }
//        }
//        return -1;
//    }
}
