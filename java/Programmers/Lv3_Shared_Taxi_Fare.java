package PACKAGE_NAME;
import java.util.*;

public class Lv3_Shared_Taxi_Fare {
    /*
        지점갯수 n은 3 이상 200 이하인 자연수
        지점 s, a, b는 1 이상 n 이하인 자연수
        fares는 2차원 정수 배열
    */

    static int E;
    static int N;
    static int[][] dist;
    static int INF = Integer.MAX_VALUE;

    public static void floydWarshall() {
        for (int m = 0; m < N; m ++) {
            for (int s = 0; s < N; s ++) {
                if (dist[s][m] == INF)  continue;
                for (int e = 0; e < N; e ++) {
                    if (s == e || dist[m][e] == INF)  continue;

                    dist[s][e] = Math.min(dist[s][e], dist[s][m] + dist[m][e]);
                }
            }
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        dist = new int[n][n];
        E = fares.length;
        N = n;

        for (int i = 0; i < N; i ++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < E; i ++) {
            int from, to, cost;
            from = fares[i][0] - 1;
            to = fares[i][1] - 1;
            cost = fares[i][2];

            dist[from][to] = Math.min(cost, dist[from][to]);
            dist[to][from] = Math.min(cost, dist[to][from]);
        }

        floydWarshall();


        for (int i = 0; i < N; i ++)
            answer = Math.min(answer, dist[s-1][i] + dist[a-1][i] + dist[b-1][i]);

        return answer;
    }
}
