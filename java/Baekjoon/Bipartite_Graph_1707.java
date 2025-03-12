import java.util.*;
import java.io.*;

public class Bipartite_Graph_1707 {
    static int K;

    /*
            각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때, 그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.
            =>  인접한 노드들끼리 같은 색깔 방문이면 안됨!
            [error 1] 그래프 초기화 주의!
     */

    public static boolean isPossible(List<List<Integer>> Graph, int V) {
        int[] visit = new int[V + 1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < Graph.size(); i ++) {
            if (visit[i] == 0) {
                queue.add(i);
                visit[i] = 1;   // 1 or 2
            }
            while(! queue.isEmpty()) {
                int curNode = queue.poll();

                for (int neighbor : Graph.get(curNode)) {
                    if (visit[neighbor] == 0) {
                        visit[neighbor] = (visit[curNode] == 1) ? 2 : 1;
                        queue.add(neighbor);
                    } else if (visit[neighbor]==visit[curNode])
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i ++) {
            List<List<Integer>> Graph = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            for (int k = 0; k <= V; k ++)
                Graph.add(new ArrayList<>());

            for (int j = 0; j < E; j ++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                Graph.get(u).add(v);
                Graph.get(v).add(u);
            }
            if (isPossible(Graph, V))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
