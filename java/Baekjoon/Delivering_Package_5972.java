import java.util.*;
import java.io.*;

public class Delivering_Package_5972 {
    static int N, M;
    static int[] dists;
    static List<List<Point>> Graph = new ArrayList<>();

    private static class Point {
        int node, cost;
        private Point(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    /*
        농부 현서는 헛간 1에 있고 농부 찬홍이는 헛간 N
        지나가는 길에 소를 만나면 줘야할 여물의 비용이 주어질 때 최소 여물
    */

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i ++)
            Graph.add(new ArrayList<>());

        dists = new int[N + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);

        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            Graph.get(a).add(new Point(b, c));
            Graph.get(b).add(new Point(a, c));
        }

        dijkstra(1);
        System.out.println(dists[N]);
    }

    private static void dijkstra (int start) {
        // ascending
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Point(start, 0));
        dists[start] = 0;

        while (! pq.isEmpty()) {
            Point curPoint = pq.poll();
            int curNode = curPoint.node, curCost = curPoint.cost;

            if (dists[curNode] < curCost)   continue;

            for (Point nextPoint: Graph.get(curNode)) {
                int nextNode = nextPoint.node, nextCost = dists[curNode] + nextPoint.cost;

                if (dists[nextNode] > nextCost) {
                    dists[nextNode] = nextCost;
                    pq.offer(new Point(nextNode, nextCost));
                }
            }
        }
    }
}