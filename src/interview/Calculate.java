package interview;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: czd
 * @Description: 1. 运算逻辑
 * 2. 优先级逻辑
 * 3. 中缀表达式转换->后缀表达式
 * 4. 后缀表达式解析运算
 *
 *  6.9+7.1
 *  "ss+aa+6+1"
 *
 *  "6+7"
 *  "(6+8)/4"
 *  "6*7/2"
 * @Date: 2021/5/14 13:25
 */
public class Calculate {


    private static int cal(int a, int b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                break;
        }
        throw new IllegalArgumentException("非法运算符!");
    }

    private static int getOperatorPriority(String operator) {
        if(operator == null){
            return 0;
        }
        switch (operator) {
            case "(":
                return 1;
            case "+":
            case "-":
                return 2;
            case "*":
            case "/":
                return 3;
            default:
                break;
        }
        throw new IllegalArgumentException("非法运算符!");

    }

    private static String convertSufExpr(String expr) {
        //后缀结果
        StringBuilder sufExpr = new StringBuilder();
        //运算符栈
        Stack<String> operatorStack = new Stack<>();
        //正则匹配数字/运算符
        Pattern p = Pattern.compile("");
        Matcher m = p.matcher(expr);
        while (m.find()) {
            String temp = m.group();
            if (temp.matches("[+\\-*/()]")) {
                if (temp.equals("(")) {
                    operatorStack.push(temp);
                } else if (temp.equals(")")) {
                    String top = null;
                    while (!(top = operatorStack.pop()).equals("(")) {
                        sufExpr.append(top + " ");
                    }
                } else {
                    while (getOperatorPriority(temp) <= getOperatorPriority(operatorStack.peek())) {
                        sufExpr.append(operatorStack.pop() + " ");
                    }
                    operatorStack.push(temp);

                }
            } else {
                sufExpr.append(temp + " ");
            }
        }
        String top = null;
        while((top = operatorStack.pop())!=null){
            sufExpr.append(top+" ");
        }
        System.out.println("后缀表达式：");
        return sufExpr.toString();

    }
}
