import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Print_clearly_Swirl_1022_ver2  {

    static final int SIZE = 10001;  // 10001×10001
    static final int OFFSET = 5000; // 중심 좌표 (5000,5000)
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};
    static Map<String, Integer> board = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt() + OFFSET;
        int c1 = sc.nextInt() + OFFSET;
        int r2 = sc.nextInt() + OFFSET;
        int c2 = sc.nextInt() + OFFSET;
        sc.close();

        fillSpiral(r1, c1, r2, c2);
        printSelectedRegion(r1, c1, r2, c2);
    }

    // HashMap을 사용
    static void fillSpiral(int r1, int c1, int r2, int c2) {
        int sr = OFFSET, sc = OFFSET; // 중심 (5000,5000)
        int num = 1, max = 1, dir = 0;

        board.put(sr + "," + sc, num);

        while (num < SIZE * SIZE) {
            for (int rep = 0; rep < 2; rep++) {
                for (int i = 0; i < max; i++) {
                    sr += dr[dir];
                    sc += dc[dir];

                    if (sr >= r1 && sr <= r2 && sc >= c1 && sc <= c2) {
                        board.put(sr + "," + sc, ++num);
                    } else {
                        num++;
                    }
                }
                dir = (dir + 1) % 4;
            }
            max++;
        }
    }

    // 범위만 출력
    static void printSelectedRegion(int r1, int c1, int r2, int c2) {
        int maxVal = 0;
        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                String key = r + "," + c;
                if (board.containsKey(key)) {
                    maxVal = Math.max(maxVal, board.get(key));
                }
            }
        }

        int maxLen = String.valueOf(maxVal).length();  // 출력 정렬을 위한 자리수 계산
        StringBuilder sb = new StringBuilder();

        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                String key = r + "," + c;
                if (board.containsKey(key)) {
                    sb.append(String.format("%" + maxLen + "d ", board.get(key)));
                } else {
                    sb.append(String.format("%" + maxLen + "d ", 0));
                }
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());  // 한 번에 출력 (속도 최적화)
    }
}

