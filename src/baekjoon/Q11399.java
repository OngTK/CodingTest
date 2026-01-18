package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 11399
 * ATM
 *
 * 문제
 *     사람 1 ~ N / i번 사람의 시간 P_i
 *     줄을 서 있는 사람의 수 N과 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어졌을 때,
 *     각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 구하는 프로그램을 작성
 * 입력
 *     첫째 줄에 사람의 수 N(1 ≤ N ≤ 1,000)
 *     둘째 줄에는 각 사람이 돈을 인출하는데 걸리는 시간 Pi (1 ≤ Pi ≤ 1,000)
 * 출력
 *     첫째 줄에 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 출력
 * */

public class Q11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int totalSum = 0;
        for(int i = 0 ; i < N ; i++){
            totalSum += arr[i] * ( N - i );
        }
        System.out.println(totalSum);

    } // main end
} // class end
