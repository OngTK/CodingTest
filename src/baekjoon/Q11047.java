package baekjoon;

/**
 * 문제
 * 동전 종류 N개
 * 동전을 적절히 사용해서 그 가치의 합을 K로 만드려고 함
 * 이때 필요한 동전 개수의 최소값을 구하시오
 * 입력
 * 첫째줄 : N K
 * 둘째줄 ~ N줄
 * 동전의가치 Ai가 오름차순
 * 출력
 * K원을 만드는데 필요한 동전 개수의 최소 값
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11047 {
    static int N, K;
    static int[] coins;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for (int i = N-1; i >= 0; i--) {
            if (K != 0) {
                result += K / coins[i];
                K = K % coins[i];
            }
        }
        System.out.println(result);
    } // main end
} // class end
