import java.util.*;
import java.io.*;

public class Pairing_Numbers_1744 {

    /*
    [반례]
    4
    -1
    -1
    0
    2
        [ conditions ]
        1. 1은 무조건 따로 더하기
        2. 양수 (desc) 는 큰 수끼리 묶기
        3. 음수 (asc) 는 작은 수끼리 묶기 + 홀수 개면 0 활용해 하나 제거
    */

    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        int total = 0;  // 1 개수 부터 먼저 추가
        int zero = 0;
        for (int i = 0; i < N; i ++) {
            int tmp = sc.nextInt();
            if (tmp == 1) {
                total++;
                continue;
            }
            if (tmp > 0)
                positive.add(tmp);
            else if (tmp < 0)
                negative.add(tmp);
            else
                zero ++;
        }

        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative);
        while (zero > 0 &&  negative.size() > 0 && negative.size() % 2 != 0) {
            negative.remove(negative.size() - 1);
            zero --;
        }

        int posIdx = 0;
        while (positive.size() > 0 && posIdx < positive.size() - 1) {
            int addParing = positive.get(posIdx);
            int mulParing = positive.get(posIdx) * positive.get(posIdx + 1);
            if (addParing > mulParing ) {
                total += addParing;
                posIdx += 1;
            } else {
                total += mulParing;
                posIdx += 2;
            }
        }

        if (posIdx == positive.size() - 1) {
            total += positive.get(positive.size()-1);
        }

        int negIdx = 0;
        while (negative.size() > 0 && negIdx < negative.size() - 1) {
            int addParing = negative.get(negIdx);
            int mulParing = negative.get(negIdx) * negative.get(negIdx + 1);
            if (addParing > mulParing ) {
                total += addParing;
                negIdx += 1;
            } else {
                total += mulParing;
                negIdx += 2;
            }
        }

        if (negIdx == negative.size() - 1) {
            total += negative.get(negative.size() - 1);
        }

        System.out.println(total);
    }
}