import java.util.*;
import java.io.*;

public class Expression_of_Sets_1717 {
    static int[] parent, rank;
    static int N, M;

    // Union 연산: 여러 노드 중 두 노드를 선택하여 이들을 하나의 집합으로 연결한다. 이 연산을 통해 서로 연결된 노드들이 같은 집합에 속하게 된다.
    static void union(int n1, int n2) {
        int rootA = find(n1);
        int rootB = find(n2);
        if (rootA != rootB) {
            if (rank[rootA] != rank[rootB])
                parent[rootB] = rootA;
            else if (rank[rootA] < rank[rootB])
                parent[rootA] = rootB;
            else {
                parent[rootB] = rootA;
                rank[rootA] ++;
            }
        }
//        System.out.println("A : " + rootA + ", B : " + rootB);
//        System.out.println("parent: " + Arrays.toString(parent));
//        System.out.println("rank: " +Arrays.toString(rank));
//        System.out.println();
    }

    // Find 연산: 특정 노드의 대표 노드를 찾아낸다. 두 노드의 대표 노드를 찾아낸다면 해당 노드들이 같은 집합에 속해 있는지를 확인할 수 있다.
    static int find(int k) {
        if (parent[k] != k)
            parent[k] = find(parent[k]);

        return parent[k];
    }

    static boolean isConnected(int n1, int n2) {
        return find(n1) == find(n2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        rank = new int[N + 1];

        for (int i = 1; i <= N; i ++){
            parent[i] = i;  rank[i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (num == 0)
                union(a, b);
            else
                sb.append(isConnected(a, b) ? "YES\n" : "NO\n");
        }

        System.out.println(sb);
    }
}
