package Baekjoon;

import java.io.*;
import java.util.*;

public class Making_Confetti_2630 {
    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j ++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }


    }
}
