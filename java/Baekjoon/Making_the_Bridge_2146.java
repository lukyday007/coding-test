import java.util.*;
import java.io.*;

public class Making_the_Bridge_2146 {
    static int N;
    static int answer = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
    /*
        [idea]
        테두리 좌표 저장 -> boolean[][] isEdge로 따로 표기
        어느 섬에서 왔는지 체크 -> boolean[][][island] check

        [optimization] memory : 274920kb -> 66020kb, time : 1088ms -> 176ms
        cnt는 BFS가 한 레벨(=한 칸 거리)을 확산할 때마다 +1
        while (size-- > 0) 패턴을 통해 같은 거리의 노드만 한 번에 처리
        모든 큐 원소는 cnt만큼 바다를 건넌 상태
        가장 먼저 다른 섬에 도달한 큐의 cnt 값이 곧 최단 다리 길이
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        // 섬에 번호 매기기 + 테두리 좌표만 저장
        Queue<int[]> edges = new ArrayDeque<>();  // r, c, island
        int island = 1;
        visited = new boolean[N][N];
        for (int r = 0; r < N; r ++) {
            for (int c = 0; c < N; c ++) {
                if (visited[r][c] || map[r][c] == 0)  continue;
                markIslandAndGetEdges(r, c, island++, edges);
            }
        }

        System.out.println(getMinDistBridge(edges, island));
    }

    private static void markIslandAndGetEdges (int r, int c, int id, Queue<int[]> edges) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r,c});
        map[r][c] = id;
        visited[r][c] = true;

        while (! queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr = cur[0], cc = cur[1];
            boolean isEdge = false;

            for (int d = 0; d < 4; d ++) {
                int nr = cr + dr[d], nc = cc + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])  continue;
                // 바다일 때 -> edges
                if (map[nr][nc] == 0) {
                    isEdge = true;
                    continue;
                }

                if (map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                    map[nr][nc] = id;
                }
            }

            if (isEdge)
                edges.offer(new int[]{cr, cc, id});
        }
    }

    private static int getMinDistBridge (Queue<int[]> edges, int cntIsland) {
        boolean[][][] visited = new boolean[N][N][cntIsland];
        int cnt = 0;
        while (! edges.isEmpty()) {
            int size = edges.size();
            while (size --> 0) {
                int[] edge = edges.poll();
                int cr = edge[0], cc = edge[1], id = edge[2];

                for (int d = 0; d < 4; d++) {
                    int nr = cr + dr[d], nc = cc + dc[d];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc][id] || id == map[nr][nc]) continue;

                    // 다른 섬을 만났을 때
                    if (map[nr][nc] != 0 && map[nr][nc] != id) {
                        return cnt;
                    }
                    // 바다일 때
                    if (map[nr][nc] == 0) {
                        visited[nr][nc][id] = true;
                        edges.offer(new int[] {nr, nc, id});
                    }
                }
            }
            cnt++;
        }

        return Integer.MAX_VALUE;
    }
}