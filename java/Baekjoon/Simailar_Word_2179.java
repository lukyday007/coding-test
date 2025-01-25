import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Simailar_Word_2179 {
    static int N;
    static String[] words;
    static String[] check;
    static String[] ans = new String[2];
    static HashMap<String, Integer> wordsMap = new HashMap<>();

    /*
    스택
    트라이
    해시
    가장 비슷한 두 단어를 구해내는 프로그램

    2 ≤ N ≤ 20,000, 길이 100자 이하
    */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];
        check = new String[N];

        for (int i = 0; i < N; i ++) {
            String word = br.readLine();
            words[i] = word;
            check[i] = word;
        }

        Arrays.sort(words);
//        System.out.println(Arrays.toString(words));

        for (int i = 1; i < N; i ++) {
            if (words[i-1].charAt(0) != (words[i].charAt(0)))
                continue;

            int beforeL = words[i-1].length();
            int afterL = words[i].length();
            int prefix = 0;
            int minLen = Math.min(beforeL, afterL);
            for (int j = 0; j < minLen; j++) {
                if (words[i - 1].charAt(j) == words[i].charAt(j))
                    prefix++;
                else
                    break;
            }

            String key = words[i-1].substring(0, prefix);
            if (! wordsMap.containsKey(key)) {
                wordsMap.put(key, prefix);
            } else {
                int tmpIdx = wordsMap.get(key);
                if (prefix > tmpIdx)
                    wordsMap.put(key, prefix);
            }
        }

        int maxPrefixLength = 0;
        for (String word: wordsMap.keySet()) {
//            System.out.println(String.format("word: %s, wordMap val: %d", word, wordsMap.get(word)));
            int length = wordsMap.get(word);
            if (length > maxPrefixLength)
                maxPrefixLength = length;
        }

        int idx = 0;
        boolean flag = false;
        String prefixStr = "";
        for (int i = 0; i < N; i++) {
            if (idx == 2)
                break;

            if (prefixStr.equals("") && check[i].length() >= maxPrefixLength && wordsMap.containsKey(check[i].substring(0, maxPrefixLength))) {
                prefixStr = check[i].substring(0, maxPrefixLength);
                ans[idx] = check[i];
                idx ++;
                flag = true;
                continue;
            }
            if (check[i].length() >= maxPrefixLength && check[i].substring(0, maxPrefixLength).equals(prefixStr)) {
                ans[idx] = check[i];
                idx ++;
            }
        }

        for (String a: ans) {
            System.out.println(a);
        }
    }
}
