import java.io.*;
import java.util.*;

public class Mirror_Setting_2151 {
    static char[][] house;
    static int N, answer, sr, sc, er, ec;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static PriorityQueue<Node> pq;
    static boolean[][][] visited;

    /*
        한 쪽 문에서 다른 쪽 문을 볼 수 있도록 하기 위해 설치해야 하는 거울의 최소 개수

        거울을 설치할 때에는 45도 기울어진 대각선 방향으로 설치해야 한다. 또한 모든 거울은 양면 거울이기 때문에 양 쪽 모두에서 반사가 일어날 수 있다. 채영이는 거울을 매우 많이 가지고 있어서 거울이 부족한 경우는 없다고 하자.
        ‘#’는 문이 설치된 곳으로 항상 두 곳이며,
        ‘.’은 아무 것도 없는 것으로 빛은 이 곳을 통과
        ‘!’은 거울을 설치할 수 있는 위치
        ‘*’은 빛이 통과할 수 없는 벽

            ***#*
            *.!.*
            *!.!*
            *.!.*
            *#***
     */

    // Comparable interface : 정렬을 지원하는 자료구조 (ex: PriorityQueue, TreeSet, TreeMap)에서 정렬 기준을 자동으로 적용
    static class Node implements Comparable<Node> {
        int r, c, dir,move, cnt;

        Node(int r, int c, int dir, int move, int cnt) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.move = move;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Node n) {
            // 거울 개수가 적은 순서대로 우선순위 적용
            return this.cnt - n.cnt;
        }
    }

    public static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // set nodes with 4 direction from first door
        for (int i = 0; i < 4; i ++)
            pq.offer(new Node(sr, sc, i, 0, 0));

        while (! pq.isEmpty()) {
            Node curNode = pq.poll();
            visited[curNode.r][curNode.c][curNode.dir] = true;

            if (curNode.r == er && curNode.c == ec) {
                answer = curNode.cnt;
                return;
            }

            int nr = curNode.r + dr[curNode.dir];
            int nc = curNode.c + dc[curNode.dir];
//            System.out.println("br : " + curNode.r + ", bc : " + curNode.c + ", nr: " + nr + ", nc: " + nc + ", house[nr][nc]: " + ", dir: " + curNode.dir + ", house: " + house[nr][nc] + ", curNode.cnt: " +curNode.cnt);
            if (nr < 0 || nr >= N || nc < 0 || nc >= N || house[nr][nc] == '*') continue;
            if (visited[nr][nc][curNode.dir]) continue;

            visited[nr][nc][curNode.dir] = true;  // update

            if (house[nr][nc] == '!') {
                pq.offer(new Node(nr, nc, (curNode.dir + 1) % 4, curNode.move + 1, curNode.cnt + 1));
                pq.offer(new Node(nr, nc, (curNode.dir + 3) % 4, curNode.move + 1, curNode.cnt + 1));
            }

            pq.offer(new Node(nr, nc, curNode.dir, curNode.move + 1, curNode.cnt));

//            for (int i = 0; i < N; i ++)
//                System.out.println(Arrays.toString(visited[i]));
//            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        house = new char[N][N];
        visited = new boolean[N][N][4];

        boolean isDoor = true;
        for (int i = 0; i < N; i ++) {
            String str = br.readLine();
            for (int j = 0; j < N; j ++) {
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

        bfs();
        System.out.println(answer);
    }
}
