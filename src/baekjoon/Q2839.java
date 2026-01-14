package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2839
 * 설탕 배달
 * <p>
 * 문제
 * 설탕 봉지 → 3 kg / 5 kg
 * N kg 배달할 때, 최소한의 봉지로 배달하려 할 때, 봉지 수
 * 입력
 * 첫째 줄 : N
 * 출력
 * 최소 봉지 개수를 출력
 * N을 만들수 없으면 -1
 * ======================================
 * 3, 6, 9 는 3kg 짜리가 1, 2, 3개 필요
 * 5, 10kg은 kg 짜리가 필요
 */

public class Q2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;

        if (N == 4 || N == 7) {
            System.out.println(-1);
        }
        else if (N % 5 == 0) {
            System.out.println(N / 5);
        }
        else if (N % 5 == 1 || N % 5 == 3) {
            System.out.println((N / 5) + 1);
        }
        else if (N % 5 == 2 || N % 5 == 4) {
            System.out.println((N / 5) + 2);
        }

    } // main end
} // class end
