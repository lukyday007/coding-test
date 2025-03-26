import java.util.*;
import java.io.*;

public class Kevins_6Step_Rule_1389 {
    static int N, M;
    static int MinVal = Integer.MAX_VALUE;
    static List<List<Integer>> Graph = new ArrayList<>();
    static boolean[] check;
    /*
        케빈 베이컨의 수가 가장 작은 사람을 구하는 프로그램

        [error1] int curNode = queue.poll().node, curCost = queue.poll().cost;
                poll() 2번 호출!

        result += curCost;
        => BFS는 모든 정점을 거리 순으로 탐색하기 때문에, 큐에서 꺼낼 때마다 cost는 정확한 최단 거리
        모든 노드를 다 꺼낼 때까지 돌면 모든 거리의 합

        result = curCost;
        => 가장 마지막으로 방문된 노드까지의 거리만 계산
    */
    public static class Node {
        int node, cost;
        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i ++)
            Graph.add(new ArrayList<>());

        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 친구 관계는 중복되어 들어올 수도 있으며
            if (! Graph.get(a).contains(b))
                Graph.get(a).add(b);
            if (! Graph.get(b).contains(a))
                Graph.get(b).add(a);
        }

        int[] result = new int[N + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i ++) {
            int res = BFS(i);
            MinVal = Math.min(res, MinVal);
            result[i] = res;
        }

        for (int i = 1; i <= N; i ++) {
            if (MinVal == result[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    public static int BFS(int startNode) {
        int result = 0;
        check = new boolean[N + 1];
        Queue<Node> queue = new LinkedList<>();
        int move = 0;
        queue.add(new Node(startNode, move));
        check[startNode] = true;

        while (! queue.isEmpty()) {
            Node cur = queue.poll();
            int curNode = cur.node, curCost = cur.cost;
            result += curCost;
//            System.out.println("node : " + curNode + ", cost : " + curCost);

            for (int next : Graph.get(curNode)) {
                if (check[next]) continue;
                check[next] = true;
                queue.offer(new Node(next, curCost + 1));
            }

        }
//        System.out.println("start: " + startNode + ", result : " + result);
        return result;
    }
}