import java.io.*;
import java.util.*;

public class Mirror_Setting_2151_Dijkstra {
    static char[][] house;
    static int N, answer, sr, sc, er, ec;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static PriorityQueue<Node> pq;
    static int[][][] dist; // To store the minimum number of mirrors required to reach each cell in each direction

    static class Node implements Comparable<Node> {
        int r, c, dir, cnt;

        Node(int r, int c, int dir, int cnt) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node n) {
            return this.cnt - n.cnt;
        }
    }

    public static void dijkstra() {
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dist[i][j], 777);
            }
        }

        for (int i = 0; i < 4; i++) {
            pq.offer(new Node(sr, sc, i, 0));
            dist[sr][sc][i] = 0;
        }

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (curNode.r == er && curNode.c == ec) {
                answer = curNode.cnt;
                return;
            }

            // 노드가 소유한 거울 개수보다 dist 배열의 개수가 작으면 패스
            if (curNode.cnt > dist[curNode.r][curNode.c][curNode.dir]) continue;

            int nr = curNode.r + dr[curNode.dir];
            int nc = curNode.c + dc[curNode.dir];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N && house[nr][nc] != '*') {
                if (curNode.cnt < dist[nr][nc][curNode.dir]) {
                    dist[nr][nc][curNode.dir] = curNode.cnt;
                    pq.offer(new Node(nr, nc, curNode.dir, curNode.cnt));
                }
            }

            // 거울이 있을 경우 방향 바꾸기
            if (house[curNode.r][curNode.c] == '!') {
                for (int i = 1; i <= 3; i += 2) {
                    int newDir = (curNode.dir + i) % 4;
                    if (curNode.cnt + 1 < dist[curNode.r][curNode.c][newDir]) {
                        dist[curNode.r][curNode.c][newDir] = curNode.cnt + 1;
                        pq.offer(new Node(curNode.r, curNode.c, newDir, curNode.cnt + 1));
                    }
                }
            }

            for (int i = 0; i < N ; i ++) {
                for (int j = 0; j < N; j ++)
                    System.out.print(Arrays.toString(dist[i][j]) + " ");
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        house = new char[N][N];
        dist = new int[N][N][4];

        boolean isDoor = true;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                house[i][j] = str.charAt(j);

                if (house[i][j] == '#') {
                    if (isDoor) {
                        sr = i; sc = j;
                        isDoor = false;
                    } else {
                        er = i; ec = j;
                    }
                }
            }
        }

        dijkstra();
        System.out.println(answer);
    }
}