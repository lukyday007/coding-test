package Programmers;
import java.util.*;

public class Lv1_PE_Uniform {

    /*
        여벌의 체육복을 도난당할 케이스도 존재! -> 다른 학생에게 체육복 못 빌려줌
    */
    class Solution {

        public int solution(int n, int[] lost, int[] reserve) {

            Map<Integer, Boolean> map = new HashMap<>();
            for (int i = 0; i < reserve.length; i ++)
                map.putIfAbsent(reserve[i], false);

            List<Integer> lostList = new ArrayList<>();
            for (int i = 0; i < lost.length; i ++) {
                if (map.containsKey(lost[i])) {
                    map.remove(lost[i]);
                } else {
                    lostList.add(lost[i]);
                    n --;
                }
            }

            Collections.sort(lostList);
            for (int i = 0; i < lostList.size(); i ++) {
                int stu = lostList.get(i);

                if (map.containsKey(stu - 1) && ! map.get(stu - 1)) {
                    map.put(stu - 1, true);
                    n ++;
                } else if (map.containsKey(stu + 1) && ! map.get(stu + 1)) {
                    map.put(stu + 1, true);
                    n ++;
                }
            }

            return n;
        }
    }
}