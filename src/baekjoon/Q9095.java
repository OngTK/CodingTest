package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2606
 * 1, 2, 3 더하기
 *
 * 문제
 *     정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수
 * 입력
 *     첫째 줄에 테스트 케이스의 개수 T
 *     둘째 줄 이하는 정수 n
 * 출력
 *     각 테스트 케이스마다 1, 2, 3합으로 나타냄
 * */

public class Q9095 {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4 ; i < 11; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for(int i = 0 ; i < n ; i++){
            int t = Integer.parseInt(br.readLine());
            sb.append(dp[t]).append("\n");
        }
        System.out.println(sb);
    } // main end
} // class end
