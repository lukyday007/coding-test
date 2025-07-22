package Baekjoon;

import java.util.*;
import java.io.*;

public class Shortcut_1446 {

    /*
        dp가 적합하고 다익스트라는 아닌 이유
        -> 전체 노드가 선형이고, "모든 노드가 번호순으로만 전진"하기 때문
        -> 다익스트라는 "가중치가 다양하거나 노드 간 이동 방향이 비선형적일 때" 적합
    */
    static int N, D;
    static List<List<Path>> shortcut = new ArrayList<>();

    static class Path {
        int to, dist;

        public Path(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        // 일반통행
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= D + 1; i ++) {
            shortcut.add(new ArrayList<>());
        }

        int[] dp = new int[D + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;


        // 지름길의 시작 위치, 도착 위치, 지름길의 길이
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            // 유효하지 않은 지름길 제외 ex. 150 -> 151
            if (to > D || to - from <= dist)    continue;

            shortcut.get(from).add(new Path(to, dist));
        }

        for (int i = 0; i <= D; i++) {
            // 이전 위치에서 직선 도로로 오는 경우
            if (i > 0)
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);

            // 현재 위치에서 출발하는 지름길 처리
            for (Path p : shortcut.get(i))
                if (p.to <= D)
                    dp[p.to] = Math.min(dp[p.to], dp[i] + p.dist);

        }

        bw.write(String.valueOf(dp[D]));
        bw.flush();
        bw.close();
    }
}