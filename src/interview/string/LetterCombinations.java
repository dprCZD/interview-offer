package interview.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: czd
 * @Description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @Date: 2022/5/2 22:18
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        dfs(digits, new StringBuilder(), 0, res);
        return res;

    }

    private void dfs(String digits, StringBuilder cur, int idx, List<String> res) {
        //> 递归出口
        if (idx >= digits.length()) {
            res.add(cur.toString());
            return;
        }
        //> 进行深搜
        char digit = digits.charAt(idx);
        String letters = Letter.of(digit - '0');
        for (char letter : letters.toCharArray()) {
            cur.append(letter);
            dfs(digits, cur, idx + 1, res);
            cur.deleteCharAt(cur.length() - 1);
        }

    }

    private enum Letter {
        TWO(2, "abc"),
        THREE(3, "def"),
        FOUR(4, "ghi"),
        FIVE(5, "jkl"),
        SIX(6, "mno"),
        SEVEN(7, "pqrs"),
        EIGHT(8, "tuv"),
        NINE(9, "wxyz"),
        ;
        private int number;

        private String letters;

        Letter(int number, String letters) {
            this.number = number;
            this.letters = letters;
        }

        public int getNumber() {
            return number;
        }

        public String getLetters() {
            return letters;
        }

        public static String of(int number) {
            for (Letter letter : Letter.values()) {
                if (letter.getNumber() == number) {
                    return letter.getLetters();
                }
            }
            return null;
        }
    }
}
