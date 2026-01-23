package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 9461
 * 파도반 수열
 *
 * 문제
 *     첫 삼각형의 변의 길이는 1
 *     나선에서 가장 큰 변의 길이를 k라 할 때, 그 변의 길이가 k인 정삼각형을 추가
 *     파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이
 *     P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9
 *     P(N)을 구하는 프로그램 작성
 * 입력
 *     첫째 줄 : 테스트케이스 T
 *     둘째 줄 이하 : N
 * 출력
 *     각 테스트 케이스의 P(N)을 출력
 * */

public class Q9461 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] tri = new long[101];
        for(int i = 1 ; i < 101 ; i++){
            if ( i <= 3 ){
                tri[i] = 1;
            } else {
                tri[i] = tri[i-2] + tri[i-3];
            }
        }

        int t = Integer.parseInt(br.readLine());
        while (t -- > 0){
            int n = Integer.parseInt(br.readLine());
            sb.append(tri[n]).append("\n");
        }
        System.out.println(sb);
    } // main end
} // class end
