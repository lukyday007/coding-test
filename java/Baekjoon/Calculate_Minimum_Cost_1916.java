import java.util.*;
import java.io.*;

public class Calculate_Minimum_Cost_1916 {
    static int Cities, Buses, Start, End;
    static long[] dists;
    static boolean[] visited;
    static int INF = Integer.MAX_VALUE;
    static List<List<Node>> lines = new ArrayList<>();

    public static class Node implements Comparable<Node> {
        int node; long cost;
        public Node(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node other) {
            // 기본 오름차순
            return Long.compare(this.cost, other.cost);
        }
    }

    public static void dijkstra(int start) {
        // 가중치 기준 오름차순 => 최소 비용 부터 나옴
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0)); // 시작 노드 세팅
        dists[start] = 0;

        while (! pq.isEmpty()) {
            Node curNode = pq.poll();
            int n = curNode.node;
            long c = curNode.cost;

            if (dists[n] < c)  continue;

            for (int i = 0; i < lines.get(n).size(); i ++) {
                Node nextNode = lines.get(n).get(i);
                long newCost = dists[n] + nextNode.cost;

                if (dists[nextNode.node] > newCost) {
//                    System.out.println("cur: " + n + ", next: " + nextNode.node);
                    dists[nextNode.node] = newCost;
                    pq.offer(new Node(nextNode.node, newCost));
//                    System.out.println(Arrays.toString(dists));
                }
            }
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Cities = Integer.parseInt(br.readLine());
        Buses = Integer.parseInt(br.readLine());

        for (int i = 0; i <= Cities; i ++)
            lines.add(new ArrayList<>());

        dists = new long[Cities + 1];
        visited = new boolean[Cities + 1];
        Arrays.fill(dists, INF);


        StringTokenizer st;
        for (int i = 0; i < Buses; i ++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());

            lines.get(from).add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        Start = Integer.parseInt(st.nextToken());
        End = Integer.parseInt(st.nextToken());

        // 버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수 -> long 변환해서 출력
        dijkstra(Start);
        System.out.println(dists[End]);
    }
}
