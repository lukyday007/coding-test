import java.io.*;

public class Palindrome_17609 {
    static int N;
    static int[] answer;

    public static boolean afterDelete(int sta, int end, String word) {
        while (sta < end) {
            if (word.charAt(sta) == word.charAt(end)) {
//                System.out.println("word: " + word + ", sta: " + sta + " - char : " + word.charAt(sta) +  ", end: " + end+ " - char : " + word.charAt(end));
                sta ++; end --;
            } else {
                return false;
            }
        }
        return true;
    }

    public static int checkWord(String word) {
        int left = 1, right = 1;
        // 회문인지  0, 유사 회문인지  1, 둘 모두 해당되지 않는지  2
        int sta = 0;
        int end = word.length() - 1;
        boolean leftRes = false;
        boolean rightRes = false;

        while (sta < end) {
            if (word.charAt(sta) == word.charAt(end)) {
//                System.out.println("word: " + word + ", sta: " + sta + " - char : " + word.charAt(sta) +  ", end: " + end+ " - char : " + word.charAt(end));
                sta ++; end --;
            } else {    // abxxbxa
                if (word.charAt(sta + 1) == word.charAt(end)) { // 왼쪽에서 삭제
                    if (left > 0)   left --;
                    else return 2;

//                    System.out.println("word: " + word + ", sta: " + sta + " - char : " + word.charAt(sta + 1) +  ", end: " + end+ " - char : " + word.charAt(end) + " : 왼쪽");

                    leftRes = afterDelete(sta + 1, end , word);

                }

                if (word.charAt(sta) == word.charAt(end - 1)) {    // 오른쪽에서 삭제
                    if (right > 0)   right --;
                    else return 2;

//                    System.out.println("word: " + word + ", sta: " + sta + " - char : " + word.charAt(sta) +  ", end: " + end+ " - char : " + word.charAt(end - 1) + " : 오른쪽");

                    rightRes = afterDelete(sta, end - 1, word);
                }

                if (rightRes || leftRes)
                    return 1;

                if (word.charAt(sta + 1) != word.charAt(end) || word.charAt(sta) == word.charAt(end - 1)) {
                    return 2;
                }
            }

        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new int[N];

        for (int i = 0; i < N; i ++) {
            String word = br.readLine();
            int res = checkWord(word);
            answer[i] = res;
        }

        for (int i = 0; i < N ; i ++ )
            System.out.println(answer[i]);
    }
}