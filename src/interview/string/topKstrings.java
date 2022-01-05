package interview.string;

import java.util.*;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/1/5 23:09
 */
public class topKstrings {
    public static void main(String[] args) {
        String[] strings={"123","123","231","32"};
        topKstrings(strings,2);
    }

    public static String[][] topKstrings(String[] strings, int k) {
        // write code here
        Map<String, Integer> stringMap = new HashMap<>();
        for (String str : strings) {
            if (stringMap.containsKey(str)) {
                stringMap.put(str, stringMap.get(str) + 1);
            } else {
                stringMap.put(str, 1);
            }
        }
        Queue<String[]> queue = new PriorityQueue<>(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int o1Num = Integer.valueOf(o1[1]);
                int o2Num = Integer.valueOf((o2[1]));
                if (o1Num < o2Num) {
                    return 1;
                } else if (o1Num > o2Num) {
                    return -1;
                } else {
                    return o1[0].compareTo(o2[0]);
                }
            }
        });
        for (Map.Entry<String, Integer> entry : stringMap.entrySet()) {
            String[] subRes = new String[2];
            subRes[0] = entry.getKey();
            subRes[1] = String.valueOf(entry.getValue());
            queue.add(subRes);
        }
        String[][] res = new String[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
