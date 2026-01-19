package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1003
 * 피보나치 함수
 *
 * 문제
 *     `fibonacci(N)`을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성
 * 입력
 *     첫째 줄 : 테스트 케이스 T
 *     둘째 줄 이하 : 테스트 케이스
 * 출력
 *     0과 1이 출력되는 횟수를 공백으로 구분해서 출력
 * */

public class Q1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] dp = new long[41]; // 피보나치 배열 추기화
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2 ; i <= 40 ; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            int a = Integer.parseInt(br.readLine());
            if(a==0){
                sb.append("1 0 \n");
                continue;
            }
            sb.append(dp[a-1]).append(" ").append(dp[a]).append("\n");
        }
        System.out.println(sb);
    } // main end
} // class end
