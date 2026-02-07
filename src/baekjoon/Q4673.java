package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 4673
 * 셀프 넘버
 *
 * 문제
 *     양의 정수 n에 대해서 d(n)을 n과 n의 각 자리수를 더하는 함수
 *     n을 d(n)의 생성자
 *     생성자가 없는 숫자를 셀프 넘버
 *     10000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력하는 프로그램
 * 입력
 *     X
 * 출력
 *     10,000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 증가하는 순서로 출력
 * */

public class Q4673 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        boolean[] check = new boolean[10001];
        for(int i = 1 ; i <= 10000; i++){
            int n = d(i);
            if(n<10001){
                check[n] = true;
            }
        }

        for(int i = 1 ; i <= 10000; i++){
            if(!check[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    } // main end

    public static int d(int n){
        int sum = n;
        while (n != 0){
            sum += n%10;
            n = n/10;
        }
        return sum;
    }
} // class end
