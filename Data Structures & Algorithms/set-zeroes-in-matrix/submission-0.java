class Solution {
    public void setZeroes(int[][] matrix) {
        
        boolean firstRow = false;
        boolean firstCol = false;

        int n = matrix.length;
        int m = matrix[0].length;

        // set markers in first row and first col
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstRow = true;
                    }
                    if (j == 0) {
                        firstCol = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Process inner matrix
        for (int i=1;i<n;i++) {
            for (int j=1;j<m;j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // process first row
        if (firstRow) {
            for (int j=0;j<m;j++) {
                matrix[0][j] = 0;
            }
        }

        // process first column
        if (firstCol) {
            for (int i=0;i<n;i++) {
                matrix[i][0] = 0;
            }
        }
    }
}