package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 5430
 * AC
 *
 * 문제
 *     AC는 정수 배열에 연산을 하기 위해 만든 언어
 *     두 가지 함수 R(뒤집기)과 D(버리기)
 *     R: 배열에 있는 수의 순서를 뒤집는 함수
 *     D: 첫 번째 수를 버리는 함수
 *     배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램
 * 입력
 *     첫째 줄에 테스트 케이스의 개수 T
 *     각 테스트 케이스의 첫째 줄에는 수행할 함수 p
 *     다음 줄에는 배열에 들어있는 수의 개수 n
 *     다음 줄에는 [x1,...,xn]과 같은 형태로 배열에 들어있는 정수
 * 출력
 *     각 테스트 케이스에 대해서, 입력으로 주어진 정수 배열에 함수를 수행한 결과를 출력
 *     만약, 에러가 발생한 경우에는 error를 출력
 * */

public class Q5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        for (int i = 0; i < T; i++) {
            String p = br.readLine(); // 수행할 함수 p
            int n = Integer.parseInt(br.readLine()); // 배열에 들어가는 갯수
            // Deque 사용
            Deque<Integer> deque = new ArrayDeque<>();
            boolean reverse = false; // 뒤집힌 상태 확인
            int error = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            for(int j = 1; j < (n*2) ; j += 2){
                deque.offer(Integer.parseInt(st.nextToken()));
            }

            // 함수 실행
            for(int j = 0 ; j < p.length() ; j++ ){
                char c =  p.charAt(j);
                if( c == 'R' ){ // R 일 때, 배열을 뒤집기
                    if(reverse) reverse = false;
                    else reverse = true;
                } else {        // D 일 때,
                    // 배열이 비어있으면 에러 + 종료
                    if(deque.isEmpty()) {
                        error = 1 ;
                        break;
                    }
                    // 배열이 비어있지 않으면, 첫번째 값을 제거
                    if(!reverse) deque.pollFirst();
                    else deque.pollLast();
                }
            }

            if(error == 1){
                sb.append("error").append("\n");
            } else{
                if(reverse){ // reverse true
                    sb.append("[");
                    while(!deque.isEmpty()){
                        sb.append(deque.pollLast());
                        if(!deque.isEmpty()) {
                            sb.append(",");
                        } else {
                            break;
                        }
                    }
                    sb.append("]").append("\n");
                } else { // reverse false
                    sb.append("[");
                    while(!deque.isEmpty()){
                        sb.append(deque.pollFirst());
                        if(!deque.isEmpty()) {
                            sb.append(",");
                        } else  {
                            break;
                        }
                    }
                    sb.append("]").append("\n");
                }
            }
        } // for end
        System.out.println(sb);
    } // main end
} // class end
