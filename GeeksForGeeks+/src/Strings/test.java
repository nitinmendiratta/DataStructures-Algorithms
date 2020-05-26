/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strings;

public class test {
    public static boolean areAnagram(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) {
            return false;
        } else if (s1.length() != s2.length()) {
            return false;
        }
        // Create a count array and initialize all values as 0 
        int[] count = new int[256];
        int len = s1.length();
        // For each character in input strings, increment count in 
        // the corresponding count array 
        for (int i = 0; i < len; i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        // See if there is any non-zero value in count array 
        for (int i = 0; i < len; i++) {
            if (count[s1.charAt(i)] > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean areAnagram1(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) {
            return false;
        } else if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        int xor = 0;
        for (int i = 0; i < len; i++) {
            xor ^= s1.charAt(i);
        }
        for (int i = 0; i < len; i++) {
            xor ^= s2.charAt(i);
        }
        return xor == 0;
    }

    public static void main(String[] args) {
        String str1 = "LISTEN";
        String str2 = "SIPENT";
        if (areAnagram(str1, str2)) {
            System.out.println("The two strings are"
                    + " anagram of each other");
        } else {
            System.out.println("The two strings are not"
                    + " anagram of each other");
        }

        if (areAnagram1(str1, str2)) {
            System.out.println("The two strings are"
                    + " anagram of each other");
        } else {
            System.out.println("The two strings are not"
                    + " anagram of each other");
        }
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Strings_Solutions;
///**
// * @author divinity
// */
//public class FibonacciOfNthTerm {
//    int k = 2;
//    public static int fib(int p) {
//        if (p <= 1) {
//            return p;
//        }
//        return fib(p - 1) + fib(p - 2);
//    }
//    public static void main(String args[]) {
//        int n = 9;
//        System.out.println(fib(n));
//    }
//}