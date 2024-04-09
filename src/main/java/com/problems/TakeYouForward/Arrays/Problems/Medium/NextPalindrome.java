package com.problems.TakeYouForward.Arrays.Problems.Medium;

import com.problems.TakeYouForward.Utils.Reverse;

public class NextPalindrome {

    public static void main(String[] args) {
        long num1 = 97531;
        long num2 = 23545;
        long num3 = 13937;
        long num4 = 53545;
        long num5 = 1234567;
        long num6 = 999;

        long num7 = 1337;
        long num8 = 8999;
        long num9 = 99;

        NextPalindrome n = new NextPalindrome();

        n.nextPalindrome(String.valueOf(num9));
    }

    private void nextPalindrome(String s) {

        int len = s.length();

        //odd case
        if(len % 2 != 0) {
            int mid = len/2;

            String leftStr = s.substring(0, mid);
            String rightStr = s.substring(mid+1, len);

            if(Integer.valueOf(leftStr) > Integer.valueOf(rightStr)) {
                //reverse leftStr & keep the mid
                String reverseStr = Reverse.reverse(leftStr);
                String midStr = null;

                if(Integer.valueOf(reverseStr) < Integer.valueOf(rightStr)) {
                    //increment mid number
                    char ch = s.charAt(mid);
                    int res = Integer.valueOf(String.valueOf(ch)) + 1;
                    rightStr = Reverse.reverse(leftStr);
                    midStr = String.valueOf(res);

                } else {
                    rightStr = Reverse.reverse(leftStr);
                    midStr = String.valueOf(s.charAt(mid));
                }
                StringBuilder sb = new StringBuilder();
                sb.append(leftStr);
                sb.append(midStr);
                sb.append(rightStr);

                System.out.println(sb.toString());
            } else {

                //check if the mid number is 9
                if(s.charAt(mid) == '9') {
                    int carry = 1;
                    String midStr = "0";

                    int leftNum = Integer.valueOf(leftStr)+1;
                    leftStr = String.valueOf(leftNum);
                    //revese leftNum
                    rightStr = Reverse.reverse(leftStr);

                    StringBuilder sb = new StringBuilder();
                    sb.append(leftStr);
                    sb.append(midStr);
                    sb.append(rightStr);

                    System.out.println(sb.toString());
                } else {
                    //reverse leftStr and increment the number in mid
                    rightStr = Reverse.reverse(leftStr);

                    char ch = s.charAt(mid);
                    int res = Integer.valueOf(String.valueOf(ch));

                    StringBuilder sb = new StringBuilder();
                    sb.append(leftStr);
                    sb.append(res+1);
                    sb.append(rightStr);

                    System.out.println(sb.toString());
                }

            }

        }
        //odd cases
        else {

            int mid = len/2;

            String leftStr = s.substring(0, mid);
            String rightStr = s.substring(mid, len);

            if(Integer.valueOf(leftStr) < Integer.valueOf(rightStr)) {
                String revString = Reverse.reverse(leftStr);    //31

                if (Integer.valueOf(revString) < Integer.valueOf(rightStr)) {
                    int incLeftStr = Integer.valueOf(leftStr) + 1;
                    String revIncStr = Reverse.reverse(String.valueOf(incLeftStr));

                    StringBuilder sb = new StringBuilder();
                    sb.append(incLeftStr);
                    sb.append(revIncStr);
                    System.out.println(sb.toString());
                }  else  {

                    String revStr = Reverse.reverse(leftStr);

                    StringBuilder sb = new StringBuilder();
                    sb.append(leftStr);
                    sb.append(revStr);
                    System.out.println(sb.toString());
                }
            }

            //support palindrome
            if(Integer.valueOf(leftStr) == Integer.valueOf(rightStr)) {
                int incStr = Integer.valueOf(s) + 1;
                String newIncStr = String.valueOf(incStr);

                int new_len = newIncStr.length();

                //odd case
                if(new_len % 2 != 0) {  //100

                    int new_mid = new_len/2;

                    leftStr = newIncStr.substring(0, new_mid);
                    rightStr = newIncStr.substring(new_mid+1, new_len);

                    if(Integer.valueOf(leftStr) > Integer.valueOf(rightStr)) {
                        //reverse leftStr & keep the mid
                        rightStr = leftStr;

                        StringBuilder sb = new StringBuilder();
                        sb.append(leftStr);
                        sb.append(newIncStr.charAt(new_mid));
                        sb.append(rightStr);
                        System.out.println(sb.toString());
                    }
                }

            }
        }
    }

}
