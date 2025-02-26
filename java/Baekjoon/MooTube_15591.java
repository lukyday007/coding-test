import java.util.*;
import java.io.*;

public class MooTube_15591 {
    static int N, Q;
    static List<List<int[]>> graph = new ArrayList<>();
    static int[] answer;

    public static int bfs(int start, int usado) {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        queue.offer(start);
        visited[start] = true;

        while (! queue.isEmpty()) {
            int curNode = queue.poll();
            for (int[] next : graph.get(curNode)) {
                int neighbor = next[0];
                int u = next[1];

                if (visited[neighbor])  continue;
                if (u < usado)  continue;

                visited[neighbor] = true;
                queue.offer(neighbor);
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        answer = new int[Q];

        for (int i = 0; i < N; i ++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i ++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()) - 1;
            int q = Integer.parseInt(st.nextToken()) - 1;
            int u = Integer.parseInt(st.nextToken());

            graph.get(p).add(new int[] {q, u});
            graph.get(q).add(new int[] {p, u});
        }

        for (int i = 0; i < Q; i ++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());   // 유사도
            int k = Integer.parseInt(st.nextToken()) - 1;   // 번호
            answer[i] = bfs(k, v);
        }

        for (int i = 0; i < Q; i ++)
            System.out.println(answer[i]);
    }
}