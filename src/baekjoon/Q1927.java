package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 백준 1927
 * 최소 힙
 *
 * 문제
 *     최소 힙을 이용하여 아래 연산을 지원하는 프로그램 작성
 *         1. 배열에 자연수 x를 넣는다.
 *         2. 배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
 *     프로그램은 처음에 비어있는 배열에서 시작
 * 입력
 *     첫째 줄 : 연산의 개수 N
 *     다음 N개 줄 : 연산에 대한 정보 x
 *         x가 자연수 ⇒ 배열에 x 값을 추가
 *         x = 0 : 배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거
 *         x < 2^31
 * 출력
 *     0이 주어진 만큼 출력
 *     단 배열이 비어있을 때 0을 호출하면 0을 출력
 * */

public class Q1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while( N-- > 0){
            int x = Integer.parseInt(br.readLine());
            if( x == 0 ){
                if( pq.isEmpty()){
                    sb.append(0).append("\n");
                }else {
                    sb.append(pq.poll()).append("\n");
                }
            } else{
                pq.add(x);
            }
        }
        System.out.println(sb);

    } // main end
} // class end
