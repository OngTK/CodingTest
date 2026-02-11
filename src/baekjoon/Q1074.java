package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1074
 * Z
 *
 * 문제
 *     2ⁿ× 2ⁿ인 2차원 배열을 Z모양으로 탐색
 *     N > 1 인 경우, 배열의 크기가 2^(N-1)× 2^(N-1)로 4등분 한 후에 재귀적으로 순서대로 방문
 *     N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력
 * 입력
 *     첫째 줄에 정수 N, r, c
 * 출력
 *     r행 c열을 몇 번째로 방문했는지 출력
 * */

public class Q1074 {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N); // 한 변의 길이

        find(size, r, c);
        System.out.println(count);

    } // main end

    static void find(int n, int r , int c){
        if( n == 1 ) return;
        if(r < n/2 && c < n/2){ // 1 사분면
            find(n/2, r, c);
        } else if ( r < n/2 && c >= n/2){ // 2사분면
            count += n * n/4;
            find(n/2, r , c - n/2);
        } else if (r >= n / 2 && c < n/2 ) { // 3사분면
            count += (n * n / 4) * 2;
            find(n/2, r - n/2, c);
        } else { // 4사분면
            count += (n * n/4) * 3;
            find(n/2 ,r - n/2, c - n/2 );
        }
    } // func end
} // class end
