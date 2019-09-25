public class IsValidSudoku{
    public boolean isValidSudoku(char[][] board) {
        if(!rowValid(board)){
            return false;
        }
        if(!columnValid(board)){
            return false;
        }
        if(!squareValid(board)){
            return false;
        }
        return true;
    }

    private boolean rowValid(char[][] board){
        for(int i = 0; i<board.length; i++){
            boolean[] unique = new boolean[board.length];
            for(int j = 0; j<board.length; j++){
                int digit = board[i][j] - '0';
                if(unique[digit-1]){
                    return false;
                }
                unique[digit-1] = true;
            }
        }
        return true;
    }
    
    private boolean columnValid(char[][] board){
        for(int i = 0; i<board.length; i++){
            boolean[] unique = new boolean[board.length];
            for(int j = 0; j<board.length; j++){
                int digit = board[j][i] - '0';
                if(unique[digit-1]){
                    return false;
                }
                unique[digit-1] = true;
            }
        }
        return true;
    }

    private boolean squareValid(char[][] board){
        for(int i = 1; i<board.length; i+=3){
            for(int j = 1; j<board.length; j+=3){
                boolean[] unique = new boolean[board.length];
                for(int m = i-1; m<=i+1;m++){
                    for(int n = j-1; n<=j+1; n++){
                        int digit = board[m][n] - '0';
                        if(unique[digit-1]) {
                            return false;
                        }
                        unique[digit-1] = true;
                    }
                }
            }
        }
        return true;
    }
}
