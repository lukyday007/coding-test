package Programmers;
import java.util.*;

public class Lv3_Best_Album {

    class Solution {
        static class Song {
            String genre; int total;
            Song(String genre, int total) {
                this.genre = genre;
                this.total = total;
            }
        }

        public int[] solution(String[] genres, int[] plays) {
            List<Integer> answer = new ArrayList<>();
            Map<String, List<Integer>> genreMap = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                genreMap.putIfAbsent(genres[i], new ArrayList<>());
                genreMap.get(genres[i]).add(i);  // index 저장
            }

            PriorityQueue<Song> pq = new PriorityQueue<>((a, b) -> b.total - a.total);

            for (Map.Entry<String, List<Integer>> entry : genreMap.entrySet()) {
                String genre = entry.getKey();
                List<Integer> list = entry.getValue();
                //  장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
                Collections.sort(list, (a, b) -> plays[b] - plays[a]);

                int sum = 0;
                for (int i = 0; i < list.size(); i++) {
                    sum += plays[list.get(i)];
                }

                pq.offer(new Song(genre, sum));
            }


            int idx = 0;

            while (! pq.isEmpty()) {
                //  속한 노래가 많이 재생된 장르를 먼저 수록합니다.
                Song song = pq.poll();
                String genre = song.genre;
                int total = song.total;

                int limit = 2;
                //  장르 내에서 많이 재생된 노래를 먼저 수록합니다.
                for (int i = 0; i < genreMap.get(genre).size(); i ++) {
                    if (limit-- > 0)
                        answer.add(genreMap.get(genre).get(i));
                    else
                        break;
                }
            }

            return answer.stream().mapToInt(i -> i).toArray();
        }
    }
}