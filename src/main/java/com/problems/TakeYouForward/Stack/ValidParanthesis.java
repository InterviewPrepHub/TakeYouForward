package com.problems.TakeYouForward.Stack;

import java.util.Stack;

public class ValidParanthesis {

    public static void main(String[] args) {
        String str = "[]";

        System.out.println(isValid(str));
    }

    private static boolean isValid(String str) {

        Stack<Character> st = new Stack<>();

        for (char ch : str.toCharArray()) {
            if(ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false;
                } else {
                    char top = st.pop();
                    if((top == '(' && ch != ')') || (top == '{' && ch != '}') || (top == '[' && ch != ']')) {
                        return false;
                    }
                }
            }
        }
        return st.isEmpty();
    }


}
