import java.util.*;
import java.io.*;

public class Finding_Parents_of_Tree_DFS_11725 {
    static int N;
    static List<List<Integer>> Graph = new ArrayList<>();
    static int[] parents;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i ++)
            Graph.add(new ArrayList<>());
        parents = new int[N + 1];
        Arrays.fill(parents, -1);

        StringTokenizer st;
        for (int i = 0; i < N - 1; i ++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            Graph.get(u).add(v);
            Graph.get(v).add(u);
        }

        dfs(1);
        for (int i = 2; i <= N; i ++)
            System.out.println(parents[i]);
    }

    private static void dfs(int cur) {

        for (int next : Graph.get(cur)) {
            if (parents[next] != -1) continue;
            parents[next] = cur;
            dfs(next);
        }
    }
}