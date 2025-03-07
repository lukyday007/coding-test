import java.util.*;
import java.io.*;

public class Gerrymandering_17471_Union_find {

    /*
        [error1] : 유니온 파인드 잘못 이해
        [error2] : 조합 다시 공부
    */

    static int N;
    static int[] cityPopulation, parent;
    static boolean[] visited;
    static int minVal = Integer.MAX_VALUE;
    static List<List<Integer>> graph = new ArrayList<>();

    static void initUnionFind(int N) {
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    static void union(int n1, int n2) {
        int a = find(n1);
        int b = find(n2);
        if (a > b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    static int find(int k) {
        if (parent[k] != k)
            parent[k] = find(parent[k]);
        return parent[k];
    }

    static boolean isConnected(List<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            if (find(arr.get(i)) != find(arr.get(i + 1))) return false;
        }
        return true;
    }

    static List<Integer> isPossible(List<Integer> group1) {
        List<Integer> group2 = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (!group1.contains(i))
                group2.add(i);
        }

        initUnionFind(N);

        // group1의 연결
        for (int i : group1) {
            for (int j : graph.get(i)) {
                if (group1.contains(j))
                    union(i, j);
            }
        }

        // group2의 연결
        for (int i : group2) {
            for (int j : graph.get(i)) {
                if (group2.contains(j))
                    union(i, j);
            }
        }

        boolean flag1 = isConnected(group1);
        boolean flag2 = isConnected(group2);

        if (!flag1 || !flag2)
            return new ArrayList<>();

        return group2;
    }

    static void calculateMinDifference(List<Integer> group1, List<Integer> group2) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i : group1) {
            sum1 += cityPopulation[i];
        }

        for (int i : group2) {
            sum2 += cityPopulation[i];
        }

        minVal = Math.min(minVal, Math.abs(sum1 - sum2));
    }

    static void dfs(int start, List<Integer> arr) {
        if (arr.size() == N) return;

        if (arr.size() > 0 && arr.size() < N) {
            List<Integer> group2 = isPossible(arr);
            if (!group2.isEmpty()) {
                calculateMinDifference(arr, group2);
            }
        }

        for (int i = start; i <= N; i++) {
            arr.add(i);
            dfs(i + 1, arr);
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cityPopulation = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cityPopulation[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int city = Integer.parseInt(st.nextToken());
            for (int j = 0; j < city; j++) {
                int neighbor = Integer.parseInt(st.nextToken());
                graph.get(i).add(neighbor);
            }
        }

        dfs(1, new ArrayList<>());

        if (minVal == Integer.MAX_VALUE) {
            System.out.println(-1);  // 두 선거구로 나눌 수 없는 경우
        } else {
            System.out.println(minVal);  // 최소 인구 차이 출력
        }
    }
}