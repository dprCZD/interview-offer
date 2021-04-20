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
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char cur : chars) {
            if (!stack.isEmpty()) {
                Character peek = stack.peek();
                //运算符&&的优先级打大于||，不过为了清晰还是加了括号
                if ((peek == '{' && cur == '}') || (peek == '[' && cur == ']') || (peek == '(' && cur == ')')) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(cur);

        }
        return stack.isEmpty();

    }

}
