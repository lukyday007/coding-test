import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class N_Queen_2806 {
    static int N;
    static int ans = 0;
    static int[] leftDown;
    static int[] rightDown;
    static int[] row;

    public static void dfs(int n) {
        if (n == N) {
            ans ++;
            return;
        }

        for (int c = 0; c < N; c ++) {
            if (row[c] == 0 && rightDown[c - n + (N - 1)] == 0 && leftDown[c + n] == 0) {
                row[c] = 1;
                rightDown[c - n + (N - 1)] = 1;
                leftDown[c + n] = 1;

                dfs(n + 1);

                row[c] = 0;
                rightDown[c - n + (N - 1)] = 0;
                leftDown[c + n] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        leftDown = new int[2 * N];
        rightDown = new int[2 * N];
        row = new int[2 * N];

        dfs(0);
        System.out.println(ans);
    }
}
