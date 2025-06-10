package Programmers;
import java.util.*;

public class Lv2_H_index {

    /*
        - H-index 탐색: 일반적인 이진 탐색 (l <= r, mid ± 1)
        - Lower Bound: 특수한 경계 탐색 (l < r, r = mid)

        [way1] H-index 이진탐색 × getCntPaper = O(상수) × O(n) = O(n)
        [way2] H-index 이진탐색 × Lower Bound = O(log 최댓값) × O(log n)
    */

    public int solution1(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        // 논문별 인용 횟수 0회 이상 10,000회 이하
        int l = 0, r = 10000;
        int time = 0;
        while (l <= r) {

            int mid = (l + r) / 2;
            time = getCntPaper(mid, citations);

            if (time >= mid) {
                l = mid + 1;
                answer = Math.max(answer, mid);

            } else {
                r = mid - 1;
            }
        }
        return answer;
    }

    static int getCntPaper(int times, int[] citations) {
        int cnt = 0;
        for (int i = 0; i < citations.length; i ++) {
            if (citations[i] >= times)
                cnt ++;
        }
        System.out.println("mid: " + times + ", cnt: " + cnt);
        return cnt;
    }

    public int solution2(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        // 논문별 인용 횟수 0회 이상 10,000회 이하
        int l = 0, r = citations[citations.length - 1];;
        int idx = 0;
        while (l <= r) {

            int mid = (l + r) / 2;
            idx = getIdxPaper(mid, citations);
            int time = citations.length - idx;

            if (time >= mid) {
                l = mid + 1;
                answer = mid;

            } else {
                r = mid - 1;
            }
        }
        return answer;
    }

    static int getIdxPaper(int times, int[] citations) {

        int l = 0, r = citations.length;
        while (l < r) {

            int mid = (l + r) / 2;

            if (times > citations[mid])
                l = mid + 1;
            else
                r = mid;
        }
        // System.out.println("r : " + r + ", l : " + l );
        return l;
    }

}
