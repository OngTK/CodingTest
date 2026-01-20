package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1463
 * 1로 만들기
 * 문제
 *     1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
 *     2. X가 2로 나누어 떨어지면, 2로 나눈다.
 *     3. 1을 뺀다.
 *     정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들기
 *     연산을 사용하는 횟수의 최솟값을 출력
 * 입력
 *     첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어짐
 * 출력
 *     첫째 줄에 연산을 하는 횟수의 최소값을 출력
 * */

public class Q1463 {

    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N+1];
        dp[0] = dp[1] = 0;

        System.out.println(recur(N));

    } // main end

    static int recur(int a ){
        if(dp[a] == null){
            if(a % 6 == 0){
                dp[a] = Math.min(recur(a-1),Math.min(recur(a/3),recur(a/2))) +1 ;
            } else if (a % 3 == 0){
                dp[a] = Math.min(recur(a/3),recur(a-1))+1;
            } else if(a % 2 == 0){
                dp[a] = Math.min(recur(a/2), recur(a-1))+1;
            } else {
                dp[a] = recur(a-1) +1;
            }
        }
        return dp[a];
    }
} // class end
