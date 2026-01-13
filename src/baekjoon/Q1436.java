package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1436
 * 영화감독 숌
 *
 * 문제
 *     종말의 수 : 6이 적어도 6개 이상 연속으로 들어가는 수
 *     N번째 영화 제목 → N번째 작은 수
 * 입력
 *     첫째 줄 : N
 * 출력
 *     N번째 작은 수
 * */

public class Q1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 666;
        int count = 1;

        while (count != N){
            result++;
            if(String.valueOf(result).contains("666")){
                count++;
            }
        }
        System.out.println(result);
    } // main end
} // class end
