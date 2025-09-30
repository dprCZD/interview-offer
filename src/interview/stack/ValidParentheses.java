package interview.stack;

import java.util.Stack;

/**
 * @Author: czd
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if(s == null || s.length() ==0)
        {
            return true;
        }
        int n = s.length();

        Stack<Character> stack = new Stack<>();

        for(int i =0;i<n;i++)
        {
            char cur = s.charAt(i);
            // Left push
            if(cur == '{' || cur == '(' || cur == '[')
            {
                stack.push(cur);
            }
            else
            {
                if(stack.isEmpty())
                {
                    return false;
                }
                char top = stack.pop();
                if(cur == '}' && top != '{' || cur == ')' && top !='(' || cur == ']' && top != '[')
                {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

}
