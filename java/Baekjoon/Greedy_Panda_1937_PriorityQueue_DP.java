import java.io.*;
import java.util.*;

public class Greedy_Panda_1937_PriorityQueue_DP {
    static int N;
    static int[][] board, dp;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static class Node implements Comparable<Node> {
        int r, c, bamboo;

        public Node(int r, int c, int bamboo) {
            this.r = r;
            this.c = c;
            this.bamboo = bamboo;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.bamboo, other.bamboo); // 대나무가 적은 곳부터 탐색
        }
    }

    /*
        대나무를 먹고 자리를 옮기면 그 옮긴 지역에 그 전 지역보다 대나무가 많이 있어야 한다
        대나무 숲의 크기 n(1 ≤ n ≤ 500)
        최대한 많은 칸을 이동하려면 어떤 경로를 통하여 움직여야 하는지

        [error1] 메모리 초과 -> 중복된 경로의 우선순위 큐가 많이 생겨서! => visited 처리
        [error1] 답이 틀림... -> 왜 때문일까.. -> 대나무 오름차순으로 정렬 + dp
    */

    public static int solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dp = new int[N][N];

        // 모든 위치를 큐에 담고 시작 -> 이후 우선순위 큐로 대나무 작은 순으로 정렬
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                pq.offer(new Node(r, c, board[r][c]));
                dp[r][c] = 1;
            }
        }

        int maxMove = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int r = cur.r, c = cur.c;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] <= board[r][c]) continue;
                dp[nr][nc] = Math.max(dp[nr][nc], dp[r][c] + 1); // 최댓값 갱신
            }

            maxMove = Math.max(maxMove, dp[r][c]);
        }

        return maxMove;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve());
    }
}
