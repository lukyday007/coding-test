package Programmers;
import java.util.*;

public class Lv3_Double_PriorityQueue {

    class Solution {
        public int[] solution(String[] operations) {
            PriorityQueue<Integer> asc = new PriorityQueue<>();
            PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder());
            Set<Integer> set = new HashSet<>();

            for (String op : operations) {
                String[] input = op.split(" ");
                String command = input[0];
                int num = Integer.parseInt(input[1]);

                if (command.equals("I")) {
                    asc.offer(num);
                    desc.offer(num);
                    set.add(num);
                } else if (command.equals("D")) {
                    if (set.isEmpty()) continue;

                    if (num == 1) {
                        // 최대값 삭제
                        while (!desc.isEmpty() && !set.contains(desc.peek())) {
                            desc.poll(); // 쓰레기 제거
                        }
                        if (!desc.isEmpty()) {
                            int max = desc.poll();
                            set.remove(max);
                        }
                    } else if (num == -1) {
                        // 최소값 삭제
                        while (!asc.isEmpty() && !set.contains(asc.peek())) {
                            asc.poll(); // 쓰레기 제거
                        }
                        if (!asc.isEmpty()) {
                            int min = asc.poll();
                            set.remove(min);
                        }
                    }
                }
            }

            // 마지막 쓰레기 정리
            while (!asc.isEmpty() && !set.contains(asc.peek())) {
                asc.poll();
            }
            while (!desc.isEmpty() && !set.contains(desc.peek())) {
                desc.poll();
            }

            if (set.isEmpty()) {
                return new int[]{0, 0};
            } else {
                return new int[]{desc.peek(), asc.peek()};
            }
        }
    }
}