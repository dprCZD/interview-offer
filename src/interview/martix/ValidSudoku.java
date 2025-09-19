package interview.martix;
import java.util.*;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[][] sets = new Set[3][9];
        for(int i =0;i<3;i++)
        {
            for(int j =0;j<9;j++)
            {
                sets[i][j] = new HashSet<>();
            }
        }

        for(int i =0;i<9;i++)
        {
            for(int j =0;j<9;j++)
            {
                if(board[i][j] == '.')
                {
                    continue;
                }
                //Row
                if(!checkNumber(sets[0][i],board[i][j]))
                {
                    return false;
                }
                // column
                if(!checkNumber(sets[1][j],board[i][j]))
                {
                    return false;
                }
                // sub
                int subIndex = i/3*3+j/3;
               if(!checkNumber(sets[2][subIndex], board[i][j]))
               {
                   return false;
               }
            }
        }
        return true;

    }

    private boolean checkNumber(Set<Character> set, char number)
    {
        if(set.contains(number))
        {
            return false;
        }
        set.add(number);
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
       int [][] rows = new int[9][9];
       int [][] columns = new int[9][9];
       int [][][] subs = new int[3][3][9];
        for(int i =0;i<9;i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.')
                {
                    continue;
                }
                int cur = board[i][j] - '0' -1;
                if(rows[j][cur]>0 || columns[i][cur]>0 || subs[i/3][j/3][cur]>0)
                {
                    return false;
                }
                rows[j][cur]++;
                columns[i][cur]++;
                subs[i/3][j/3][cur]++;
            }
        }

        return true;

    }
}
