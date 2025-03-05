import java.util.*;
import java.io.*;

public class Minimum_Spanning_Tree_1197_kruskalMST {
    static int V, E;
    static int[] parent;
    static List<int[]> edges;

    static void initUnionFind(int V) {
        parent = new int[V + 1];
        for (int i = 1; i <= V; i ++)
            parent[i] = i;
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

    static boolean isConnected(int n1, int n2) {
        return find(n1) == find(n2);
    }

    static int kruskalMST() {
        int minCost = 0, cnt = 0;
        Collections.sort(edges, Comparator.comparingInt(o -> o[0]));
        for (int[] edge : edges) {
            int cost = edge[0];
            int a = edge[1];
            int b = edge[2];

            if (find(a) != find(b)) {
                union(a, b);
                minCost += cost;
                cnt ++;
                if (cnt == V - 1) break;
            }
        }
        return minCost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        initUnionFind(V);
        edges = new ArrayList<>();

        for (int i = 0; i < E; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new int[]{cost, a, b});
        }

        System.out.println(kruskalMST());
//        System.out.println(isConnected(1, V));

    }
}
