import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class View_1206 {    // 0.11847s
    static final int TEST = 10;
    static final int[] RANGE = {-2, -1, 1, 2};  // 양쪽 모두 2의 공간 확보

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t < TEST + 1; t ++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[n];
            int ans = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 2; i < n - 2; i++) {
                int max = 0;
                for (int j = 0; j < RANGE.length; j++) {
                    if (arr[i + RANGE[j]] > max)
                        max = arr[i + RANGE[j]];
                }

                if (arr[i] > max)
                    ans += (arr[i] - max);
            }
            sb.append("#" + t + " " + ans + "\n");
        }
        System.out.println(sb);
    }
}