package PACKAGE_NAME;
import java.util.*;

class Lv4_Muzzis_Mukbang_Live {
    static class Food {
        int time, idx;
        private Food(int time, int idx) {
            this.time = time;
            this.idx = idx;
        }
    }

    public int solution(int[] food_times, long k) {
        int len = food_times.length;
        long total = 0;
        for (int food: food_times) total += food;

        if (total <= k)  return -1;

        // 시간 기준 오름차순 우선순위 큐
        PriorityQueue<Food> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        for (int i = 0; i < len; i ++)
            pq.offer(new Food(food_times[i], i + 1));

        long prev= 0;
        int leftFoods = len;
        while (! pq.isEmpty()) {
            leftFoods = pq.size();

            long cur = pq.peek().time;
            long eat = (cur - prev) * leftFoods;
            // k 처리 전 확인
            if (k < eat)    break;

            k -= eat;

            // 같은 시간이 남은 요소들 다 정리하기
            while (! pq.isEmpty() && pq.peek().time == cur) {
                pq.poll();
                leftFoods --;
            }

            prev = cur;
        }

        // 우선순위 큐에서 남은 요소 배열화 -> 인덱스 기준 정렬
        List<Food> remains = new ArrayList<>(pq);
        remains.sort(Comparator.comparingInt(a -> a.idx));

        return remains.get((int) (k % leftFoods)).idx;
    }
}