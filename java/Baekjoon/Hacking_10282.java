package Baekjoon;

import java.util.*;
import java.io.*;

public class Hacking_10282 {
    static int T;
    static List<List<Node>> Graph;

    static class Node {
        int node, cost;
        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t ++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            Graph = new ArrayList<>();
            for (int n = 0; n <= N; n ++)
                Graph.add(new ArrayList<>());

            for (int d = 0; d < D; d ++) {
                // 어떤 컴퓨터 a가 다른 컴퓨터 b에 의존한다면, b가 감염되면 그로부터 일정 시간 뒤 a도 감염.
                // 이때 b가 a를 의존하지 않는다면, a가 감염되더라도 b는 안전
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());   // to
                int b = Integer.parseInt(st.nextToken());   // from
                int s = Integer.parseInt(st.nextToken());
                Graph.get(b).add(new Node(a, s));
            }

            // 한 줄에 걸쳐 총 감염되는 컴퓨터 수, 마지막 컴퓨터가 감염되기까지 걸리는 시간
            int[] result = solution(N, C);
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int[] solution(int total, int start) {
        int cnt = 0, time = 0;
        int[] dist = new int[total + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        queue.add(new Node(start, 0));

        while (! queue.isEmpty()) {
            Node cur = queue.poll();
            int cn = cur.node, cc = cur.cost;

            if (dist[cn] < cc)  continue;
            time = Math.max(cc, time);
            cnt ++;

            for (Node next : Graph.get(cn)) {
                int nc = cc + next.cost;
                if (dist[next.node] <= nc)  continue;
                dist[next.node] = nc;
                queue.add(new Node(next.node, nc));
            }
        }

        return new int[]{cnt, time};
    }
}