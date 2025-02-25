import java.util.*;
import java.io.*;

public class Baby_Shark_16236 {
    // [error1] 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러 마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
    // => BFS 방향 접근 순서 dr, dc 는 접근의 우선순위를 보장하지 못함
    // [solve] 우선순위 큐 정렬 조건에 추가

    // [error2] 같은 사이즈의 물고기가 여러 곳에 위치

    static int N;
    static int[][] board;
    static int answer = 0, cr = 0, cc = 0, shark = 2;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int[] fishes;
    static List<List<Point>> fishArr = new ArrayList<>();

    public static class Point {
        int r, c;
        public Point(int r, int c ) {
            this.r = r;
            this.c = c;
        }
    }

    public static class PointDist implements Comparable<PointDist> {
        Point point;    int dist;
        PointDist(Point point, int dist) {
            this.point = point;
            this.dist = dist;
        }

        @Override
        public int compareTo(PointDist p) {
            if (this.dist != p.dist)
                return Integer.compare(this.dist, p.dist);
            // 같은 거리일 때, 위쪽 먼저
            if (this.point.r != p.point.r)
                return Integer.compare(this.point.r, p.point.r);
            // 같은 위쪽, 왼쪽 먼저
            return Integer.compare(this.point.c, p.point.c);
        }
    }

    public static PriorityQueue<PointDist> getEdibleFish(int r, int c) {

        PriorityQueue<PointDist> pq = new PriorityQueue<>();
        int[][] dist = new int[N][N];
        dist[r][c] = 0; // 시작 위치

        for (int i = 0; i < N; i ++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        Queue<PointDist> queue = new LinkedList<>();
        queue.offer(new PointDist(new Point(r, c), 0)); // 상어 위치 추가

        while (! queue.isEmpty()) {
            PointDist pd = queue.poll();
            int cr = pd.point.r, cc = pd.point.c, curDist = pd.dist;

            for (int i = 0; i < 4; i ++) {
                int nr = cr + dr[i], nc = cc + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] > shark)
                    continue; // 범위 초과 or 상어보다 큰 물고기 존재
                if (dist[nr][nc] <= curDist + 1)    continue;

                dist[nr][nc] = curDist + 1;
                queue.offer(new PointDist(new Point(nr, nc), curDist + 1));

                if (board[nr][nc] > 0 && board[nr][nc] < shark)
                    pq.offer(new PointDist(new Point(nr, nc), curDist + 1));
            }
        }

        return pq;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        fishes = new int[N];

        for (int i = 0; i < 7; i++)
            fishArr.add(new ArrayList<>());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int fishSize = Integer.parseInt(st.nextToken());
                board[i][j] = fishSize;
                if (fishSize == 9) {
                    cr = i;
                    cc = j;
                }
            }
        }
        board[cr][cc] = 0;

        int eatTimes = 0, answer = 0;

        while (true) {
            PriorityQueue<PointDist> pq = getEdibleFish(cr, cc);

            if (pq.isEmpty()) break; // 더 이상 먹을 물고기가 없으면 종료

            // 가장 가까운 물고기 먹기
            PointDist pd = pq.poll();
            // 상어 위치 갱신
            cr = pd.point.r;
            cc = pd.point.c;
            answer += pd.dist;
            board[cr][cc] = -1; // 먹은 물고기 자리 비우기
            eatTimes++;

            if (eatTimes == shark) { // 상어 크기 증가 조건
                shark++;
                eatTimes = 0;
            }
        }

        System.out.println(answer);
    }
}