package interview.martix;

public class GameOfLife {
    public static void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] directs = {
                {-1, -1},
                {-1, 0},
                {-1, 1},
                {0, -1},
                {0, 1},
                {1, 1},
                {1, 0},
                {1, -1}
        };

        for(int i =0;i<n;i++)
        {
            for(int j =0;j<m;j++)
            {
                int aliveCount = 0;
                for(int[] direct:directs)
                {
                    int col = i+direct[0];
                    int row = j+direct[1];
                    if(col<n&&col>=0 && row<m&&row>=0 && (board[col][row] == 1||board[col][row] == 2))
                    {
                        aliveCount++;
                    }
                }
                if(aliveCount<2||aliveCount>3)
                {
                    if(board[i][j] == 1)
                    {
                        board[i][j] =2;
                    }
                }
                else if( aliveCount == 3)
                {
                    if(board[i][j] == 0)
                    {
                        board[i][j] =3;
                    }
                }
            }
        }

        for(int i =0;i<n;i++)
        {
            for(int j =0;j<m;j++) {
                if(board[i][j] == 2 ||board[i][j] == 3)
                {
                    board[i][j] -=2;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] b={
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        gameOfLife(b);
    }
}
