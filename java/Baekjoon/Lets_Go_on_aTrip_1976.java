import java.util.*;
import java.io.*;

public class Lets_Go_on_aTrip_1976 {
    static int N, M;
    static List<List<Integer>> Trip = new ArrayList<>();
    static int[] cities;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++)
            Trip.add(new ArrayList<>());

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int connected = Integer.parseInt(st.nextToken());
                if (connected == 1) {
                    Trip.get(i).add(j);
                }
            }
        }

//        for (int i = 0; i <= N; i++)
//            System.out.println(Arrays.toString(Trip.get(i).toArray()));

        cities = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag1 = true;
        for (int i = 0; i < M - 1; i++) {

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visit = new boolean[N + 1];
            boolean flag2 = false;
            // start
            queue.offer(cities[i]);
            while (!queue.isEmpty()) {
                int city = queue.poll();

                if (city == cities[i + 1]) {
                    flag2 = true;
                    break;
                }

                if (visit[city]) continue;
                visit[city] = true;

                for (int nei : Trip.get(city))
                    queue.offer(nei);
            }

            if (!flag2) {
                flag1 = false;
                break;
            }
        }

        if (flag1)
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}
