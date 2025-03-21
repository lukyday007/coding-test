import java.util.*;
import java.io.*;

public class Tree_1068 {
    static int N, removeNode, topNode;
    static int[] tree;
    static List<List<Integer>> Graph = new ArrayList<>();

    public static class Node {
        int node; boolean isEnd;
        public Node(int node, boolean isEnd) {
            this.node = node;
            this.isEnd = isEnd;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) {
            tree[i] = Integer.parseInt(st.nextToken());
            Graph.add(new ArrayList<>());
        }
        removeNode = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i ++) {
            if (tree[i] == -1) {
                topNode = i;
                continue;
            } else if (i == removeNode) {
                continue;
            }
            Graph.get(tree[i]).add(i);
        }

//        for (int i = 0; i < N; i ++)
//            System.out.println(Arrays.toString(Graph.get(i).toArray()));

        int cnt = 0;

        if (topNode == removeNode)  // 맨 윗 노드에서 자를 때 주의
            System.out.println(cnt);

        else {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(topNode);
            while (!queue.isEmpty()) {
                int curNode = queue.poll();

                if (Graph.get(curNode).isEmpty()) {
//                    System.out.println("empty");
                    cnt ++;
                }
                else {
                    for (int node : Graph.get(curNode)) {
//                        System.out.println(node);
                        queue.offer(node);
                    }
                }
            }

            System.out.println(cnt);
        }
    }
}
