package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 5525
 * IOIOI
 *
 * 문제
 *     N+1개의 I와 N개의 O
 *     I와 O이 교대로 나오는 문자열을 Pn
 *     I와 O로만 이루어진 문자열 S와 정수 N이 주어졌을 때,
 *     S안에 Pn이 몇 군데 포함되어 있는지 구하는 프로그램을 작성
 * 입력
 *     첫째 줄에 N
 *     둘째 줄에는 S의 길이 M
 *     셋째 줄에 S
 * 출력
 *     S에 PN이 몇 군데 포함되어 있는지 출력
 * */

public class Q5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int answer = 0 , count = 0;

        for(int i = 0 ; i < M ; i++ ){
            if( i + 2 >= M){
                break;
            }

            if(s.charAt(i) == 'I' && s.charAt(i+1) == 'O' && s.charAt(i+2) == 'I'){
                count++;
                i++;

                if(count == N){
                    answer++;
                    count--;
                }
            } else {
                count = 0;
            }
        }
        System.out.println(answer);
    } // main end
} // class end
