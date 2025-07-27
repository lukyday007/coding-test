package Baekjoon;

import java.util.*;
import java.io.*;

public class Finding_the_Minimum_Cost2_11779 {

    /*
        [ error ]
            if (nextCost > dist[nextNode])   continue;
           => 같은 거리인 경우에도 우선순위 큐에 넣어서 메모리 초과 발생
           => nextCost >= dist[nextNode]
    */
    static int C, B, departure, arrival;
    static List<List<int[]>> Graph = new ArrayList<>();
    static int[] route;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        C = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());

        for (int i = 0; i <= C; i ++)
            Graph.add(new ArrayList<>());

        StringTokenizer st;
        for (int i = 0; i < B; i ++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            Graph.get(from).add(new int[]{to, cost});
        }

        st = new StringTokenizer(br.readLine());
        departure = Integer.parseInt(st.nextToken());
        arrival = Integer.parseInt(st.nextToken());

        int result = dijkstra(departure, arrival);

        int[] traceback = new int[C + 1];
        int idx = 0;
        for (int i = arrival; i != 0; i = route[i]) {
            traceback[idx++] = i;
            if (i == departure) break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result).append("\n");
        sb.append(idx).append("\n");
        for (int i = idx - 1; i >= 0; i --) sb.append(traceback[i]).append(" ");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int dijkstra(int departure, int arrival) {
        route = new int[C + 1];
        int[] dist = new int[C + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{departure, 0});

        while (! pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0], curCost = cur[1];

            if (curNode == arrival) break;
            if (curCost > dist[curNode])    continue;

            for (int[] next: Graph.get(curNode)) {
                int nextNode = next[0], nextCost = next[1] + curCost;
                if (nextCost >= dist[nextNode])   continue;
                dist[nextNode] = nextCost;
                route[nextNode] = curNode;
                pq.offer(new int[]{nextNode, nextCost});
            }
        }

//        System.out.println("dist: " + Arrays.toString(dist));
//        System.out.println("route: " + Arrays.toString(route));
        return dist[arrival];
    }
}