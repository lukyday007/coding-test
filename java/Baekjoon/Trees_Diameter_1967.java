package Baekjoon;

import java.util.*;
import java.io.*;

public class Trees_Diameter_1967 {
    static int N;
    static List<List<Node>> Graph = new ArrayList<>();
    static boolean[] visited;
    static int MaxDist = 0;
    static int FarNode = 0;

    /*
        [way1] dijkstra
            모든 노드에서 다익스트라를 돌려 각 노드에서 가장 멀리 있는 거리를 구함.
            => 노드 수 N에 대해 다익스트라 N번 수행 → O(N² log N) 수준
            => 메모리초과!
        [way2] dfs * 2
            처음 dfs로 가장 멀리 있는 끝 노드 탐색
            끝 노드부터 다시 dfs실행해서 가장 긴 지름 찾기
            => O(N)
    */

    private static class Node {
        int node, cost;

        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i <= N; i ++)
            Graph.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i ++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            Graph.get(from).add(new Node(to, cost));
            Graph.get(to).add(new Node(from, cost));
        }

        visited = new boolean[N + 1];
        dfs(1, 0);

        visited = new boolean[N + 1];
        dfs(FarNode, 0);

        System.out.println(MaxDist);

        /*
            int answer = Integer.MIN_VALUE;
            for (int i = 1; i <= N; i ++) {
                int result = dijkstra(i);
                answer = Math.max(result, answer);
            }
            System.out.println(answer);

        */
    }

    private static void dfs(int start,int cost) {
        visited[start] = true;

        if (cost > MaxDist) {
            MaxDist = cost;
            FarNode = start;
        }

        for (Node next : Graph.get(start)) {
            if (visited[next.node]) continue;
            dfs(next.node, cost + next.cost);
        }
    }

    private static int dijkstra(int start) {
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost)); // 오름차순
        pq.offer(new Node(start, 0));

        while (! pq.isEmpty()) {
            Node cur = pq.poll();
            int curN = cur.node, curC = cur.cost;

            if (visited[curN]) continue; // 이미 방문한 노드라면 무시
            visited[curN] = true; // 방문 처리

            for (Node next: Graph.get(curN)) {
                int nextN = next.node, nextC = next.cost + curC;
                if (dist[nextN] > nextC) {
                    dist[nextN] = nextC;
                    pq.offer(new Node(nextN, nextC));
                }
            }
        }

        int maxDist = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                maxDist = Math.max(maxDist, dist[i]);
            }
        }
        return maxDist;
    }
}
