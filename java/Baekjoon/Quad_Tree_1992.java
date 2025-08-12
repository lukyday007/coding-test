package Baekjoon;

import java.io.*;
import java.util.*;

public class Quad_Tree_1992 {
    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i ++) {
            String line = br.readLine();
            for (int j = 0; j < N; j ++) {
                board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        String result = divideAndConquer(0, 0, N);
        bw.write(result);
        bw.flush();
        bw.close();
    }

    private static String divideAndConquer (int r, int c, int size) {
        if (checkSame(r, c, size))
            return String.valueOf(board[r][c]);

        int newSize = size / 2;

        String upLeft = divideAndConquer(r, c, newSize);
        String upRight = divideAndConquer(r, c + newSize, newSize);
        String downLeft = divideAndConquer(r + newSize, c, newSize);
        String downRight = divideAndConquer(r + newSize, c + newSize, newSize);

        return "(" + upLeft + upRight + downLeft + downRight + ")";
    }

    private static boolean checkSame (int r, int c, int size) {
        int first = board[r][c];
        for (int i = r; i < r + size; i ++)
            for (int j = c; j < c + size; j ++)
                if (board[i][j] != first)   return false;

        return true;
    }
}