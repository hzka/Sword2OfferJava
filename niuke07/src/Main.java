import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Insert('g');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('g');
        System.out.println(FirstAppearingOnce());
        Insert('l');
        System.out.println(FirstAppearingOnce());
        Insert('e');
        System.out.println(FirstAppearingOnce());
    }

    static int[] temp = new int[128];
    static LinkedList<Character> queue = new LinkedList<>();

    public static void Insert(char ch) {
        if (temp[ch - ' '] == 0) {
            queue.add(ch);
        }
        temp[ch - ' ']++;
    }

    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce() {
        while (!queue.isEmpty() && temp[queue.getFirst() - ' '] >= 2) {
            queue.removeFirst();
        }
        if(!queue.isEmpty()){
            return queue.getFirst();
        }
        return '#';
    }
}
//    static String str = new String();
//    //Insert one char from stringstream
//    public static void Insert(char ch)
//    {
//        str+=ch;
//    }
//    //return the first appearence once char in current stringstream
//    public static char FirstAppearingOnce()
//    {
//        HashMap<Character,Integer> hashmap = new HashMap<>();
//        for(int i = 0;i<str.length();i++){
//            if(!hashmap.containsKey(str.charAt(i))){
//                hashmap.put(str.charAt(i),1);
//            }else{
//                int numbers = hashmap.get(str.charAt(i));
//
//                hashmap.put(str.charAt(i),++numbers);
//            }
//        }
//        for(int i = 0;i<str.length();i++){
//            if(hashmap.get(str.charAt(i))==1){
//                return str.charAt(i);
//            }
//        }
//        return '#';
//    }
