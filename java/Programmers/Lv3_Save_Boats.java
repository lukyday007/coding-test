package Programmers;
import java.util.*;

public class Lv3_Save_Boats {
    class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);

            // 한 배에 인원 수 2명으로 제한
            // 무거운 사람부터 태우기
            int light = 0;
            int heavy = people.length - 1;

            while (light <= heavy) {
                if (people[light] + people[heavy] <= limit) {
                    light ++;
                }
                heavy --;
                answer++;
            }

            return answer;
        }
    }
}