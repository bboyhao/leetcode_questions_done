public class NumberOfIslands{
    public int numIslands(char[][] grid){
        if(grid == null || grid.length==0)return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col;j++){
                if(!visited[i][j]&&grid[i][j] == '1'){
                    dfs(i, j, grid, visited);
                    result += 1;
                }
            }
        }
        return result;
    }

    private boolean isValid(int a, int b, int row, int col){
        if(a<0 || a>=row || b<0 || b>=col){
            return false;
        }
        return true;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] visited){
        visited[i][j] = true;
        if(grid[i][j] == '0') return;
        for(int m = -1; m<=1;m+=2){
            if(isValid(i+m, j, grid.length, grid[0].length) && !visited[i+m][j]) {
                dfs(i+m, j, grid, visited);
            }
            if(isValid(i, j+m, grid.length, grid[0].length) && !visited[i][j+m]) {
                dfs(i, j+m, grid, visited);
            }
        }
    }
}
