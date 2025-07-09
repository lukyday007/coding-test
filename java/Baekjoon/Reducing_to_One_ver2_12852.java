package Baekjoon;

import java.util.*;
import java.io.*;
public class Reducing_to_One_ver2_12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] route = new int[N + 1]; // 역추적
        boolean[] visited = new boolean[N + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == 1) break;

            int[] nexts = {cur - 1, cur % 2 == 0 ? cur / 2 : -1, cur % 3 == 0 ? cur / 3 : -1};

            for (int next : nexts) {
                if (next > 0 && !visited[next]) {
                    visited[next] = true;
                    route[next] = cur; // next는 cur에서 왔다
                    queue.offer(next);
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        for (int i = 1; i != 0; i = route[i]) {
            path.add(i);
        }
        Collections.reverse(path); // N → ... → 1 순서로 뒤집기

        System.out.println(path.size() - 1); // 연산 횟수
        for (int n : path) {
            System.out.print(n + " ");
        }
    }
}
