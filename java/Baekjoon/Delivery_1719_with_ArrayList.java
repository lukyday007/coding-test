import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Delivery_1719_with_ArrayList {
    static int N, M;
    static int[][] dist, visited;
    static List<List<List<Integer>>> check = new ArrayList<>();
    static int INF = Integer.MAX_VALUE;

    public static void floydWarshall() {
        for (int m = 0; m < N; m++) {
            for (int s = 0; s < N; s++) {
                if (dist[s][m] == INF) continue;
                for (int e = 0; e < N; e++) {
                    if (s == e) continue;
                    if (dist[m][e] == INF) continue;

                    int newDist = dist[s][m] + dist[m][e];
                    if (dist[s][e] > newDist) {
                        dist[s][e] = newDist;

//                        System.out.println("before s : " + (s+1) + ", e : " + (e+1) + " - "
//                                + Arrays.toString(check.get(s).get(e).toArray(new Integer[0])));
                        check.get(s).get(e).clear();
                        // visited[s][m] = check.get(s).get(m)
                        check.get(s).get(e).addAll(check.get(s).get(m));
//                        System.out.println("middle s : " + (s+1) + ", e : " + (e+1) + ", m : " +(m+1) + " - "
//                                + Arrays.toString(check.get(s).get(e).toArray(new Integer[0])));

                        // 새 경유지 추가 (m)
                        if (!check.get(s).get(e).contains(m + 1)) {  // 중복 방지
                            check.get(s).get(e).add(m + 1);
                        }
                        check.get(s).get(e).addAll(check.get(m).get(e));

//                        System.out.println("after s : " + (s+1) + ", e : " + (e+1) + " - "
//                                + Arrays.toString(check.get(s).get(e).toArray(new Integer[0])));

                        visited[s][e] = check.get(s).get(e).get(0);
//                        System.out.println();
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
            check.add(new ArrayList<>());

            // 초반 도착지를 먼저 세팅하는게 중요!!
            for (int j = 0; j < N; j ++ ) {
                check.get(i).add(new ArrayList<>());
                if (i == j) {
                    visited[i][j] = 0;
                    dist[i][j] = 0;
                }
                else
                    visited[i][j] = j + 1;
                    check.get(i).get(j).add(j + 1);
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