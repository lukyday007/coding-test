import java.util.*;
import java.io.*;

public class Printing_Stars11_2448 {
    static int N;
    static char[][] board;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++)
            Arrays.fill(board[i], ' ');

        recursion(0, (2 * N - 1)/2, N);
        printBoard();
    }
    static void recursion (int r, int c, int size) {
        if (size == 3) {
            board[r][c] = '*';
            board[r + 1][c + 1] = '*';
            board[r + 1][c - 1] = '*';
            for (int i = -2; i <= 2; i ++)
                board[r + 2][c + i] = '*';
        } else {
            int half = size / 2;
            recursion(r, c, half);
            recursion(r + half, c + half, half);
            recursion(r + half, c - half, half);
        }

    }
    static void printBoard () {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j ++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}