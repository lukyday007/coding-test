import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baby_One_More_Time_13317 {
    /*
        일반으로 다른 문제에 해당하는 입력 조건을
        이 문제에서는 출력 결과로 제출해야하는 특이한 문제
     */
    public static void main(String[] args) {
        System.out.println("100 99");
        for(int i=2; i<=100; i++){
            System.out.println(i + " " + (i-1) + " " + -1);
        }
    }

    public class p13317 {

    /*  static final int IT_MAX = 262144;
        static final int MOD = 1000000007;
        static final int INF = 1034567891;
        static final long LL_INF = 1234567890123456789l;
        static final double PI = 3.141592653589793238;
        static final double ERR = 1E-11;
    */
        static final int NMX = 1000 + 50;

    /*
        static Pair <Integer, Integer> pii;
        static Pair <Long, Long> pll;
        static Pair <Long, Integer> pli;
        static Pair <Double, Double> pdd;
    */

        static boolean[][] chk = new boolean[105][105];

        static long[] dis = new long[NMX];
        static int[] rev = new int[NMX];

        static class Pair<F,S> {
            F first;
            S second;

            public Pair(F first, S second) {
                this.first = first;
                this.second = second;
            }
        }

        static boolean findNegativeCycle_Wrong(List<Pair <Integer, Pair <Integer, Integer>>> E, int N) {
            int i, j;
            Arrays.fill(dis, 1, N + 1, 0);
            for (i = 1; i <= N-2; i++) {
                for (j = 0; j < E.size(); j++) {
                    Pair <Integer, Pair <Integer, Integer>> u = E.get(j);
                    int s = u.second.first, e = u.second.second;
                    if (dis[e] > dis[s] + u.first) {
                        dis[e] = dis[s] + u.first;
                        rev[e] = j;
                    }
                }
            }

            for (j = 0; j < E.size(); j++) {
                Pair <Integer, Pair <Integer, Integer>> u = E.get(j);
                int s = u.second.first, e = u.second.second;
                if (dis[e] > dis[s] + u.first) {
                    return true;
                }
            }

            return false;
        }

        static boolean findNegativeCycle(List<Pair <Integer, Pair <Integer, Integer>>> E, int N) {
            int i, j;
            Arrays.fill(dis, 1, N + 1, 0);
            for (i = 1; i <= N-1; i++) {
                for (j = 0; j < E.size(); j++) {
                    Pair <Integer, Pair <Integer, Integer>> u = E.get(j);
                    int s = u.second.first, e = u.second.second;
                    if (dis[e] > dis[s] + u.first) {
                        dis[e] = dis[s] + u.first;
                        rev[e] = j;
                    }
                }
            }

            for (j = 0; j < E.size(); j++) {
                Pair <Integer, Pair <Integer, Integer>> u = E.get(j);
                int s = u.second.first, e = u.second.second;
                if (dis[e] > dis[s] + u.first) {
                    return true;
                }
            }
            return false;
        }

        public static void main(String[] args) throws IOException {
            int N, M;
            int t1, t2, t3;
            List <Pair<Integer, Pair<Integer, Integer>>> V = new ArrayList<>();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if( N < 50 || 100 < N || M < 0 || N*(N-1) < M ){
                System.out.println("WA");
                return;
            }
            while (M-->0) {
                st = new StringTokenizer(br.readLine());
                t1 = Integer.parseInt(st.nextToken());
                t2 = Integer.parseInt(st.nextToken());
                t3 = Integer.parseInt(st.nextToken());

                if( t1 < 1 || t1 > N || t2 < 1 || t2 > N ) {
                    System.out.println("WA");
                    return;
                }
                if( t3 != 1 && t3 != -1 || chk[t1][t2]) {
                    System.out.println("WA");
                    return;
                }
                chk[t1][t2] = true;
                V.add(new Pair<>(t3, new Pair<>(t1, t2)));
            }

            boolean ans = findNegativeCycle(V, N);
            boolean wrong = findNegativeCycle_Wrong(V, N);
            if( !ans && wrong ) {
                System.out.println("AC");
            }
            else {
                System.out.println("WA");
            }
        }
    }

}
