import java.util.*;
import java.io.*;

public class Delivery_1719 {
    static int N, M;
    static int[][] dist, visited;
    static int INF = Integer.MAX_VALUE;

    public static void floydWarshall() {
        for (int m = 0; m < N; m ++) {
            for (int s = 0; s < N; s ++) {
                if (dist[s][m] == INF)  continue;
                for (int e = 0; e < N; e ++) {
                    if (s == e) continue;
                    if (dist[m][e] == INF)  continue;

                    int newDist = dist[s][m] + dist[m][e];
                    if (dist[s][e] > newDist) {
                        dist[s][e] = newDist;
                        visited[s][e] = visited[s][m];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i ++) {
            Arrays.fill(dist[i], INF);
            for (int j = 0; j < N; j ++ ) {
                if (i == j) {
                    visited[i][j] = 0;
                    dist[i][j] = 0;
                }
                else
                    visited[i][j] = j + 1;
            }
        }

        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int a, b, c;
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
            dist[b][a] = Math.min(dist[b][a], c);
        }

        floydWarshall();
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                if (i == j)
                    System.out.print("- ");
                else
                    System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }
}