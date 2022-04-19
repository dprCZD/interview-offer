package interview.math;

import java.util.Stack;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/1/6 22:58
 */
public class expression {
    public static void main(String[] args) {
        System.out.println(solve("((10+2)*10-(100-(10+20*10-(2*3)))*10*1*2)-2"));
    }

    private enum Operator {

        add('+', 1),
        subtract('-', 1),
        multiply('*', 2),
        divide('/', 2),
        pow('^', 3),
        ;

        private Character operator;

        private int pirority;

        public static int getPirority(Character operator) {
            for (Operator priority : Operator.values()) {
                if (priority.getOperator().equals(operator)) {
                    return priority.getPirority();
                }
            }
            return -1;
        }

        public static Operator of(Character operator) {
            for (Operator priority : Operator.values()) {
                if (priority.getOperator().equals(operator)) {
                    return priority;
                }
            }
            return null;
        }

        Operator(Character operator, int pirority) {
            this.operator = operator;
            this.pirority = pirority;
        }

        public Character getOperator() {
            return operator;
        }

        public void setOperator(Character operator) {
            this.operator = operator;
        }

        public int getPirority() {
            return pirority;
        }

        public void setPirority(int pirority) {
            this.pirority = pirority;
        }
    }

    public static int solve(String s) {
        // write code here
        s = s.replace(" ", "");

        char[] exp = s.toCharArray();
        int len = s.length();

        Stack<Long> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < len; i++) {
            char cur = exp[i];
            if (cur == '(') {
                ops.push(cur);
            } else if (cur == ')') {
                //>计算到最近的左括号
                while (!ops.isEmpty()) {
                    if (ops.peek() != '(') {
                        calculate(nums, ops);
                    } else {
                        ops.pop();
                        break;
                    }
                }
            } else {
                if (Character.isDigit(cur)) {
                    long num = 0;
                    while (i < len && Character.isDigit(exp[i])) {
                        num = num * 10 + (exp[i++] - '0');
                    }
                    nums.push(num);
                    i--;
                } else {
                    if (i > 0 && (exp[i - 1] == '(' || exp[i - 1] == '+' || exp[i - 1] == '-')) {
                        nums.push(0L);
                    }
                    while (!ops.isEmpty() && ops.peek() != '(') {
                        Character prevOpe = ops.peek();
                        if (Operator.getPirority(prevOpe) >= Operator.getPirority(cur)) {
                            calculate(nums, ops);
                        } else {
                            break;
                        }
                    }
                    ops.push(cur);
                }
            }
        }
        //> 收尾部分计算
        while (!ops.isEmpty() && ops.peek() != '(') {
            calculate(nums, ops);
        }
        long res = nums.peek();
        return (int) res;


    }

    private static void calculate(Stack<Long> nums, Stack<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) {
            return;
        }
        if (ops.isEmpty()) {
            return;
        }
        Long b = nums.pop();
        Long a = nums.pop();
        Operator operator = Operator.of(ops.pop());
        long ans = 0L;
        switch (operator) {
            case add: {
                ans = a + b;
                break;
            }
            case subtract: {
                ans = a - b;
                break;
            }
            case multiply: {
                ans = a * b;
                break;

            }
            case divide: {
                ans = a / b;
                break;

            }
            case pow: {
                ans = (long) Math.pow(a, b);
                break;

            }
        }
        nums.add(ans);


    }
}
