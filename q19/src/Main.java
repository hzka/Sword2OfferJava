public class Main {

    public static void main(String[] args) {
        char[] str = {'a', 'a', 'a'};
        char[] pattern = {'a', 'b', '*', 'a', 'c', '*', 'a'};
        System.out.println(match(str, pattern));
    }

//            1>两个字符串都为空，返回true
//         2>当第一个字符串不空，而第二个字符串空了，返回false（因为这样，就无法
//    匹配成功了,而如果第一个字符串空了，第二个字符串非空，还是可能匹配成
//    功的，比如第二个字符串是“a*a*a*a*”,由于‘*’之前的元素可以出现0次，
//    所以有可能匹配成功）
//    之后就开始匹配第一个字符，这里有两种可能：匹配成功或匹配失败。但考虑到pattern
//    下一个字符可能是‘*’， 这里我们分两种情况讨论：pattern下一个字符为‘*’或
//    不为‘*’：
//            1>pattern下一个字符不为‘*’：这种情况比较简单，直接匹配当前字符。如果
//    匹配成功，继续匹配下一个；如果匹配失败，直接返回false。注意这里的
//            “匹配成功”，除了两个字符相同的情况外，还有一种情况，就是pattern的
//    当前字符为‘.’,同时str的当前字符不为‘\0’。
//            2>pattern下一个字符为‘*’时，稍微复杂一些，因为‘*’可以代表0个或多个。
//    这里把这些情况都考虑到：
//    a>当‘*’匹配0个字符时，str当前字符不变，pattern当前字符后移两位，
//    跳过这个‘*’符号；
//    b>当‘*’匹配1个或多个时，str当前字符移向下一个，pattern当前字符
//    不变。（这里匹配1个或多个可以看成一种情况，因为：当匹配一个时，
//    由于str移到了下一个字符，而pattern字符不变，就回到了上边的情况a；
//    当匹配多于一个字符时，相当于从str的下一个字符继续开始匹配）
//    之后再写代码就很简单了
    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    private static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检查，str到尾，patter到尾，此时匹配成功。
        if (strIndex == str.length && patternIndex == pattern.length) return true;
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) return false;
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if (strIndex != str.length && pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2) ||//模式后移2，视为x*匹配0个字符
                        matchCore(str, strIndex + 1, pattern, patternIndex + 2) ||//视为模式匹配1个字符
                        matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if((strIndex!=str.length && pattern[patternIndex]==str[strIndex])||(pattern[patternIndex]=='.' && strIndex!=str.length)){
            return  matchCore(str,strIndex+1,pattern,patternIndex+1);
        }
        return false;
    }
//    public static boolean match(char[] str, char[] pattern) {
//        String strs = String.valueOf(str);
//        String patterns = String.valueOf(pattern);
//        return strs.matches(patterns);
//    }
//        StringBuffer strs = new StringBuffer();
//        StringBuffer patterns = new StringBuffer();
//        for(int i = 0;i<str.length;i++){
//            strs.append(str[i]);
//        }
//        for(int j = 0;j<pattern.length;j++){
//            patterns.append(pattern[j]);
//        }
//        return strs.toString().matches(patterns.toString());
//    }
}
