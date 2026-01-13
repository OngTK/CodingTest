package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1676
 * 팩토리얼 0의 개수
 *
 * 문제
 *     N! 에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성
 * 입력
 *     첫째 줄 : N
 * 출력
 *     N에 대한 0의 갯수
 * */

public class Q1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0 ;
        while ( N >= 5 ){
            count += N/5;
            N /= 5;
        }
        System.out.println(count);
    } // main end
} // class end
