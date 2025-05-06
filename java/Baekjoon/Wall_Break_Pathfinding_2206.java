import java.util.*;
import java.io.*;

public class Wall_Break_Pathfinding_2206 {
    static int R, C;
    static int[][] board;
    static int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
    static int answer = Integer.MAX_VALUE;

    /*
        [error] cnt 로 방문체크하는 거 주의!
5 8
01000000
01010000
01010000
01010011
00010010
    */
    static class Point {
        int r, c, cnt, move;   ;
        public Point (int r, int c, int cnt, int move) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.move = move;
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];

        for (int r = 0; r < R; r ++) {
            String tmp = br.readLine();
            for (int c = 0; c < C; c ++)
                board[r][c] = tmp.charAt(c) - '0';
        }

        BFS();
        if (answer != Integer.MAX_VALUE)
            System.out.println(answer);
        else
            System.out.println(-1);
    }

    static void BFS() {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[R][C][2];   // 0 벽을 부순상태, 1 벽을 부수지 않은 상태
        queue.offer(new Point(0, 0, 0, 1));
        visited[0][0][0] = true;

        while (! queue.isEmpty()) {
            Point cur = queue.poll();
            int cr = cur.r, cc = cur.c, cnt = cur.cnt, move = cur.move;

            // stop point
            if (cr == R-1 && cc == C-1) {
                if (answer > move)
                    answer = move;
                continue;
            }

            for (int d = 0; d < 4; d ++) {
                int nr = cr + dr[d], nc = cc + dc[d];
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

                if (board[nr][nc] == 1) {   // 지나갈 수 없을 때 = 1

                    if (visited[nr][nc][1]) continue;
                    if (cnt == 0) {   // cnt = 0 -> 부수기
                        queue.offer(new Point(nr, nc, 1, move + 1));
                        visited[nr][nc][1] = true;
                    }
                }
                else { // 지나갈 수 있을 때 = 0

                    if (visited[nr][nc][cnt]) continue;
                    queue.offer(new Point(nr, nc, cnt, move + 1));
                    visited[nr][nc][cnt] = true;
                }
            }
        }
    }
}