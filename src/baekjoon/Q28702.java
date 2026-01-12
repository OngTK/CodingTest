package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 28702
 * FizzBuzz
 *
 * 문제
 *     i = 1, 2, … 에 대해 규칙에 따라 문자열을 출력
 *         - i 가 3의 배수 + 5의 배수 ⇒ FizzBuzz
 *         - i 가 3의 배수 / ! 5의 배수 ⇒ Fizz
 *         - i 가 ! 3의 배수 / 5의 배수 ⇒ Buzz
 *         - i가 ! 3의 배수 / ! 5의 배수 ⇒ i
 * 입력
 *     총 3개의 줄, 각 줄의 문자열이 주어짐
 * 출력
 *     연속으로 출력된 세 개의 문자열 다음에 올 문자열을 출력
 *     여러 문자열이 올 수 있는 경우, 아무거나 하나 출력
 * */


public class Q28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 0;
        boolean check = false;
        for(int i = 0 ; i < 3 ; i++){
            String s = br.readLine();
            char c = s.charAt(0);
            if(c != 'F' && c != 'B'){
                num = Integer.parseInt(s);
                check = true;
            }
            if (check){
                num++;
            }
        }

        if(num % 3 == 0 ){
            if( num % 5 == 0){
                System.out.println("FizzBuzz");
            } else {
                System.out.println("Fizz");
            }
        } else {
            if( num % 5 == 0){
                System.out.println("Buzz");
            } else {
                System.out.println(num);
            }
        }
    } // main end
} // class end