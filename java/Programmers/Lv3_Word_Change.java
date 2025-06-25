package Programmers;
import java.util.*;

public class Lv3_Word_Change {

    class Solution_bfs {

        class Word {
            String word; int cnt;

            Word(String word, int cnt) {
                this.word = word;
                this.cnt = cnt;
            }
        }

        public int solution(String begin, String target, String[] words) {
            int answer = 0;

            Queue<Word> queue = new LinkedList<>();
            boolean[] visited = new boolean[words.length];
            queue.offer(new Word(begin, 0));

            while (! queue.isEmpty()) {
                Word w = queue.poll();
                String word = w.word;
                int cnt = w.cnt;

                if (word.equals(target))
                    return cnt;

                for (int i = 0; i < words.length; i ++) {
                    if (visited[i])  continue;

                    if (check(word, words[i])) {
                        visited[i] = true;
                        queue.offer(new Word(words[i], cnt + 1));
                    }
                }
            }

            return answer;
        }

        private boolean check(String word, String candidate) {
            int cnt = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != candidate.charAt(i)) {
                    cnt++;
                }
            }
            return cnt == 1; // 알파벳 한 개만 다른 경우
        }
    }
}