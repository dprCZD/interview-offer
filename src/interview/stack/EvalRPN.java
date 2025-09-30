package interview.stack;


import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for(String token : tokens)
        {
            switch (token)
            {
                case "+":
                {
                    int o2 = stack.pop();
                    int o1 = stack.pop();
                    stack.push(o1+o2);
                    break;
                }
                case "-":
                {
                    int o2 = stack.pop();
                    int o1 = stack.pop();
                    stack.push(o1-o2);
                    break;
                }
                case "*":
                {
                    int o2 = stack.pop();
                    int o1 = stack.pop();
                    stack.push(o1*o2);
                    break;
                }
                case "/":
                {
                    int o2 = stack.pop();
                    int o1 = stack.pop();
                    stack.push(o1/o2);
                    break;
                }
                default:
                {
                    stack.push(Integer.parseInt(token));
                }
            }
        }
        return stack.peek();

    }
}
