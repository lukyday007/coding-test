package Baekjoon;

import java.io.*;
import java.util.*;

public class Printing_Starts10_2447 {
    static int N;
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(board[i], ' ');

        recursion(0, 0, N);
        StringBuilder sb = printBoard();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void recursion(int r, int c, int size) {
        if (size == 3) {
            board[r][c] = '*';
            board[r][c + 1] = '*';
            board[r][c + 2] = '*';
            board[r + 1][c + 2] = '*';
            board[r + 1][c] = '*';
            board[r + 2][c] = '*';
            board[r + 2][c + 1] = '*';
            board[r + 2][c + 2] = '*';
        } else {
            int newSize = size/3;

            recursion(r, c, newSize);
            recursion(r, c + newSize, newSize);
            recursion(r, c + newSize * 2, newSize);
            recursion(r + newSize, c + newSize * 2, newSize);
            recursion(r + newSize, c, newSize);
            recursion(r + newSize * 2, c, newSize);
            recursion(r + newSize * 2, c + newSize, newSize);
            recursion(r + newSize * 2, c + newSize * 2, newSize);
        }
    }

    private static StringBuilder printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < N; r ++) {
            for (int c = 0; c < N; c ++) {
                sb.append(board[r][c]);
            }
            sb.append("\n");
        }
        return sb;
    }
}