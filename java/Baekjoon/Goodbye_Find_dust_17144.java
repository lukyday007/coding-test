package Baekjoon;

import java.util.*;
import java.io.*;

public class Goodbye_Find_dust_17144 {
    static int R, C, T;
    static int[][] board, copy;
    static int[] purifiers;
    static int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
    static List<List<Integer>> points = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        purifiers = new int[2];

        int idx = 0;
        for (int r = 0; r < R; r ++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
                if (board[r][c] == -1) purifiers[idx++] = r;
            }
        }

        List<int[]> up = fillPath(purifiers[0], true);
        List<int[]> down = fillPath(purifiers[1], false);

        while (T --> 0) {
            spread();
            moveAir(up);
            moveAir(down);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sumDust());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void spread() {
        copy = new int[R][C];   // 미세먼지 확산량 변화 체크
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] <= 0)   continue;
                int amount = board[r][c]/5;
                int cnt = 0;
                for (int d = 0; d < 4; d ++) {
                    int nr = r + dr[d], nc = c + dc[d];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C || board[nr][nc] == -1)  continue;
                    copy[nr][nc] += amount;
                    cnt ++;
                }
                board[r][c] -= (amount * cnt);
            }
        }
        for (int r = 0; r < R; r++)
            for (int c = 0; c < C; c++)
                board[r][c] += copy[r][c];
    }

    private static List<int[]> fillPath(int startR, boolean state) {
        List<int[]> path = new ArrayList<>();
        int r = startR, c = 1;
        path.add(new int[]{r, c});
        int[] drs = state ? new int[]{0, -1, 0, 1} : new int[]{0, 1, 0, -1};
        int[] dcs = new int[]{1, 0, -1, 0};
        int dir = 0;

        while (true) {
            int nr = r + drs[dir], nc = c + dcs[dir];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) {dir ++; continue;}
            if (nr == startR && nc == 0)    break;
            path.add(new int[]{nr, nc});
            r = nr; c = nc;
        }
        return path;
    }

    private static void moveAir(List<int[]> path) {
        // 뒤 -> 앞
        for (int i = path.size() - 1; i > 0; i --) {
            int[] cur = path.get(i);
            int[] prev = path.get(i - 1);
            board[cur[0]][cur[1]] = board[prev[0]][prev[1]];
        }
        int[] first = path.get(0);
        board[first[0]][first[1]] = 0;  // 공기청정기 옆 0
    }

    private static int sumDust() {
        int sum = 0;
        for (int r = 0; r < R; r++)
            for (int c = 0; c < C; c++)
                if (board[r][c] > 0) sum += board[r][c];
        return sum;
    }
}