import java.util.Scanner;
 
public class NQueens {
 
    static int[][] board;
    static int n;
 
    // Check whether a queen can be placed
    static boolean isSafe(int row, int col) {
 
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }
 
        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }
 
        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }
 
        return true;
    }
 
    // Backtracking function
    static boolean solveNQueens(int row) {
 
        // All queens are placed
        if (row == n)
            return true;
 
        // Try each column
        for (int col = 0; col < n; col++) {
 
            if (isSafe(row, col)) {
                board[row][col] = 1;
 
                if (solveNQueens(row + 1))
                    return true;
                // Backtrack
                board[row][col] = 0;
            }
        }
 
        return false;
    }
 
    // Display the chessboard
    static void displayBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        System.out.print("Enter value of N: ");
        n = sc.nextInt();
 
        board = new int[n][n];
 
        // Place the first Queen at row 0, column 0
        board[0][0] = 1;
 
        System.out.println("\nInitial Matrix:");
        displayBoard();
 
        // Start placing remaining queens from row 1
        if (solveNQueens(1)) {
            System.out.println("\nFinal N-Queens Matrix:");
            displayBoard();
        } else {
            System.out.println("\nNo solution exists with the first Queen at (1,1).");
        }
 
        sc.close();
    }
}