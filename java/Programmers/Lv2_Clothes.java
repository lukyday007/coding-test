package Programmers;
import java.util.*;

public class Lv2_Clothes {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] item : clothes) {
            String type = item[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        int answer = 1;
        for (int count : map.values()) {
            answer *= (count + 1);  // 해당 종류를 입지 않는 경우 포함 ( + 1 )
        }

        return answer - 1;  // 아무 것도 안 입는 경우 제외
    }
}