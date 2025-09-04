class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                int boxIndex = (i / 3) * 3 + j / 3;

                if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) return false;
                rows[i][num] = cols[j][num] = boxes[boxIndex][num] = true;
            }
        }
        return true;
    }
}

/*
解題思路：
用三個布林表檢查數字是否重複：
1. rows[i][num] → 第 i 行是否已有 num。
2. cols[j][num] → 第 j 列是否已有 num。
3. boxes[boxIndex][num] → 對應 3x3 方格是否已有 num。
時間複雜度：O(1) (固定 9x9)，空間 O(1)。
*/
