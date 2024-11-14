package interview.yatest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Test3 {

    int maxStars = 1;
    int maxTimes = 1;

    void maxStars(int n,int[][]stars){

        for (int i = 0; i < n; i++) {
            int tempMax = 0;
            for (int j = i + 1; j < n; j++) {
                if (overlap(stars,i,j)) {
                    tempMax++;
                }
            }
            if(tempMax == maxStars){
                maxTimes++;
            }else if(tempMax>maxStars){
                maxStars = tempMax;
                maxTimes = 1;
            }
        }
    }
    boolean overlap(int[][]stars,int i,int j){
        return ((stars[i][0] >= stars[j][0] && stars[i][0] < stars[j][1])
                || (stars[j][0] >= stars[i][0] && stars[j][0] < stars[i][1]));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        line = scanner.nextLine();
        String[] s = line.split(" ");
        line = scanner.nextLine();
        String[] t = line.split(" ");
        int[][] stars = new int[n][2];
        for(int i =0;i<n;i++){
            stars[i][0] = Integer.parseInt(s[i]);
            stars[i][1] = Integer.parseInt(t[i]);
        }
        Test3 test = new Test3();
        test.maxStars(n,stars);
        System.out.println(test.maxStars+" "+test.maxTimes);
    }
}
