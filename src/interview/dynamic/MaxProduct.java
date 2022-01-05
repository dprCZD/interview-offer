package interview.dynamic;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/5/13 9:37
 */
public class MaxProduct {

    public static Integer maxProduct(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int len = array.length;
        int[] max = new int[len];
        int[] min = new int[len];
        System.arraycopy(array, 0, max, 0, len);
        System.arraycopy(array, 0, min, 0, len);

        //核心动态转移方程
        for (int i = 1; i < len; i++) {
            max[i] = Math.max(max[i - 1] * array[i], Math.max(array[i],min[i - 1] * array[i]));
            min[i] = Math.min(min[i - 1] * array[i], Math.min(array[i],max[i - 1] * array[i]));
        }
        //选取最大值
        int res = max[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, max[i]);
        }
        return res;

    }


    /**
     * testCase:
     * {0}
     * {}
     * null
     * {2,3,4,-1,-1,-2}
     * {-2,-2,3,4,-1,-1,-2}
     * {Integer.MAX_VALUE,2,3}
     * @param args
     */
    public static void main(String[] args) {
        int[] array ={};
        System.out.println(maxProduct(array));
    }

}
