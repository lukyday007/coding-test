package Baekjoon;

import java.io.*;

public class A_and_B_12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String from = br.readLine();
        String to = br.readLine();

        while (to.length() > from.length()) {
            char last = to.charAt(to.length() - 1);
            to = to.substring(0, to.length() - 1);
            if (last == 'B')
                to = new StringBuilder(to).reverse().toString();
        }

        bw.write(String.valueOf(to.equals(from) ? 1 : 0));
        bw.flush();
        bw.close();
    }
}