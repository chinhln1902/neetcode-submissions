class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isSubBoxValid(board) && isRowValid(board) && isColumnValid(board);
    }

    private boolean isSubBoxValid(char[][] board) {
        for (int row = 0; row < board.length; row = row + 3) {
            for (int col = 0; col < board[row].length; col = col + 3) {
                HashSet<Character> nums = new HashSet<>();
                for (int subBoxRow = 0; subBoxRow < 3; subBoxRow++) {
                    for (int subBoxCol = 0; subBoxCol < 3; subBoxCol++) {
                        if (board[row + subBoxRow][col + subBoxCol] != '.') {
                            if (nums.contains(board[row + subBoxRow][col + subBoxCol])) {
                                return false;
                            }
                            nums.add(board[row + subBoxRow][col + subBoxCol]);
                        }
                    }
                }
            }
        }
        return true;
    }
    
    private boolean isRowValid(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            HashSet<Character> nums = new HashSet<>();
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] != '.') {
                    if (nums.contains(board[row][col])) {
                        return false;
                    }
                    nums.add(board[row][col]);
                }
            }
        }
        return true;
    }

    private boolean isColumnValid(char[][] board) {
        for (int col = 0; col < board[0].length; col++) {
            HashSet<Character> nums = new HashSet<>();
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] != '.') {
                    if (nums.contains(board[row][col])) {
                        return false;
                    }
                    nums.add(board[row][col]);
                }
            }
        }
        return true;
    }
}
