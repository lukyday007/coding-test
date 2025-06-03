import java.util.*;
import java.io.*;

public class Efficient_Hacking_1325 {
    static int N, M;
    static List<List<Integer>> Graph = new ArrayList<>();
    static int[] hackingCounts;
    static boolean[] visited;
    static int maxVal = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        hackingCounts = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            Graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            Graph.get(B).add(A); // B를 해킹하면 A도 해킹할 수 있다.
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            hackingCounts[i] = DFS(i);
            maxVal = Math.max(maxVal, hackingCounts[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (hackingCounts[i] == maxVal) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }

    private static int DFS(int start) {
        visited[start] = true;
        int count = 1; // 자기 자신도 포함하므로 1로 시작

        for (int next : Graph.get(start)) {
            if (!visited[next]) {
                count += DFS(next);
            }
        }

        return count;
    }
}
