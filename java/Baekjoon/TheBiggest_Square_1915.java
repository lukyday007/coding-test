package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class TheBiggest_Square_1915 {
    static int N, M;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int r = 0; r < N; r ++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c ++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

    }
}
