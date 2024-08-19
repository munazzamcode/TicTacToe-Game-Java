import java.util.Arrays;
import java.util.Scanner;

class PrintBoard {
    // Initializing and printing the board
    char[][] board = new char[3][3];
    char currentPlayer = 'X';
    boolean checkHorizontalMove = false;
    boolean checkVerticalMove = false;
    boolean checkDiagonalMove = false;
    boolean checkValidity = false;
    boolean checkFillBoard = false;

    public PrintBoard() {
        initializeBoard();
        printBoard();
    }

    public void initializeBoard() {
        for (char[] chars : board) {
            Arrays.fill(chars, '-');
        }
    }

    public void printBoard() {
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    // Switching player on board
    public void switchingPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Checking rows and cols strength and their value
    public void isCheckValidity(int row, int col) {
        checkValidity = false; // Resetting the validity flag at the start
        row -= 1; // Adjusting for 1-based indexing
        col -= 1; // Adjusting for 1-based indexing

        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
            board[row][col] = currentPlayer;
            checkValidity = true;
        } else {
            System.out.println("Invalid move, try again.");
        }
    }

    // Check If board is already filled
    public void isCheckFillBoard() {
        checkFillBoard = true; // Assume the board is filled
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == '-') {
                    checkFillBoard = false; // If we find an empty cell, the board isn't filled
                    return;
                }
            }
        }
    }

    public void isCheckHorizontalMove(int row) {
        row -= 1; // Adjusting for 1-based indexing
        checkHorizontalMove = board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer;
    }

    public void isCheckVerticalMove(int col) {
        col -= 1; // Adjusting for 1-based indexing
        checkVerticalMove = board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer;
    }

    public void isCheckDiagonalMove() {
        checkDiagonalMove = (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }
}

public class TicTacToe {
    public static void main(String[] args) {
        PrintBoard pb = new PrintBoard();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your move. Note: Enter row and column as numbers 1, 2, or 3.");
            int row = sc.nextInt();
            int col = sc.nextInt();

            pb.isCheckValidity(row, col);
            if (pb.checkValidity) {
                pb.printBoard();
                pb.isCheckHorizontalMove(row);
                pb.isCheckVerticalMove(col);
                pb.isCheckDiagonalMove();

                if (pb.checkHorizontalMove || pb.checkVerticalMove || pb.checkDiagonalMove) {
                    System.out.println("The player " + pb.currentPlayer + " wins!");
                    break;
                }

                pb.isCheckFillBoard();
                if (pb.checkFillBoard) {
                    System.out.println("The game is a draw!");
                    break;
                } else {
                    pb.switchingPlayer();
                }
            }
        }

        sc.close();
    }
}
