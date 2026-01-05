package baekjoon;

/**
 * 백준 2559 수열
 *
 * 문제
 *      매일 아침 9시에 학교에서 측정한 온도가 어떤 정수의 수열로 주어졌을 때,
 *      연속적인 며칠 동안의 온도의 합이 가장 큰 값을 알아보고자 한다.
 * 입력
 *      첫째 줄에는 두 개의 정수 N과 K가 한 개의 공백을 사이에 두고 순서대로 주어진다.
 *      첫 번째 정수 N은 온도를 측정한 전체 날짜의 수이다.
 *      N은 2 이상 100,000 이하이다.
 *      두 번째 정수 K는 합을 구하기 위한 연속적인 날짜의 수이다.
 *      K는 1과 N 사이의 정수이다.
 *
 *      둘째 줄에는 매일 측정한 온도를 나타내는 N개의 정수가 빈칸을 사이에 두고 주어진다.
 *      이 수들은 모두 -100 이상 100 이하이다.
 * 출력
 *      첫째 줄에는 입력되는 온도의 수열에서 연속적인 K일의 온도의 합이 최대가 되는 값을 출력한다.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫째 줄
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 숫자의 개수
        int K = Integer.parseInt(st.nextToken());   // 합할 연속 일 수

        // 누적합 구하기
        int[] list = new int[N + 1];
        list[0] = 0;

        st = new StringTokenizer(br.readLine());
        int result = Integer.MIN_VALUE; // 최소값으로 초기화
        int sum;
        for(int i = 1 ; i <= N ; i++){
            list[i] = list[i-1] + Integer.parseInt(st.nextToken());

            if( i >= K ) {
                sum = list[i] - list[i - K]; // k개 누적
                if (result <= sum) result = sum; // K개 누적이 기존 result보다 크면 갱신
            }
        }
        System.out.println(result);
    } // main end
} // class end
