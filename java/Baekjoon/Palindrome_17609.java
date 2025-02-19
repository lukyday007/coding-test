import java.io.*;

public class Palindrome_17609 {

    public static boolean isPalindromeAfterDeletion(int start, int end, String word) {
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static int checkWord(String word) {
        int start = 0, end = word.length() - 1;

        while (start < end) {
            if (word.charAt(start) == word.charAt(end)) {
                start++;
                end--;
            } else {
                boolean leftCheck = isPalindromeAfterDeletion(start + 1, end, word);
                boolean rightCheck = isPalindromeAfterDeletion(start, end - 1, word);
                return (leftCheck || rightCheck) ? 1 : 2;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(checkWord(br.readLine())).append("\n");
        }

        System.out.print(sb);
    }
}