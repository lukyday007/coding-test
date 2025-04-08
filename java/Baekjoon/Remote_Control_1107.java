import java.util.*;
import java.io.*;

public class Remote_Control_1107 {
    static int TARGET, TARGET_LENGTH, N;
    static List<Integer> brokenButtons = new ArrayList<>();

    /*
        [ edge case 1 ] 숫자버튼이 0만 남아서 + 로만 이동
        10
        9
        1 2 3 4 5 6 7 8 9
        => 11
        [ edge case 2 ] 목표 채널보다 자릿수가 많은 채널에서 시작
        889
        9
        0 2 3 4 5 6 7 8 9
        => 226
        [ edge case 3 ] 고장난 버튼 없음
        101
        0
        => 1
        [ edge case 4 ] +/- 이동이 최소일 경우
        104
        0
        => 3
    */

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TARGET = Integer.parseInt(br.readLine());
        TARGET_LENGTH = String.valueOf(TARGET).length();
        N = Integer.parseInt(br.readLine());

        if (N != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                brokenButtons.add(Integer.parseInt(st.nextToken()));
        }

        int answer = Math.abs(TARGET - 100);

        if (N == 0) {
            answer = Math.min(answer, TARGET_LENGTH);
            System.out.println(answer);
            return;
        }

        for (int channel = 0; channel < 999999; channel ++) {
            String str = String.valueOf(channel);
            if (isValid(str)) {
                int cnt = str.length() + Math.abs(channel - TARGET);
                answer = Math.min(answer, cnt);
            }
        }
        System.out.println(answer);
    }

    private static boolean isValid (String str) {
        for (int i = 0; i < str.length(); i ++) {
            int digit = str.charAt(i) - '0';
            if (brokenButtons.contains(digit))
                return false;
        }
        return true;
    }
}