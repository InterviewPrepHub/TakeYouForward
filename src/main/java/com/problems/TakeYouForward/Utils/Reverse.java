package com.problems.TakeYouForward.Utils;

public class Reverse {
    public static String reverse(String str) {

        char[] charArr = str.toCharArray();
        int left = 0;
        int right = str.length()-1;

        while(left < right) {
            char temp = str.charAt(left);
            charArr[left] = charArr[right];
            charArr[right] = temp;
            left++;
            right--;
        }

        return new String(charArr);
    }
}
