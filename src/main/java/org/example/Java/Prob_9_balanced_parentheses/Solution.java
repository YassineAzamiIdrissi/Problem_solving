package org.example.Java.Prob_9_balanced_parentheses;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static boolean isOpen(Character c) {
        return c == '(' || c == '{' || c == '[';
    }

    public static Character openOf(Character c) {
        if (c == ')') {
            return '(';
        } else if (c == '}') {
            return '{';
        } else if (c == ']') {
            return '[';
        } else {
            return ' ';
        }
    }

    public static boolean isWordBalanced(String word) {
        if (word.isEmpty()) {
            return true;
        }
        if (word.length() % 2 == 1) {
            return false;
        }
        if (!isOpen(word.charAt(0))) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            if (isOpen(word.charAt(i))) {
                stack.push(word.charAt(i));
            } else {
                try {
                    if (stack.get(stack.size() - 1) == openOf(word.charAt(i))) {
                        stack.pop();
                    }
                } catch (ArrayIndexOutOfBoundsException exp) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            if (input.isEmpty()) break;
            if (isWordBalanced(input)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }

    }
}
