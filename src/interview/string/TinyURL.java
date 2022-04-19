package interview.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/3/28 21:59
 */
public class TinyURL {

    private static final int DECIMAL = 62;

    private static final char[] array = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd',
            'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm',
            'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D',
            'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};

    private static Map<Character, Integer> charMap = new HashMap<Character, Integer>();

    //初始化map
    static {
        for (int i = 0; i < array.length; i++) charMap.put(array[i], i);
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            long number = Long.MAX_VALUE - i;
            String tinyURL = encodeTinyURL(number);
            System.out.println(number + " 转换成 " + tinyURL);
            long toNumber = decodeTinyURL(tinyURL);
            System.out.println(tinyURL + " 转换成 " + toNumber);
        }
    }


    /**
     * 把数字转换成相对应的进制,目前支持(2-62)进制
     *
     * @param number
     * @return
     */
    public static String encodeTinyURL(long number) {
        StringBuilder builder = new StringBuilder();
        while (number != 0) {
            builder.append(array[(int) (number % DECIMAL)]);
            number /= DECIMAL;
        }
        return builder.reverse().toString();
    }

    /**
     * 把进制字符串转换成相应的数字
     *
     * @param tinyURL
     * @return
     */
    public static long decodeTinyURL(String tinyURL) {
        long sum = 0;
        long multiple = 1;
        char[] chars = tinyURL.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            sum += charMap.get(c) * multiple;
            multiple *= DECIMAL;
        }
        return sum;
    }


}