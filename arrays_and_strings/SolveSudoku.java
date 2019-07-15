public class SolveSudoku{
    //DFS solution
    public void solveSudoku(char[][] board) {
        // use boolean array to store the status whether we reach the deepest point or not
        boolean[] full = {false}; 
        solveSudoku(board, 0, 0, full);
    }
    
    private void solveSudoku(char[][] board, int r, int c, boolean[] full) {
        // filling the whole box by filling the column one by one from left to right
        // r equals 9 means this column has been completed
        if (r == 9) {
            c++;
            r = 0;
        }
        // means we win
        if (c == 9) {
            full[0] = true;
            return;
        }
        
        //filling an empty cell
        if (board[r][c] == '.') {
            for (int i = 0;i < 9;i++) {
                if (isValidNumber(board, r, c, i + '1')) {
                    board[r][c] = (char)(i + '1');
                    solveSudoku(board, r + 1, c, full);
                    
                    // once we complete the puzzle we don't need to delete
                    // otherwise we delete the cells 
                    if (full[0] == false) {
                        board[r][c] = '.';
                    }
                }
            }
        } else {
            // already occupied keep moving
            solveSudoku(board, r + 1, c, full);
        } 
    }
    
 
    // to judge if the number to be filled is valid or not
    private boolean isValidNumber(char[][] board, int row, int column, int num) {
        char digit = (char) num;
        // column valid
        for (int i = 0;i < 9;i++) {
            if (board[i][column] == digit) {
                return false;
            }
        }
        // row valid
       for (int j = 0;j < 9;j++) {
            if (board[row][j] == digit) {
                return false;
            }
       }
      
        // sub-box valid
        int startR = (row / 3) * 3;
        int startC = (column / 3) * 3;
        for (int r = startR; r < startR + 3;r++){
            for (int c = startC; c < startC + 3;c++) {
                char curr = board[r][c];
                if (curr == digit) {
                    return false;
                } 
            }
        }
        return true;
    }
}

