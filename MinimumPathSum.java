import java.util.*;

public class MinimumPathSum{
    //Implement Dijkstra's algorithm to solve the problem, but a bit slow
    private class Node{
        int row;
        int col;
        int cost;
        boolean visited;
        Node(int row, int col, int cost, boolean visited){
            this.row = row;
            this.col = col;
            this.cost = cost;
            this.visited = visited;
        }
    }

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length; 
        Node[][] nodeMatrix = new Node[row][col];
        for(int i = 0;i <row; i+=1){
            for(int j = 0; j<col;j+=1){
                nodeMatrix[i][j] = new Node(i, j, Integer.MAX_VALUE, false);
            }
        }
        Comparator<Node> nodeComparator = (n1, n2) -> {
            return n1.cost - n2.cost;
        };
        PriorityQueue<Node> q = new PriorityQueue<>(nodeComparator);
        nodeMatrix[0][0].cost = grid[0][0];
        q.add(nodeMatrix[0][0]);
        while(!q.isEmpty()){
            Node curMin = q.poll();
            curMin.visited = true;
            int curRow = curMin.row;
            int curCol = curMin.col;
            if(curRow == row-1 && curCol == col -1){
                break;
            }
            if(curRow + 1< row && !nodeMatrix[curRow+1][curCol].visited){
                if(nodeMatrix[curRow+1][curCol].cost > 
                        curMin.cost + grid[curRow+1][curCol]){
                    nodeMatrix[curRow+1][curCol].cost = curMin.cost + grid[curRow+1][curCol];
                }
                if(q.contains(nodeMatrix[curRow+1][curCol])){
                    q.remove(nodeMatrix[curRow+1][curCol]);
                }
                q.add(nodeMatrix[curRow+1][curCol]);
            }
            if(curCol + 1< col && !nodeMatrix[curRow][curCol+1].visited){
                if(nodeMatrix[curRow][curCol+1].cost > 
                        curMin.cost + grid[curRow][curCol+1]){
                    nodeMatrix[curRow][curCol+1].cost = curMin.cost + grid[curRow][curCol+1];
                }
                if(q.contains(nodeMatrix[curRow][curCol+1])){
                    q.remove(nodeMatrix[curRow][curCol+1]);
                }
                q.add(nodeMatrix[curRow][curCol+1]);
            }
        }
        return nodeMatrix[row-1][col-1].cost;
    }
}

class MinimumPathSum2{
    public static int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        return min(grid, height - 1, width - 1);
    }
        
    public static int min(int[][]grid, int row, int col){
        if(row == 0 && col == 0) return grid[row][col]; // this is the exit of the recursion
        if(row == 0) return grid[row][col] + min(grid, row, col - 1); /** when we reach the first row, we could only move horizontally.*/
        if(col == 0) return grid[row][col] + min(grid, row - 1, col); /** when we reach the first column, we could only move vertically.*/
        return grid[row][col] + Math.min(min(grid, row - 1, col), min(grid, row, col - 1)); /** we want the min sum path so we pick the cell with the less value */
    }

    public static int minPathSum2(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if(row == 0 && col == 0) grid[row][col] = grid[row][col];
                else if(row == 0 && col != 0) grid[row][col] = grid[row][col] + grid[row][col - 1];
                else if(col == 0 && row != 0) grid[row][col] = grid[row][col] + grid[row - 1][col];
                else grid[row][col] = grid[row][col] + Math.min(grid[row - 1][col], grid[row][col - 1]);
            }
        }
        return grid[height - 1][width - 1];
    }
}
