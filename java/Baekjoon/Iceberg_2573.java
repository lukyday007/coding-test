import java.util.*;
import java.io.*;

public class Iceberg_2573 {
    static int R, C;
    static int[][] iceberg;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int countIceberg() {
        boolean[][] visited = new boolean[R][C];
        int count = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (iceberg[r][c] > 0 && !visited[r][c]) {
                    bfsCount(r, c, visited);
                    count++;
                    if (count >= 2) return count;
                }
            }
        }
        return count;
    }

    private static void bfsCount(int r, int c, boolean[][] visited) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r, c));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = point.r + dr[d];
                int nc = point.c + dc[d];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && iceberg[nr][nc] > 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new Point(nr, nc));
                }
            }
        }
    }

    public static int meltIceberg() {
        Queue<Point> queue = new LinkedList<>();
        int[][] meltAmount = new int[R][C];

        // 먼저 각각의 빙하에 닿은 바다의 면수를 카운트
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (iceberg[r][c] > 0) {
                    queue.offer(new Point(r, c));
                    int melt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (nr >= 0 && nr < R && nc >= 0 && nc < C && iceberg[nr][nc] == 0)
                            melt++;
                    }
                    meltAmount[r][c] = melt;
                }
            }
        }

        if (queue.isEmpty()) return 0;  // 얼음이 다 녹으면 리턴

        // 녹는 과정 반영
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            iceberg[p.r][p.c] = Math.max(0, iceberg[p.r][p.c] - meltAmount[p.r][p.c]);
        }
        return 1;
    }

    public static int bfs() {
        int years = 0;

        while (true) {
            int count = countIceberg();     // 덩어리 카운트
            if (count >= 2) return years;   // 2 덩어리 이상이면 햇수 리턴
            if (meltIceberg() == 0) return 0;   // 빙하 녹음
            years++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        iceberg = new int[R][C];
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                iceberg[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }
}