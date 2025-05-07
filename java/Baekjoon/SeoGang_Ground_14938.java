import java.sql.Array;
import java.util.*;
import java.io.*;

public class SeoGang_Ground_14938 {
    static int n, m, r;
    static int[] items;
    static List<List<Point>> Graph = new ArrayList<>();

    /*
        [ERROR]
        시작 노드에서 해당 노드까지의 최단 거리가 !수색 범위 m 이내!일 때 => 다익스트라 힌트
        해당 노드의 아이템을 최대로 수집
    */

    private static class Point {
        int node, cost;

        public Point (int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i ++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n; i ++)
            Graph.add(new ArrayList<>());

        for (int i = 0; i < r; i ++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            Graph.get(u).add(new Point(v, cost));
            Graph.get(v).add(new Point(u, cost));
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i ++) {
            int maxCost = dijkstra(i);
            answer = Math.max(answer, maxCost);
        }
        System.out.println(answer);
    }

    private static int dijkstra(int node) {
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node] = 0;
        visited[node] = true;

        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Point(node, 0));

        while (! pq.isEmpty()) {
            Point point = pq.poll();
            int cn = point.node, cc = point.cost;
            System.out.println("cn : " + cn + ", cc: " + cc);

            if (cc > dist[cn])  continue;

            for (Point next: Graph.get(cn)) {
                int nn = next.node, nc = next.cost + cc;
                if (nc <= m && dist[nn] > nc) {
                    dist[nn] = nc;
                    System.out.println(Arrays.toString(dist) + " -> " + nn);
                    pq.offer(new Point(nn, nc));
                }
            }
        }
        System.out.println("dist : " + Arrays.toString(dist));

        int result = 0;
        for (int i = 1; i <= n; i ++)
            if (dist[i] <= m)   /* KEY POINT !! */
                result += items[i];

        return result;
    }
}