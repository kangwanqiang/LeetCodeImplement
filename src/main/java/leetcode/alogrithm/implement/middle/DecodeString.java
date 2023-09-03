package main.java.leetcode.alogrithm.implement.middle;

import java.util.Collections;
import java.util.Stack;

/**
 * author: kangwanqiang
 * date: 2023-09-03 16:43
 * description:
 */
public class DecodeString {
    public static void main(String[] args) {
       System.out.println(decodeString("3[a]2[bc]"));
//        String s = "3[a]2[bc]";
//        int end = s.indexOf("]");
//        int start = s.lastIndexOf("[", end);
//        String temp = s.substring(start + 1, end);
//        System.out.println(temp);
    }

    public static String decodeString(String s) {
        while (s.contains("[")) {
            int end = s.indexOf("]");
            int start = s.lastIndexOf("[", end);
            String temp = s.substring(start + 1, end);
            int numLoc;
            for (numLoc = start - 1; numLoc >= 0; numLoc--) {
                char chr = s.charAt(numLoc);
                if (chr < '0' || chr > '9') {
                    break;
                }
            }
            int times = Integer.parseInt(s.substring(numLoc + 1, start));
            String oldString = s.substring(numLoc + 1, end + 1);
            s = s.replace(oldString, String.join("", Collections.nCopies(times, temp)));
        }
        return s;
    }
}
