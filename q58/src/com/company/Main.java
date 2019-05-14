package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(LeftRotateString("abcXYZdef", 3));
    }

//    public static String LeftRotateString(String str, int n) {
//        if (n >= str.length()) return str;
//        StringBuilder returnstr = new StringBuilder();
//        returnstr.append(str.substring(n, str.length()));
//        returnstr.append(str.substring(0, n));
//        return returnstr.toString();
//    }

//    这道题考的核心是应聘者是不是可以灵活利用字符串翻转。假设字符串abcdef，n=3，
//    设X=abc，Y=def，所以字符串可以表示成XY，如题干，问如何求得YX。假设X的翻转为XT，
//    XT=cba，同理YT=fed，那么YX=(XTYT)T，三次翻转后可得结果。
    public static String LeftRotateString(String str, int n) {
        char[] chars = str.toCharArray();
        if(chars.length<n) return "";
        reverse(chars,0,n-1);
        reverse(chars,n,chars.length-1);
        reverse(chars,0,chars.length-1);
        StringBuilder sb = new StringBuilder(chars.length);
        for(char c:chars){
            sb.append(c);
        }
        return sb.toString();
    }

    private static void reverse(char[] chars, int low, int high) {
        char temp;
        while (low<high){
            temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }
}
