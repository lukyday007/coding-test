import java.io.*;
import java.util.*;

public class Descent_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dpMax = new int[3];
        int[] dpMin = new int[3];

        StringTokenizer st;
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];

            for (int j = 0; j < 3; j ++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            if (i == 0) {
                for (int j = 0; j < 3; j ++) {
                    dpMax[j] = arr[j];
                    dpMin[j] = arr[j];
                }
                continue;
            }

            int prevMax0 = dpMax[0], prevMax1 = dpMax[1], prevMax2 = dpMax[2];
            int prevMin0 = dpMin[0], prevMin1 = dpMin[1], prevMin2 = dpMin[2];

            dpMax[0] = arr[0] + Math.max(prevMax0, prevMax1);
            dpMax[1] = arr[1] + Math.max(Math.max(prevMax0, prevMax1), prevMax2);
            dpMax[2] = arr[2] + Math.max(prevMax1, prevMax2);

            dpMin[0] = arr[0] + Math.min(prevMin0, prevMin1);
            dpMin[1] = arr[1] + Math.min(Math.min(prevMin0, prevMin1), prevMin2);
            dpMin[2] = arr[2] + Math.min(prevMin1, prevMin2);
        }

        int max = Math.max(Math.max(dpMax[0], dpMax[1]), dpMax[2]);
        int min = Math.min(Math.min(dpMin[0], dpMin[1]), dpMin[2]);
        System.out.println(max + " " + min);
    }
}
