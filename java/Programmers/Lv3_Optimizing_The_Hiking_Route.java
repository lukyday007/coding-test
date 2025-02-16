package PACKAGE_NAME;
import java.util.*;

public class Lv3_Optimizing_The_Hiking_Route  {
    static final int INF = Integer.MAX_VALUE;
    static List<List<Edge>> graph = new ArrayList<>();
    static int[] result;
    // Set으로 다른 게이트나 정점을 조회하는 게 시간 단축이 많이 됨!!!
    static Set<Integer> gates, summits;

    /*
        각 지점은 1부터 n까지 번호가 붙어있으며, 출입구, 쉼터, 혹은 산봉우리
        양방향 통행이 가능한 등산로, 등산로별로 이동하는데 일정 시간이 소요
        쉼터 혹은 산봉우리를 방문할 때마다 휴식을 취할 수 있으며,
        휴식 없이 이동해야 하는 시간 중 가장 긴 시간을 해당 등산코스의 intensity
        출입구 중 한 곳에서 출발하여 산봉우리 중 한 곳만 방문한 뒤 다시 원래의 출입구로 돌아오는

        등산코스에서 출입구는 처음과 끝에 한 번씩, 산봉우리는 한 번만 포함

        n = 4, paths = [[1, 3, 1], [1, 4, 1], [4, 2, 1]], gate = [1], summits = [2, 3, 4]
answer = [3, 1] // [2, 1]이 나오면 실패!
    */
    static class Edge {
        int point, weight;

        Edge(int point, int weight) {
            this.point = point;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node>{
        int point, cost;

        Node(int point, int cost) {
            this.point = point;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }
    }

    public static int[] dijkstra(int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        // 출발점 먼저 입력하기
        for (int gate : gates) {
            pq.offer(new Node(gate, 0));
            dist[gate] = 0;
        }

        while (! pq.isEmpty()) {
            // System.out.println("dist: " + Arrays.toString(dist));
            Node node = pq.poll();
            int point = node.point;
            int cost = node.cost;

            // 산봉우리에 도착하면 해당 노드는 패스
            if (summits.contains(point))    continue;

            if (cost > dist[point])   continue;

            for (Edge edge : graph.get(point)) {
                int newPoint = edge.point;
                int newCost = Math.max(dist[point], edge.weight);

                // 다른 출입구면 패스
                if (gates.contains(newPoint))    continue;

                if (newCost < dist[newPoint]) {
                    dist[newPoint] = newCost;
                    pq.offer(new Node(newPoint, newCost));
                }
            }
        }
        return dist;
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        result = new int[n + 1];
        Arrays.fill(result, INF);

        this.gates = new HashSet<>();
        for (int gate : gates) {
            this.gates.add(gate);
        }

        this.summits = new HashSet<>();
        for (int summit : summits) {
            this.summits.add(summit);
        }

        for (int i = 0; i < n + 1; i ++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < paths.length; i ++) {
            int startN = paths[i][0];
            int endN = paths[i][1];
            int cost = paths[i][2];
            graph.get(startN).add(new Edge(endN, cost));
            graph.get(endN).add(new Edge(startN, cost));
        }

        int minV = Integer.MAX_VALUE;
        int sm = 0;

        int[] res = dijkstra(n);

        // 정점이 항상 정렬된 상태로 입력되지 않을 가능성도 있음 !!!!!!
        // [힌트] => intensity가 최소가 되는 등산코스가 여러 개라면 그중 산봉우리의 번호가 가장 낮은 등산코스를 선택
        Arrays.sort(summits);

        for (int summit : summits) {
            if (minV > res[summit]) {
                minV = res[summit];
                sm = summit;
            }
        }


        return new int[]{sm, minV};
    }
}