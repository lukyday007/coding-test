package Programmers;
import java.util.*;

public class Lv3_Disk_Controller {

    static class Process implements Comparable<Process> {
        int seq, req, time; // 작업번호, 요청시간, 처리시간
        private Process(int seq, int req, int time) {
            this.seq = seq;
            this.req = req;
            this.time = time;
        }

        @Override
        public int compareTo(Process p) {
            // 처리시간 짧은 순
            if (this.time != p.time)
                return Integer.compare(this.time, p.time);
            // 요청시간 빠른 순
            if (this.req != p.req)
                return Integer.compare(this.req, p.req);
            // 작업번호 빠른 순
            return Integer.compare(this.seq, p.seq);
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        List<Process> jobList = new ArrayList<>();

        for (int i = 0; i < jobs.length; i ++)
            jobList.add(new Process(i, jobs[i][0], jobs[i][1]));

        jobList.sort((a, b) -> {
            if (a.req != b.req) return Integer.compare(a.req, b.req);      // 요청시간
            if (a.time != b.time) return Integer.compare(a.time, b.time);  // 처리시간
            return Integer.compare(a.seq, b.seq);                          // 작업번호
        });

        PriorityQueue<Process> waiting = new PriorityQueue<>();

        int current = 0, idx = 0, pqCnt = 0;
        while (pqCnt < jobList.size()) {

            // 현재시간까지 도착한 작업만 우선순위 큐에 넣기
            // idx로 인한 인덱스에러 방지
            while (idx < jobList.size() && jobList.get(idx).req <= current) {
                waiting.offer(jobList.get(idx));
                idx ++;
            }

            if (! waiting.isEmpty()) {
                Process p = waiting.poll();
                current = Math.max(current, p.req);  // 현재시간과 요청시간 비교 후 큰 수치 반환
                answer += (current + p.time - p.req);
                current += p.time;
                pqCnt ++;

            } else {
                // 대기 큐 비어있을 때 -> 작업 리스트에서 요청시간 빠른 작업 호출
                current = jobList.get(idx).req;
            }
        }

        return answer / jobs.length;
    }
}