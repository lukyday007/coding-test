package Baekjoon;
import java.util.*;
import java.io.*;

public class DSLR_9019 {
    static int N;

    /*
        [ error1 ] 메모리 초과   -> boolean[] visited : 1 - 9999
        [ error2 ] 시간 초과    -> 역추적
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(bfs(a, b)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static String bfs(int start, int target) {
        boolean[] visited = new boolean[10000];
        int[] from = new int[10000];      // 경로 추적용
        char[] cmd = new char[10000];     // 어떤 명령어로 왔는지
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == target) break;

            int[] nexts = {
                (2 * cur) % 10000,
                (cur == 0 ? 9999 : cur - 1),
                (cur % 1000) * 10 + (cur / 1000),
                (cur % 10) * 1000 + (cur / 10)
            };

            char[] ops = {'D', 'S', 'L', 'R'};

            for (int i = 0; i < 4; i++) {
                int next = nexts[i];

                if (!visited[next]) {
                    visited[next] = true;
                    from[next] = cur;
                    cmd[next] = ops[i];
                    queue.offer(next);
                }
            }
        }

        // 경로 역추적
        StringBuilder sb = new StringBuilder();
        int next = target;
        while (next != start) {
            sb.append(cmd[next]);
//            System.out.println(cmd[next] + " next : " + next + ", cur: " + from[next]);
            next = from[next];
        }

        return sb.reverse().toString();
    }
}