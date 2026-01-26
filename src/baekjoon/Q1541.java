package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1541
 * 잃어버린 괄호
 *
 * 문제
 *     양수와 +, -
 *     괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성
 * 입력
 *     첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있음
 *     가장 처음과 마지막 문자는 숫자
 *     연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없음
 * 출력
 *     첫째 줄에 정답을 출력
 * */

public class Q1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine(),"-");

        while(st.hasMoreTokens()){
            int temp = 0 ;

            StringTokenizer add = new StringTokenizer(st.nextToken(), "+");
            while(add.hasMoreTokens()){
                temp += Integer.parseInt(add.nextToken());
            }

            if(sum == Integer.MAX_VALUE){
                sum = temp;
            } else{
                sum -= temp;
            }
        }
        System.out.println(sum);
    } // main end
} // class end
