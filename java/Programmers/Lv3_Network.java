package Programmers;
import java.util.*;

public class Lv3_Network {
    class Solution_bfs {
        static boolean[] visited;

        public int solution(int n, int[][] computers) {
            int answer = 0;

            visited = new boolean[n];
            for (int i = 0; i < n; i ++) {
                if (visited[i]) continue;
                visited[i] = true;
                bfs(i, computers);
                answer ++;
            }

            return answer;
        }

        private static void bfs(int start, int[][] computers) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);

            while (! queue.isEmpty()) {

                int cur = queue.poll();
                int[] arr = computers[cur];
                for (int i = 0; i < arr.length; i ++) {
                    if (cur == i || computers[cur][i] == 0 || visited[i])  continue;

                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}