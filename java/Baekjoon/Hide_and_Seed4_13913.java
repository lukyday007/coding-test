import java.util.*;
import java.io.*;

public class Hide_and_Seed4_13913 {
    static int N, K;
    static int answer = Integer.MAX_VALUE;
    static int[] path = new int[100001];

    static class Node {
        int node, time;
        private Node(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        BFS(N, K, 0);

        List<Integer> route = new ArrayList<>();
        // 17 - 16 - 8 - 4 - 5 를 역순으로 접근
        for (int i = K; i != -1; i = path[i]) {
            route.add(i);
        }
        Collections.reverse(route);
        System.out.println((route.size() - 1));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < route.size(); i ++) {
            sb.append(route.get(i)).append(" ");
        }
        System.out.println(sb);
    }

    private static void BFS(int N, int K, int time) {

        boolean[] visited = new boolean[100001];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(N, 0));
        visited[N] = true;
        path[N] = -1;

        while (! queue.isEmpty()) {
            Node node = queue.poll();
            int curNode = node.node, curTime = node.time;

            if (curNode == K) break;

            int[] moves = {curNode - 1, curNode + 1, curNode * 2};
            for (int move : moves) {
                if (move > 100000 || move < 0 || visited[move] )  continue;

                path[move] = curNode;
                visited[move] = true;
                queue.offer(new Node(move, curTime + 1));
            }
        }
    }
}