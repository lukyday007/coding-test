package Baekjoon.src;
import java.util.*;
import java.io.*;

public class Missing_Parentheses_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] parts = input.split("-");

        int answer = solution(parts[0]);    // 첫 문자열 처리
        // - 로 파싱된 남은 문자열 처리
        for (int i = 1; i < parts.length; i++)
            answer -= solution(parts[i]);

        System.out.println(answer);
    }

    private static int solution(String input) {
        String[] nums = input.split("\\+"); // + 기준으로 다시 파싱
        int sum = 0;
        for (String num: nums)
            sum += Integer.parseInt(num);

        return sum;
    }
}