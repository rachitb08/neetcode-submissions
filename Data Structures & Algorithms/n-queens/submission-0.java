class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solveNQueens(result, board, n, 0);
        return result;
    }

    public void solveNQueens(List<List<String>> result, char[][] board, int n, int row) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }
            result.add(solution);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, n, board)) {
                board[row][col] = 'Q';
                solveNQueens(result, board, n, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, int n, char[][] board) {
        /**
        Suppose hum board[row][col] par Queen place karna chahte hain.
        Since hum top to bottom move kar rahe hain, current row ke neeche abhi koi Queen nahi hai.
        Isliye humein sirf 3 directions check karni hain:
        
        Direction	            Check
        Same column	            Upar ki saari rows
        Upper-left diagonal	    row-1, col-1
        Upper-right diagonal	row-1, col+1        
         */

        // check upper columns
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // Upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}