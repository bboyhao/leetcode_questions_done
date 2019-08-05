import java.util.Arrays;

public class RotateImage{
    public void rotate(int[][] matrix) {
        if (matrix == null){
            return;
        }
        int stop = matrix.length / 2;
        int n = matrix.length;
        for(int i = 0; i<stop; i+=1){
            for (int j = i; j<n-1-i; j+=1){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }
    }
}
