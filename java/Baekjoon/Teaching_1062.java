import java.util.*;
import java.io.*;

public class Teaching_1062 {
    static int N, K;
    static String[] words;
    static boolean[] usedChars = new boolean[26];
    static int answer = Integer.MIN_VALUE;

    /*
        치킨치킨치킨과 매우 비슷한 접근
        사람 수 기준조합을 구하는게 아닌, 브랜드 기준 조합을 구했듯이,

        여기서도 단어 N (최대 50) 개의 조합을 구하는 것 보다
        O(N) -> 최대 2^50
        알파벳 26 - 5 기준 조합을 구하는 것이 훨씬 시간 복잡도가 작음
        O(N) -> 최대 2^21
    */

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        words = new String[N];
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i ++)
            words[i] = br.readLine();


//        System.out.println(Arrays.toString(words));

        if (K < 5) {
            System.out.println(0);
            return;
        }

        usedChars['a' - 'a'] = true;
        usedChars['n' - 'a'] = true;
        usedChars['t' - 'a'] = true;
        usedChars['i' - 'a'] = true;
        usedChars['c' - 'a'] = true;

        backtracking(0, 0);
        System.out.println(answer);
    }

    private static void backtracking (int depth, int idx) {
        if (depth == K - 5) {
            int cnt = 0;
            for (String word : words) {
                if (canRead(word))
                    cnt ++;
            }
            answer = Math.max(answer, cnt);
            return;
        }

        for (int i = idx; i < 26; i ++) {
            if (usedChars[i])   continue;
            usedChars[i] = true;
            backtracking(depth + 1, i + 1);
            usedChars[i] = false;
        }
    }

    private static boolean canRead (String word) {
        for (int i = 0; i < word.length(); i ++) {
            if (! usedChars[word.charAt(i) - 'a'])
                return false;
        }
        return true;
    }

}