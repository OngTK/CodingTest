package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 14626
 * ISBN(International Standard Book Number)
 *
 * 문제
 * ISBN은 13자리 숫자
 * 그중 마지막 숫자는 USBN 정확성 여부 점검 숫자
 * 각 자리마다 가중치(1, 3을 번갈아) 를 곱한 것을 모두 더하고 10으로 나눈 나머지가 0이 되도록 만드는 숫자 m
 * * 처리된 숫자를 찾아내기
 * 입력
 * ISBN 13자리, 단 훼손된 숫자는 *
 * 출력
 * * 을 출력
 */

public class Q14626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int idx = 0, sum = 0;
        for(int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);
            if( c != '*'){
                sum += (i%2==0) ? (c-'0') : (c-'0') * 3 ;
            } else {
                idx = i;
            }
        } // for end

        int result = 0;
        while (true){
            if(idx % 2 == 0){
                if( (sum + result) % 10 == 0 ){
                    System.out.println(result);
                    break;
                }
            } else {
                if((sum + result * 3) % 10 == 0){
                    System.out.println(result);
                    break;
                }
            }
            result++;
        } // while end

    } // main end
} // class end
