import java.util.*;

public class Emoji_14226_BFS {
    static int answer = Integer.MAX_VALUE;
    static int S;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        S = sc.nextInt();
        makingEmoji(1);
    }

    private static void makingEmoji (int emoji) {
        // visited[emoji][clip]
        boolean visited[][] = new boolean[2001][2001];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0, 0});  // emoji, clip, cnt
        visited[1][0] = true;

        while (! queue.isEmpty()) {
            int[] state = queue.poll();
            int screen = state[0], clip = state[1], cnt = state[2];

            if (screen == S) {
                answer = cnt;
                System.out.println(cnt);
                return;
            }

            // copy all emoji
            if (screen <= 2000 && ! visited[screen][screen]) {
                visited[screen][screen] = true;
                queue.add(new int[] {screen, screen, cnt + 1});
            }
            // paste from clip
            if (screen + clip <= 2000 && ! visited[screen + clip][clip]) {
                visited[screen + clip][clip] = true;
                queue.add(new int[] {screen + clip, clip, cnt + 1});
            }
            // delete one emoji
            if (screen > 1  && ! visited[screen - 1][clip]) {
                visited[screen - 1][clip] = true;
                queue.add(new int[] {screen - 1, clip, cnt + 1});
            }
        }

    }
}