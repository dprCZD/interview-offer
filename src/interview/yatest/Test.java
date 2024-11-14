package interview.yatest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Test {
    public int getMinIntervalNum(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));

        int right = intervals[0][1];
        int maxExistIntervals = 1;
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] >= right) {
                ++maxExistIntervals;
                right = intervals[i][1];
            }
        }
        return intervals.length - maxExistIntervals;
    }

    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][]intervals = new int[n][2];
        for(int i =0;i<n;i++){
            String[] interval = sc.nextLine().split(" ");
            intervals[i][0]=Integer.parseInt(interval[0]);
            intervals[i][1]=Integer.parseInt(interval[1]);
        }
        Test test =new Test();
        System.out.println(test.getMinIntervalNum(intervals));
    }
}