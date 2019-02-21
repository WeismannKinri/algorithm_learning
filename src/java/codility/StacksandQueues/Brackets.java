package codility.StacksandQueues;

// you can also use imports, for example:
// import java.util.*;
import java.util.Stack;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public static int solution(String S){
        Stack<Character> stack = new Stack<Character>();
        if(null == S){
            return 0;
        }else if(S.isEmpty()){
            return 1;
        }
        for (Character C : S.toCharArray()) {

            switch (C) {
                case ')':
                    pops(stack, '(');
                    break;
                case '}':
                    pops(stack, '{');
                    break;
                case ']':
                    pops(stack, '[');
                    break;

                default:
                    stack.push(C);
                    break;
            }

        }
        return stack.isEmpty() ? 1 : 0;
    }

    private static void pops(Stack<Character> s, Character  C){

        while(!s.isEmpty() && s.peek() != C){
            s.pop();
        }
        if(!s.isEmpty()){
            s.pop();
        }else{
            s.push(C);
        }
    }
}