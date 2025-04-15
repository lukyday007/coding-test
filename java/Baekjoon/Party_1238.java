import java.util.*;
import java.io.*;

public class Party_1238 {
    static int N, M, X;
    static List<List<Node>> Graph = new ArrayList<>();
    /*
        이 도로들은 단방향이기 때문에 아마 그들이 오고 가는 길이 다를지도 모른다.
        N명의 학생들 중 오고 가는데 가장 많은 시간을 소비하는 학생은 누구
        가장 오래 걸리는 학생의 소요시간을 출력
        모든 학생들은 집에서 X에 갈수 있고, X에서 집으로 돌아올 수 있는
    */
    private static class Node {
        int node, cost;
        private Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i ++)
            Graph.add(new ArrayList<>());

        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Graph.get(u).add(new Node(v, c));
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i ++) {
            int costA = dijkstra(i, X); // go to the party
            int costB = dijkstra(X, i); // come back home
            answer = Math.max(answer, costA + costB);
//            System.out.println("a : " +costA + ", b : " + costB);
        }
        System.out.println(answer);
    }

    private static int dijkstra (int start, int goal) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 최단거리로 이동 -> 우선순위 큐 (오름차순)
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (! pq.isEmpty()) {
            Node node = pq.poll();
            int cur = node.node, cost = node.cost;

            if (cur == goal)    break;
            if (dist[cur] < cost)   continue;

            for (Node nextNode : Graph.get(cur)) {
                int next = nextNode.node, nextCost = nextNode.cost + dist[cur];

                if (dist[next] > nextCost) {
                    dist[next] = nextCost;
                    pq.offer(new Node(next, dist[next]));
                }
            }
        }

        return dist[goal];
    }
}