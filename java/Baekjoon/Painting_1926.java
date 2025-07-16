package Baekjoon;

import java.util.*;
import java.io.*;

public class Painting_1926 {
    static boolean[][] visited;
    static int[][] board;
    static int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
    static int R, C;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j ++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < R; i ++) {
            for (int j = 0; j < C; j ++) {
                if (board[i][j] == 0)   continue;
                if (visited[i][j])  continue;
                visited[i][j] = true;
                cnt ++;
                maxVal = Math.max(maxVal, bfs(i, j));

            }
        }

        // 그림이 하나도 없는 경우에는 가장 넓은 그림의 넓이는 0
        if (cnt == 0)
            maxVal = 0;

        System.out.println(cnt);
        System.out.println(maxVal);
    }

    private static int bfs(int r, int c) {
        int result = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});

        while (! queue.isEmpty()) {
            int[] pos = queue.poll();
            int cr = pos[0], cc = pos[1];

            for (int d = 0; d < 4; d ++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C || board[nr][nc] == 0 || visited[nr][nc])    continue;
                visited[nr][nc] = true;
                result ++;
                queue.offer(new int[]{nr, nc});
            }
        }
        return result;
    }
}
