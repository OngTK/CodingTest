package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 15829
 * Hashing
 *
 * 문제
 *     주어진 문자열의 해시 값을 계산
 * 입력
 *     첫째 줄 : 문자열의 길이 L
 *     둘째 줄 : 영어 소문자로만 이루어진 문자열
 * 출력
 *     문제에서 주어진 해시함수와 입력으로 주어진 문자열을 상ㅇ해 계산한 해시 값을 정수로 출력
 * */

public class Q15829 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();
        br.close();
        long M = 1234567891L;

        long result = 0;
        long r = 1 ;

        for(int i = 0 ; i < L ; i++){
            long c = s.charAt(i) - 'a' + 1;
            result = (result + c * r ) % M ;
            r = (r * 31) % M;
        }
        System.out.println(result);
    } // main end
} // class end
