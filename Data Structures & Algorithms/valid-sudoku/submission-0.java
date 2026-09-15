class Solution {
    public boolean isValidSudoku(char[][] board) {
        // validate rows
        for (int i=0;i<9;i++) {
            Set<Character> set = new HashSet<>();
            for (int j=0;j<9;j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }
        // validate columns
        for (int i=0;i<9;i++) {
            Set<Character> set = new HashSet<>();
            for (int j=0;j<9;j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) {
                        return false;
                    }
                    set.add(board[j][i]);
                }
            }
        }
        
        // validate boxes
        for (int sr=0;sr<9;sr+=3) {
            int er = sr + 2;
            for (int sc=0;sc<9;sc+=3) {
                int ec = sc + 2;
                if (!validBox(board, sr, er, sc, ec)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validBox(char[][] board, int sr, int er, int sc, int ec) {
        Set<Character> set = new HashSet<>();
        for (int i=sr;i<=er;i++) { 
            for (int j=sc;j<=ec;j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }
}