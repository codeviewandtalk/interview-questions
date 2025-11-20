package dsa;

import java.util.Stack;

public class BalanceParenthesis {
    public static void main(String[] args) {
        // LEETCODE-20
        String str = "[{()}]";

        boolean result = balancedParenthesis(str);
        if (result) {
            System.out.println("It is a balance parenthesis");
        } else {
            System.out.println("It is not a balance parenthesis");
        }
    }

    public static boolean balancedParenthesis(String inputStr) {

        // create an empty stack
        Stack stack = new Stack();

        // convert inputStr to char array
        char[] charArray = inputStr.toCharArray();

        // iterate charArray
        for (int i = 0; i < charArray.length; i++) {

            // get char
            char current = charArray[i];

            //check whether current is '(', '[' or '{'
            if (current == '{' || current == '[' || current == '(') {
                // push current to stack
                stack.push(current);
            }
            // if stack is empty, return false
            if (stack.isEmpty()) {
                return false;
            }

            // use switch statement to pop element from stack and if it is '(', '[' or '{', return false
            char popChar;
            switch (current) {
                case ')':
                    popChar = (char) stack.pop();
                    if (popChar == '{' || popChar == '[')
                        return false;
                    break;
                case '}':
                    popChar = (char) stack.pop();
                    if (popChar == '(' || popChar == '[')
                        return false;
                    break;
                case ']':
                    popChar = (char) stack.pop();
                    if (popChar == '(' || popChar == '{')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }
}
