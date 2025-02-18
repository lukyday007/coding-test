import java.util.*;
import java.io.*;

public class Floyd_Warshall_11404 {
    static int N;   // cities
    static int M;   // buses
    static int[][] dist;
    static int INF = Integer.MAX_VALUE;

    public static void floydWarshall() {
        for (int m = 0; m < N; m ++) {
            for (int s = 0; s < N; s ++) {
                // s 에서 m 으로 가는 버스가 없는 경우 패스
                if (dist[s][m] == Integer.MAX_VALUE) continue;
                for (int e = 0; e < N; e ++) {
                    // m 에서 s 으로 가는 버스가 없는 경우 패스
                    if (dist[m][e] == Integer.MAX_VALUE) continue;
                    dist[s][e] = Math.min(dist[s][e], dist[s][m] + dist[m][e]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N][N];

        for (int i = 0; i < N; i ++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < M; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sta = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            dist[sta][end] = Math.min(dist[sta][end], cost);
            dist[end][sta] = Math.min(dist[end][sta], cost);
        }

        floydWarshall();

        for (int r = 0; r < N; r ++) {
            for (int c = 0; c < N; c ++) {
                if (dist[r][c] == Integer.MAX_VALUE)
                    dist[r][c] = 0;
                System.out.print(dist[r][c] + " ");
            }
            System.out.println();
        }
    }
}
