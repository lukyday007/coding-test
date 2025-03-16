import java.util.*;
import java.io.*;

public class New_Employee_1946 {
    static int T, N;

    /*
        서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다는 원칙

        [optimization] 314096kb, 2844ms ->  301364kb, 808ms
        배열 하나로 처리! -> 서류 등수로 인덱싱
     */

//    public static class Applicant {
//        int document, interview;
//        public Applicant(int document, int interview) {
//            this.document = document;
//            this.interview = interview;
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i ++) {
            N = Integer.parseInt(br.readLine());
//            Applicant[] applicants = new Applicant[N];
            int[] interviewRank = new int[N + 1];
            for (int j = 0; j < N; j ++) {
                st = new StringTokenizer(br.readLine());
                interviewRank[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

//            Arrays.sort(applicants, (a, b) -> a.document - b.document);

            int answer = 1;
//            int pivot = applicants[0].interview;
            int pivot = interviewRank[1];
            for (int k = 2; k <= N; k ++) {
                // 서류 1등의 면접 접수보다 높으면
                if (pivot > interviewRank[k]) {
                    pivot = interviewRank[k];
                    answer ++;
                }
            }

            System.out.println(answer);
        }
    }
}