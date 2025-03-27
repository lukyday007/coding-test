import java.util.*;
import java.io.*;

public class Double_Ended_Priority_Queue_7662 {
    static int T, N;
    /*
        일련의 연산이 주어질 때 이를 처리한 후 최종적으로 Q에 저장된 데이터 중 최댓값과 최솟값을 출력하는 프로그램

        우선순위 큐에 계속 값이 남아있는 이유
        => HashMap의 값이 0이하일 때의 무효값이 정리되지 않은 상태로 남아있음 -> while문으로 정리

1
3
I 5
D -1
I 4
        answer 4 4
        output 5 4
    */
    static HashMap<Integer, Integer> numberMap;
    public static void main(String[] args) throws IOException {

        /*
        동일한 정수가 삽입될 수 있음
        ‘D 1’는 Q에서 최댓값을 삭제하는 연산
        ‘D -1’는 Q 에서 최솟값을 삭제하는 연산
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int j = 0; j < T; j++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            numberMap = new HashMap<>();
            PriorityQueue<Integer> ase = new PriorityQueue<>();
            PriorityQueue<Integer> desc = new PriorityQueue<>(Comparator.reverseOrder());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (order.equals("I")) {
                    numberMap.put(num, numberMap.getOrDefault(num, 0) + 1);
                    ase.offer(num);
                    desc.offer(num);
                } else {
                    if (numberMap.isEmpty()) continue;

                    if (num < 0) { // D -1: 최솟값 삭제
                        removeValid(ase);
                    } else {       // D 1: 최댓값 삭제
                        removeValid(desc);
                    }
                }
            }

//            System.out.println(Arrays.toString(ase.toArray()));
//            System.out.println(Arrays.toString(desc.toArray()));

            if (numberMap.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                while (!desc.isEmpty()) {
                    int tmp = desc.peek();
                    if (!numberMap.containsKey(tmp))
                        desc.poll();
                    else
                        break;
                }
                while (!ase.isEmpty()) {
                    int tmp = ase.peek();
                    if (!numberMap.containsKey(tmp))
                        ase.poll();
                    else
                        break;
                }
                System.out.println(desc.peek() + " " + ase.peek());
            }
        }
    }

    static void removeValid(PriorityQueue<Integer> pq) {
//        System.out.println("before pq : " + Arrays.toString(pq.toArray()));
        while (!pq.isEmpty()) {
            int val = pq.peek();
            if (numberMap.containsKey(val) && numberMap.get(val) > 0) {
                numberMap.put(val, numberMap.get(val) - 1);
                if (numberMap.get(val) == 0) {
                    numberMap.remove(val);
                }
                pq.poll();
                break;
            } else {
                pq.poll(); // 무효값 정리
            }
        }
//        System.out.println("after pq : " + Arrays.toString(pq.toArray()));
    }
}
