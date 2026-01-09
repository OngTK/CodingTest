package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2475
 * 검증수
 *
 * 문제
 *      컴퓨터마다 6자리의 고유번호를 매김
 *      0~4 자리 : 00000 ~ 99999 중 하나가 주어짐
 *      5 자리 : 검증수가 들어감
 *
 *      검증수는 고유번호의 처음 5자리에 들어가는 5개의 숫자를 각각 제곱한 수의 합을 10으로 나눈 나머지
 * 입력
 *      고유 번호 5 개의 숫자
 * 출력
 *      검증 수를 출력
 * */
public class Q2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0 ;
        for(int i = 0 ; i < 5 ; i++){
            sum += (int) Math.pow(Integer.parseInt(st.nextToken()),2);
        }
        System.out.println(sum%10);

    } // main end
} // class end
