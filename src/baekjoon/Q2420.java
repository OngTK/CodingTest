package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2420
 * 사파리 월드
 *
 * 문제
 *      두 서브 도메인의 유명도가 주어졌을 때 그 차이를 구하는 프로그램을 작성
 * 입력
 *      N  M
 * 출력
 *      유명도의 차이를 출력
 * */

public class Q2420 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        System.out.println(Math.abs( a - b ));
    } // main end
} // class end
