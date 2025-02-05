package PACKAGE_NAME;
import java.util.*;

public class Lv3_Star_Array {
    public int solution(int[] a) {
        if (a.length < 2) return 0;

        HashMap<Integer, Integer> countNums = new HashMap<>();

        for (int num : a) {
            countNums.put(num, countNums.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;

        for (int key : countNums.keySet()) {
            // 최댓값 갱신 불가능 -> 패스
            if (maxLength >= countNums.get(key) * 2) continue;

            int count = 0;
            int idx = 0;

            while (idx < a.length - 1) {

                System.out.printf("idx: %d, a[idx]: %d, a[idx+1]: %d, key: %d, ",
                        idx, a[idx], a[idx + 1], key);
                boolean condition = (a[idx] == key || a[idx + 1] == key) && (a[idx] != a[idx + 1]);
                System.out.println("조건 만족: " + condition);

                if (condition) {
                    count += 2;
                    idx += 2;  // 유효한 쌍을 찾았으므로 2칸 이동
                } else {
                    idx++;  // 유효한 쌍이 아니면 한 칸 이동
                }
            }

            maxLength = Math.max(maxLength, count);
        }

        return maxLength;
    }

}
