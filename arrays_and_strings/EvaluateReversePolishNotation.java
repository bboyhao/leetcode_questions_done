import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        int first;
        int second;
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            switch(token) {
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;
                case "-":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(second-first);
                    break;
                case "/":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(second/first);
                    break;
                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                default:
                    int num = Integer.parseInt(token);
                    stack.push(num);
            }
        }
        return stack.pop();
    }
}
