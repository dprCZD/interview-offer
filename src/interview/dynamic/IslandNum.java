package interview.dynamic;

/**
 * @Author: czd
 * @Description:
 * @Date: 2021/4/11 21:01
 */
public class IslandNum {
    /**
     * 深度优先搜索
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    subNumIslands(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void subNumIslands(char[][] grid, int i, int j) {
            if (i >= grid.length || i < 0 || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
                return;
            }
        grid[i][j] = '0';
        subNumIslands(grid, i + 1, j);
        subNumIslands(grid, i - 1, j);
        subNumIslands(grid, i, j + 1);
        subNumIslands(grid, i, j - 1);
    }
}


