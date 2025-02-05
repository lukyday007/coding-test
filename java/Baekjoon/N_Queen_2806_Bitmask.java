import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen_2806_Bitmask {
    static int N, allBits;

    public static int dfs(int row, int ld, int rd) {
        if (row == allBits) return 1; // 모든 행에 퀸을 배치 완료

        int count = 0;
        int possiblePositions = allBits & ~(row | ld | rd); // 놓을 수 있는 위치

        while (possiblePositions != 0) {
            int bit = possiblePositions & -possiblePositions; // 가장 오른쪽 1 비트 선택
            possiblePositions -= bit; // 해당 위치 사용 처리

            count += dfs(row | bit, (ld | bit) << 1, (rd | bit) >> 1);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        allBits = (1 << N) - 1; // N비트 모두 1로 설정

        System.out.println(dfs(0, 0, 0)); // 초기 상태에서 시작
    }
}
