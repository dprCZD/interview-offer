package interview.martix;

import java.util.*;
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix)
    {
        int columnStart = 0;
        int columnEnd = matrix.length;
        int rowStart = 0;
        int rowEnd = matrix[0].length;

        int i= columnStart;
        int j = rowStart;
        int status = 0;
        List<Integer> result = new ArrayList<>();
        while(j>=rowStart&& j<rowEnd &&i>=columnStart &&i<columnEnd)
        {
            switch (status){
                case 0:
                    while(j<rowEnd)
                    {
                        result.add(matrix[i][j]);
                        j++;
                    }
                    j--;
                    columnStart++;
                    i++;
                    status = 1;
                    break;
                case 1:
                    while(i<columnEnd)
                    {
                        result.add(matrix[i][j]);
                        i++;
                    }
                    i--;
                    j--;
                    rowEnd--;
                    status = 2;
                    break;
                case 2:
                    while(j>=rowStart)
                    {
                        result.add(matrix[i][j]);
                        j--;
                    }
                    j++;
                    i--;
                    columnEnd--;
                    status = 3;
                    break;
                case 3:
                    while(i>=columnStart)
                    {
                        result.add(matrix[i][j]);
                        i--;
                    }
                    i++;
                    j++;
                    rowStart++;
                    status=0;
                    break;
            }
        }
        return result;
    }
}
