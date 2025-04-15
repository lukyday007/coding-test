import java.util.*;
import java.io.*;

public class Finding_Parents_of_Tree_BFS_11725 {
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
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        parents[1] = 0;

        while (! queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : Graph.get(cur)) {
                if (parents[next] != -1)    continue;
                parents[next] = cur;
                queue.offer(next);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
