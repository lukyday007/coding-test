package Programmers;
import java.util.*;

public class Lv2_Game_Map_ShortestPath {

    class Solution {
        static int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};

        static class Point {
            int r, c, dist;

            Point(int r, int c, int dist) {
                this.r = r;
                this.c = c;
                this.dist = dist;
            }
        }

        public int solution(int[][] maps) {
            int answer = bfs(maps);
            return (answer == Integer.MAX_VALUE) ? -1 : answer;
        }

        private static int bfs(int[][] maps) {

            int result = Integer.MAX_VALUE;
            int R = maps.length, C = maps[0].length;
            boolean[][] visited = new boolean[R][C];
            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(0, 0, 1));
            visited[0][0] = true;

            while (!queue.isEmpty()) {
                Point p = queue.poll();
                int cr = p.r, cc = p.c, cd = p.dist;

                if (cr == R - 1 && cc == C - 1)     return cd;

                for (int i = 0; i < 4; i++) {
                    int nr = cr + dr[i], nc = cc + dc[i];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C || maps[nr][nc] == 0 || visited[nr][nc])     continue;

                    visited[nr][nc] = true;
                    queue.offer(new Point(nr, nc, cd + 1));
                }
            }

            return result;
        }
    }
}