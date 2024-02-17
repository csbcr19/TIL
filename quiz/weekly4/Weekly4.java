package _0216.stack;

import java.util.Stack;
public class Weekly4 {
    public static void main(String[] args) {
        Weekly4 w = new Weekly4();
        String s = "(()()))(";
        System.out.println(w.solution(s));
    }
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        try{
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push('(');
                } else {
                    stack.pop();
                }
            }
            return stack.empty();
        } catch (Exception e) {
            return false;
        }
    }
}
