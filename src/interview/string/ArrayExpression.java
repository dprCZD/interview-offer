// 可以引⼊的库和版本相关请参考 “环境说明”
// Please refer to the "Environmental Notes" for the libraries and versions that can be introduced.

import java.util.*;

// "[0,1][1]" -> 1
// "[[1,2],3][1]" -> 3
// "[[1,2],[3,4]][1][0]" -> 3
// "[[1,2],3][0][1]" -> 2
// "[[1,2],[3,4],3][0][1]" -> 2
// "[[1,2,[5,6]],[3,4],3][0][2][1]" -> 6

public class ArrayExpression {

    // 使用python之外的语言真的很难写...需要额外考虑类型以及引用传递的场景。
    public static void main(String[] args) {
        System.out.println(parse("[0,1][1]"));
        System.out.println(parse("[[1,2],3][1]"));
        System.out.println(parse("[[1,2,[5,6]],[3,4],3][0][2][1]"));
        System.out.println(parse("[3,[1,24,[5,60]],[3,4],3][0][0][0][1,2][1]"));
        System.out.println(parse("[[[1,26],24,[5,60]],[3,4],3][0][0][0][1,2][1]"));
    }

    public static List<Integer> parse(String str){

        //Java 不能够递归传递int类型的引用，因此用数组来传引用。
        int[] offset = new int[1];
        offset[0] = 0;
        List<List<Object>>arraysOrIndexes = new ArrayList<>();
        while(offset[0] <= str.length()-1){
            offset[0]++;// 跳过第一个[
            arraysOrIndexes.add(parseList(str.toCharArray(),offset));
            offset[0]++;// 跳过]
        }

        //支持多个数组的匹配，按照最左优先的顺序匹配。
        boolean isArray = true;
        List<Object> array = null;
        List<Integer> results = new ArrayList<>();
        for(int i=0; i<arraysOrIndexes.size();++i){
            if(isArray){
                array = arraysOrIndexes.get(i);
                isArray= false;
            }else{
                List<Object> currentLevel = array;
                Object item = currentLevel.get((Integer)arraysOrIndexes.get(i).get(0));
                while(item instanceof List){
                    i++;
                    currentLevel = (List<Object>) item;
                    item = currentLevel.get((Integer)arraysOrIndexes.get(i).get(0));
                }
                results.add((Integer) item);
                isArray = true;
            }
        }
        return results;

    }
    // 匹配列表数据，采用全局offset和递归来进行多重匹配。
    private static List<Object> parseList(char[] str, int[] offset){
        // 切分list
        // [[1, 2], [3, 4]
        List<Object> list = new ArrayList<>();
        for(;offset[0]<str.length;++offset[0]){
            if(str[offset[0]] == '['){
                offset[0]++;
                list.add(parseList(str,offset));
            }
            else if(str[offset[0]]==']'){
                return list;
            }
            else if(str[offset[0]]!=','){
                String numStr = "";
                while(str[offset[0]] != ',' && str[offset[0]] != ']'){
                    numStr +=str[offset[0]];
                    offset[0]++;
                }
                list.add(Integer.valueOf(numStr));
                if(str[offset[0]] == ']'){
                    return list;
                }
            }
        }
        return list;
    }
}
