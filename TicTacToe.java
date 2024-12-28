import java.util.*;

public class TicTacToe {
    static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Choose mode: 1. Player vs Player 2. Player vs Computer");
        int mode = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        playGame(mode);
    }

    static void playGame(int mode) {
        char currentPlayer = 'X';
        while (true) {
            printBoard();
            if (mode == 2 && currentPlayer == 'O') {
                computerMove();
            } else {
                playerMove(currentPlayer);
            }
            if (checkWinner(currentPlayer)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            if (isDraw()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    static void printBoard() {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row).replaceAll(",", "|"));
        }
        System.out.println();
    }

    static void playerMove(char player) {
        System.out.println("Player " + player + "'s turn. Enter row and column (1-3):");
        int row, col;
        while (true) {
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            if (isValidMove(row, col)) break;
            System.out.println("Invalid move. Try again.");
        }
        board[row][col] = player;
    }

    static void computerMove() {
        System.out.println("Computer's turn:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = 'O';
                    if (checkWinner('O')) return;
                    board[i][j] = 'X';
                    if (checkWinner('X')) {
                        board[i][j] = 'O';
                        return;
                    }
                    board[i][j] = ' ';
                }
            }
        }
        Random rand = new Random();
        int row, col;
        do {
            row = rand.nextInt(3);
            col = rand.nextInt(3);
        } while (!isValidMove(row, col));
        board[row][col] = 'O';
    }

    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    static boolean checkWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    static boolean isDraw() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') return false;
            }
        }
        return true;
    }
}
