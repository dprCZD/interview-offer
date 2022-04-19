package interview.string;

import java.util.ArrayList;

/**
 * @Author: czd
 * @Description:给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
 * 例如，给出n=3，解集为：
 * "((()))", "(()())", "(())()", "()()()", "()(())"
 * @Date: 2022/2/19 16:05
 */
public class GenerateParenthesis {

    public ArrayList<String> generateParenthesis (int n) {
        // write code here
        ArrayList<String> res =new ArrayList<>();
        generateParenthesis(n,n,"",res);
        return res;
    }

    private void generateParenthesis(int left,int right,String cur ,ArrayList<String> res){
        if(left==0&&right==0){
            res.add(cur);
            return;
        }
        //> 如果左括号数量大于右括号，则可以选择追加左括号
        if(right>0&&left<right){
            generateParenthesis(left,right-1,cur+")",res);
        }
        //> 这里要判断左侧括号还有剩余。
        if(left>0){
            generateParenthesis(left-1,right,cur+"(",res);
        }

    }

    public static void main(String[] args) {
        ArrayList<String> strings = new GenerateParenthesis().generateParenthesis(1);
    }



}
