import java.util.*;

public class Emoji_14226_dp {
    static int answer = Integer.MAX_VALUE;
    static int S;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        S = sc.nextInt();
        makingEmoji(1);
    }

    private static void makingEmoji (int emoji) {
        // visited[emoji][clip]
        int dp[][] = new int[2001][2001];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0, 0});  // emoji, clip, cnt
        dp[1][0] = 0;

        while (! queue.isEmpty()) {
            int[] state = queue.poll();
            int screen = state[0], clip = state[1], cnt = dp[screen][clip];

            if (screen == S) {
                System.out.println(cnt);
                return;
            }

            // copy all emoji
            if (screen <= 2000 && dp[screen][screen] == 0) {
                dp[screen][screen] = cnt + 1;
                queue.add(new int[] {screen, screen, cnt + 1});
            }
            // paste from clip
            if (screen + clip <= 2000 && dp[screen + clip][clip] == 0) {
                dp[screen + clip][clip] = cnt + 1;
                queue.add(new int[] {screen + clip, clip, cnt + 1});
            }
            // delete one emoji
            if (screen > 1  && dp[screen - 1][clip] == 0) {
                dp[screen - 1][clip] = cnt + 1;
                queue.add(new int[] {screen - 1, clip, cnt + 1});
            }
        }

    }
}
