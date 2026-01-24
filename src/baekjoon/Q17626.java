package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 17626
 * Four Squares
 *
 * 문제
 *     모든 자연수는 넷 혹은 그 이하의 제곱수의 합으로 표현할 수 있다
 *     자연수 n이 주어질 때, n을 최소 개수의 제곱합으로 표현
 * 입력
 *     자연수 n
 * 출력
 *     제곱수들의 최소 개수
 * */

public class Q17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2 ; i <= n ; i++){
            dp[i] = dp[i-1];
            for(int j = 1 ; j * j <= i ; j ++ ){
                dp[i] = Math.min(dp[i], dp[i-j*j]);
            }
            dp[i]++;
        }
        System.out.println(dp[n]);
    } // main end
} // class end
