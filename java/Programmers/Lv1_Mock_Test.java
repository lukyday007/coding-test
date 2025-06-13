package Programmers;
import java.util.*;

public class Lv1_Mock_Test {

    class Solution {
        public int[] solution(int[] answers) {
            int[] one = {1,2,3,4,5};
            int[] two = {2,1,2,3,2,4,2,5};
            int[] three = {3,3,1,1,2,2,4,4,5,5};

            int p1 = 0, p2 = 0, p3 = 0;

            for (int i = 0; i < answers.length; i++) {
                int ans = answers[i];
                if (one[i % one.length] == ans) p1++;
                if (two[i % two.length] == ans) p2++;
                if (three[i % three.length] == ans) p3++;
            }

            int maxVal = Math.max(p1, Math.max(p2, p3));

            List<Integer> list = new ArrayList<>();
            if (p1 == maxVal) list.add(1);
            if (p2 == maxVal) list.add(2);
            if (p3 == maxVal) list.add(3);

            return list.stream().mapToInt(i -> i).toArray();
        }
    }
}