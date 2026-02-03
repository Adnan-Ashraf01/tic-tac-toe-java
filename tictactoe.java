import java.util.Scanner;

public class TicTacToe {

    static char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {
            printBoard();
            System.out.print("Player " + currentPlayer + ", enter position (1-9): ");
            int pos = sc.nextInt();

            if (pos < 1 || pos > 9) {
                System.out.println("Invalid position! Choose 1 to 9.");
                continue;
            }

            if (board[pos - 1] == ' ') {
                board[pos - 1] = currentPlayer;

                if (checkWin()) {
                    printBoard();
                    System.out.println("🎉 Player " + currentPlayer + " wins!");
                    gameOver = true;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("Game Draw!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Position already taken. Try again.");
            }
        }
        sc.close();
    }

    static void printBoard() {
        System.out.println();
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    static boolean checkWin() {
        int[][] winPositions = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
        };

        for (int[] wp : winPositions) {
            if (board[wp[0]] == currentPlayer &&
                board[wp[1]] == currentPlayer &&
                board[wp[2]] == currentPlayer)
                return true;
        }
        return false;
    }

    static boolean isBoardFull() {
        for (char c : board)
            if (c == ' ')
                return false;
        return true;
    }
}
