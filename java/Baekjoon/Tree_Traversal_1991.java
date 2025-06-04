import java.util.*;
import java.io.*;

public class Tree_Traversal_1991 {
    static int N;
    static Character[][] Graph = new Character[26][2];
    static boolean[] visited = new boolean[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Graph = new Character[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            Graph[root - 'A'][0] = (l == '.') ? null : l;
            Graph[root - 'A'][1] = (r == '.') ? null : r;
        }

        preorder('A');
        System.out.println();
        inorder('A');
        System.out.println();
        postorder('A');
    }

    static void preorder(char node) {
        if (node == '.') return;
        System.out.print(node);
        if (Graph[node - 'A'][0] != null) preorder(Graph[node - 'A'][0]);
        if (Graph[node - 'A'][1] != null) preorder(Graph[node - 'A'][1]);
    }

    static void inorder(char node) {
        if (node == '.') return;
        if (Graph[node - 'A'][0] != null) inorder(Graph[node - 'A'][0]);
        System.out.print(node);
        if (Graph[node - 'A'][1] != null) inorder(Graph[node - 'A'][1]);
    }

    static void postorder(char node) {
        if (node == '.') return;
        if (Graph[node - 'A'][0] != null) postorder(Graph[node - 'A'][0]);
        if (Graph[node - 'A'][1] != null) postorder(Graph[node - 'A'][1]);
        System.out.print(node);
    }
}