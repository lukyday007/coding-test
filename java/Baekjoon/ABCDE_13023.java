import java.util.*;
import java.io.*;

public class ABCDE_13023 {
    static int N, M;
    static List<List<Integer>> Graph = new ArrayList<>();
    static boolean isFound = false;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            Graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Graph.get(a).add(b);
            Graph.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            visited[i] = true;
            dfs(i, 0, visited);
            if (isFound) break;
        }

        System.out.println(isFound ? 1 : 0);
    }

    private static void dfs(int node, int depth, boolean[] visited) {
        if (depth == 4) {
            isFound = true;
            return;
        }

        for (int next : Graph.get(node)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, depth + 1, visited);
                visited[next] = false; // 백트래킹
                if (isFound) return;
            }
        }
    }
}
