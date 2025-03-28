import java.util.*;
import java.io.*;

public class Water_bottle_2251 {
    static int oriA, oriB, oriC;
    static List<Integer> amounts = new ArrayList<>();
    static boolean[][][] check;

    /*
        처음에는 앞의 두 물통은 비어 있고, 세 번째 물통은 가득(C 리터) 차 있다
        어떤 물통에 들어있는 물을 다른 물통으로 쏟아 부을 수 있는데,
        이때에는 한 물통이 비거나, 다른 한 물통이 가득 찰 때까지 물을 부을 수 있다
        a 컵이 비어 있어야 함
        세 번째 물통(용량이 C인)에 담겨있을 수 있는 물의 양을 모두 구해내는 프로그램

        쓰여진 그대로 구현하기!
    */
    public static class Water {
        int a, b, c;
        public Water(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        oriA = Integer.parseInt(st.nextToken());
        oriB = Integer.parseInt(st.nextToken());
        oriC = Integer.parseInt(st.nextToken());

        check = new boolean[201][201][201];
        BFS(oriA, oriB, oriC);
        Collections.sort(amounts);
        for (int i = 0; i < amounts.size(); i ++)
            System.out.print(amounts.get(i) + " ");
    }

    public static void BFS(int A, int B, int C) {
        Queue<Water> queue = new LinkedList<>();
        queue.add(new Water(0, 0, C));

        while (! queue.isEmpty()) {
            Water water = queue.poll();
            int a = water.a, b = water.b, c = water.c;

            if (check[a][b][c]) continue;
            check[a][b][c] = true;

            if (a == 0)
                amounts.add(c);

            // a -> b
            if (a + b >= oriB)
                queue.add(new Water((a + b) - oriB, oriB, c));
            else
                queue.add(new Water(0, a + b, c));

            // a -> c
            if (a + c >= oriC)
                queue.add(new Water((a + c) - oriC, b, oriC));
            else
                queue.add(new Water(0, b, a + c));

            // b -> a
            if (b + a >= oriA)
                queue.add(new Water(oriA, (b + a) - oriA, c));
            else
                queue.add(new Water(b + a, 0, c));

            // b -> c
            if (b + c >= oriC)
                queue.add(new Water(a, (b + c) - oriC, oriC));
            else
                queue.add(new Water(a, 0, b + c));

            // c -> a
            if (c + a >= oriA)
                queue.add(new Water(oriA, b, (c + a) - oriA));
            else
                queue.add(new Water(c + a, b, 0));

            // c -> b
            if (c + b >= oriB)
                queue.add(new Water(a, oriB, (c + b) - oriB));
            else
                queue.add(new Water(a, 0, c + b));

        }
    }

}