package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1110
 * 더하기 사이클
 *
 * 문제
 *     주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고, 각 자리의 숫자를 더함
 *     주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만듦
 *         ex) 26
 *             → 2+6 = 8 → 68
 *             → 6+8 = 14 → 84
 *             → 8+4 = 12 → 42
 *             → 4+2 = 6 → 26
 *     N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램을 작성
 * 입력
 *     첫째 줄 N / 0 ≤ N ≤ 99
 * 출력
 *     사이클의 길이
 * */

public class Q1110 {
    static int N;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        cycle(N);
        System.out.println(count);
    } // main end
    static void cycle(int x){
        if(count!= 0 && x == N) return;

        int a = (x / 10) + (x % 10);
        int b = ((x % 10)*10) + (a % 10);
        count++;
        cycle(b);
    } // func end;
} // class end
