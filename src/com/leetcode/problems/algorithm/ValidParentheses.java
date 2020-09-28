package com.leetcode.problems.algorithm;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();

        String s = "()";

        s = "(){}}{";

        boolean valid = vp.isValid(s);

        System.out.println(valid);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                if (c == '(') {
                    stack.push(')');
                } else if (c == '{') {
                    stack.push('}');
                } else if (c == '[') {
                    stack.push(']');
                }
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.empty() || c != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
