package Programmers;
import java.util.*;

public class Lv3_The_Farthest_Node {

    class Solution_BFS {
        static List<List<Integer>> graph = new ArrayList<>();

        public int solution(int n, int[][] edge) {
            int answer = 0;
            for (int i = 0; i <= n; i ++)
                graph.add(new ArrayList<>());

            for (int i = 0; i < edge.length; i ++) {
                int u = edge[i][0], v = edge[i][1];
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            int[] dist = bfs(1, n);
            int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i <= n; i ++)
                maxVal = Math.max(maxVal, dist[i]);

            for (int i = 0; i <= n; i ++)
                if (dist[i] == maxVal)
                    answer ++;

            return answer;
        }

        private static int[] bfs(int start, int n) {
            int[] result = new int[n+1];
            boolean[] visited = new boolean[n+1];

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{1, 1});   // 시작노드, 거리
            visited[1] = true;

            while (! queue.isEmpty()) {
                int[] state = queue.poll();
                int cur = state[0], dist = state[1];
                result[cur] = dist;

                for (int next : graph.get(cur)) {
                    if (visited[next])  continue;

                    visited[next] = true;
                    queue.offer(new int[]{next, dist + 1});
                }
            }

            return result;
        }
    }
}
