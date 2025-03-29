import java.util.*;
import java.io.*;

public class Snake_3190 {
    static int N, K, L;
    static HashMap<Integer, String> directions = new HashMap<>();
    static HashSet<Point> apples = new HashSet<>();
    static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};

    public static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "(" + r + ", " + c + ")";
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (! (o instanceof Point)) return false;
            Point p = (Point) o;
            return r == p.r && c == p.c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1, c = Integer.parseInt(st.nextToken()) - 1;
            apples.add(new Point(r, c));
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            directions.put(time, dir);
        }

        int result = startGame();
        System.out.println(result);
    }

    public static int startGame() {
        Deque<Point> dq = new ArrayDeque<>();
        dq.offer(new Point(0, 0));
        int time = 0;
        int dir = 0;

        while (! dq.isEmpty()) {
            Point point = dq.peek();
            int cr = point.r, cc = point.c;

//            System.out.println("snake body " + dq.size());
//            for (Point pt : dq)
//                System.out.println(" r : " + pt.r + ", c : " + pt.c);

            // 벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다.
            if (directions.containsKey(time)) {
                String cmd = directions.get(time);
//                System.out.println("changed " + cmd);
                if (cmd.equals("D"))
                    dir = (dir + 1) % 4;
                else
                    dir = (dir - 1 + 4) % 4;
            }
//            System.out.println();

            int nr = cr + dr[dir], nc = cc + dc[dir];
            time ++;
//            System.out.print("time : " + time + ", dir: " + dir);
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) break;
            if (dq.contains(new Point(nr, nc))) break;

//            System.out.println(" , nr : " + nr + " , nc : " + nc);
            if (apples.contains(new Point(nr, nc))) {
                dq.addFirst(new Point(nr, nc));
                apples.remove(new Point(nr, nc));
            } else {
                dq.pollLast();  // tail
                dq.addFirst(new Point(nr, nc));
            }
//            System.out.println();
        }
//        System.out.println();
        return time;
    }

}