package Programmers;
import java.util.*;

public class Lv3_Expression_with_N {

    /*
        정답코드
    */
    class Solution_dfs_memoization {
        int answer = Integer.MAX_VALUE;      // 최소 사용 횟수 저장
        int target;                          // 목표 숫자
        int N;                               // 사용할 숫자
        Set<String> visited = new HashSet<>();  // memoization

        public int solution(int N, int number) {
            this.N = N;
            this.target = number;

            dfs(0, 0);  // 시작값 0, N 사용 횟수 0

            return (answer > 8) ? -1 : answer;
        }

        void dfs(int currentVal, int count) {
            if (count > 8) return;  // 문제 조건: 최대 8번까지만 사용
            if (currentVal == target) {
                answer = Math.min(answer, count);
                return;
            }

            String key = currentVal + "," + count;
            if (visited.contains(key)) return;
            visited.add(key);

            int nn = 0;
            for (int i = 1; i <= 8 - count; i++) {
                nn = nn * 10 + N;  // 5, 55, 555 ...

                dfs(currentVal + nn, count + i);
                dfs(currentVal - nn, count + i);
                dfs(currentVal * nn, count + i);
                if (nn != 0 && currentVal % nn == 0) dfs(currentVal / nn, count + i);
            }
        }
    }

    // 삽질 기념 => 60% 정답
    // 조합은 dfs + memoization, dp로!
    class solution_bfs {
        public int solution_bfs(int N, int number) {

            int answer = bfs(N, number);
            return answer > 8 ? -1 : answer;
        }

        static int bfs(int N, int target) {
            int result = Integer.MAX_VALUE;
            boolean[] visited = new boolean[32001]; // [1~32000]

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{N, 1});
            visited[N] = true;

            while (!queue.isEmpty()) {
                int[] tmp = queue.poll();
                int cur = tmp[0], time = tmp[1];

                if (cur == target) {
                    return time;
                }
                if (time >= 8) {
                    continue;
                }

                int[] ways = new int[8];
                ways[0] = cur * 10 + N;
                ways[1] = cur + N;
                ways[2] = cur - N;
                ways[3] = N - cur;
                ways[4] = cur * N;
                ways[5] = (N != 0 && cur % N == 0) ? cur / N : -1;
                ways[6] = (cur != 0 && N % cur == 0) ? N / cur : -1;

                for (int i = 0; i < ways.length; i++) {
                    int next = ways[i];
                    if (next < 1 || next > 32000) continue;
                    if (visited[next]) continue;

                    visited[next] = true;
                    queue.offer(new int[]{next, time + 1});
                }
            }

            return -1;
        }
    }
}