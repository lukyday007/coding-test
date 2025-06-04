import java.util.*;
import java.io.*;
public class TSP2_10971 {
    static int N;
    static int[][] graph;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        // 어느 한 도시에서 출발해 N개의 도시를 모두 거쳐 다시 원래의 도시로 돌아오는 순회 여행 경로
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        graph = new int[N][N];
        StringTokenizer st;
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c ++) {
                graph[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 0, 0, 0);
        System.out.println(answer);
    }

    static void backtracking(int depth, int total, int prev, int start) {
        // 처음 출발 위치를 어떻게 할 것인가? -> depth = 0 일 때 prev 변경

        if (depth == N) {
            // 자기 자신 위치로 돌아오는 거 막기
            if (graph[prev][start] == 0)    return;
            answer = Math.min(answer, total + graph[prev][start]);
            return;
        }

        for (int i = 0; i < N; i ++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (depth == 0) // prev : 시작도시, i : 다음도시
                backtracking(depth + 1, total, i, i);
            else {
                if (graph[prev][i] == 0) {  // 도시간의 경로가 없을 경우
                    visited[i] = false;
                    continue;
                }
                backtracking(depth + 1, total + graph[prev][i], i, start);
            }
            visited[i] = false;
        }
    }
}
