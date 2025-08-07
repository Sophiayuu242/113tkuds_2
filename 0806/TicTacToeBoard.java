import java.util.Scanner;

public class TicTacToeBoard {
    static final char EMPTY = '.';
    static final char PLAYER_X = 'X';
    static final char PLAYER_O = 'O';
    static char[][] board = new char[3][3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBoard();
        char currentPlayer = PLAYER_X;

        while (true) {
            printBoard();
            System.out.println("玩家 " + currentPlayer + " 請輸入行與列 (0~2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!isValidMove(row, col)) {
                System.out.println("無效的落子，請重試。");
                continue;
            }

            board[row][col] = currentPlayer;

            if (checkWin(currentPlayer)) {
                printBoard();
                System.out.println("玩家 " + currentPlayer + " 獲勝！");
                break;
            }

            if (isDraw()) {
                printBoard();
                System.out.println("遊戲平手！");
                break;
            }

            currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
        }

        scanner.close();
    }

    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public static void printBoard() {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == EMPTY;
    }

    public static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }

    public static boolean isDraw() {
        for (char[] row : board) {
            for (char c : row) {
                if (c == EMPTY) return false;
            }
        }
        return true;
    }
}
