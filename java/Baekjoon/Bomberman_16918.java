package Baekjoon;

import java.util.*;
import java.io.*;

public class Bomberman_16918 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] board = new char[R][C];


        for (int r = 0; r < R; r ++) {
            String line = br.readLine();
            for (int c = 0; c < C; c ++) {
                board[r][c] = line.charAt(c);
            }
        }

        boolean[][] isExploded = new boolean[R][C];
        int[][] timeCheck = new int[R][C];
        for (int t = 1; t <= N; t ++) {
            if (t % 2 == 0) {
                for (int r = 0; r < R; r ++) {
                    for (int c = 0; c < C; c ++) {
                        if (board[r][c] == '.') {
                            board[r][c] = 'O';
                            timeCheck[r][c] = t;
                        }
                    }
                }
            } else if (t >= 3) {
                // 3초에 폭발할 위치 마킹
                for (int r = 0; r < R; r ++) {
                    for (int c = 0; c < C; c++) {
                        if (board[r][c] == 'O' && t - timeCheck[r][c] == 3) {
                            isExploded[r][c] = true;
                            for (int d = 0; d < 4; d++) {
                                int nr = r + dr[d];
                                int nc = c + dc[d];
                                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                                    isExploded[nr][nc] = true;
                                }
                            }
                        }
                    }
                }
                // 폭탄 일괄 처리
                for (int r = 0; r < R; r ++) {
                    for (int c = 0; c < C; c ++) {
                        if (isExploded[r][c]) {
                            board[r][c] = '.';
                            timeCheck[r][c] = 0;
                            isExploded[r][c] = false;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                sb.append(board[r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}