package Baekjoon;

import java.io.*;
import java.util.*;

public class Making_Confetti_2630 {
    static int N;
    static int[][] board;
    static int white = 0, blue = 0;

    /*
        하나의 정사각형 칸이 되어 더 이상 자를 수 없을 때까지 => 분할 정복
    */

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

        divide_and_conquer(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void divide_and_conquer(int r, int c, int half) {
        if (isSameColor(r, c, half)) {
            if (board[r][c] == 0) white ++;
            else blue ++;
            return;
        }

        half /= 2;
        divide_and_conquer(r, c, half);
        divide_and_conquer(r, c + half, half);
        divide_and_conquer(r + half, c, half);
        divide_and_conquer(r + half, c + half, half);
    }

    private static boolean isSameColor(int r, int c, int half) {
        int color = board[r][c];

        for (int cr = r; cr < r + half; cr ++)
            for (int cc = c; cc < c + half; cc ++)
                if (board[cr][cc] != color) return false;

        return true;
    }
}
