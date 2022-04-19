package interview.search;

/**
 * @Author: czd
 * @Description:
 * @Date: 2022/2/7 18:44
 */
public class NumOfIsland {


    public int solve (char[][] grid) {
        // write code here
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int num =0;
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    num++;
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid,int i,int j){
        //> 搜索结束条件
        if(i<0||i>=grid.length||j<0||j>=grid[i].length||grid[i][j]=='0'||grid[i][j]=='2'){
            return;
        }
        grid[i][j]='2';//>标记为已搜索
        dfs(grid,i-1,j);//向上搜索
        dfs(grid,i+1,j);//向下搜索
        dfs(grid,i,j-1);//向左搜索
        dfs(grid,i,j+1);//向右搜索
    }
}
