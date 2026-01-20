package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2579
 * 계단 오르기
 *
 * 문제
 *     1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다.
 *     즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
 *     2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
 *     3. 마지막 도착 계단은 반드시 밟아야 한다.
 *     총 점수의 최댓값을 구하는 프로그램을 작성
 * 입력
 *     입력의 첫째 줄에 계단의 개수
 *     둘째 줄부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수
 * 출력
 *     첫째 줄에 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값을 출력
 * */

public class Q2576 {

    static Integer dp[];
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N+1];
        arr = new int[N+1];

        for(int i = 1 ; i <= N ; i++ ){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        dp[1] = arr[1];

        if( N >= 2) {
            dp[2] = arr[1] + arr[2];
        }
        System.out.println(find(N));
    } // main end
    static int find(int N){
        if(dp[N] == null){
            dp[N] = Math.max(find(N-2), find(N-3) + arr[N-1]) + arr[N];
        }
        return dp[N];
    }

} // class end
