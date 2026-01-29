package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 백준 11279
 * 최대 힙
 *
 * 문제
 *     1. 배열에 자연수 x를 넣는다.
 *     2. 배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거한다.
 * 입력
 *     첫째 줄에 연산의 개수 N(1 ≤ N ≤ 100,000)
 *     N개의 줄에는 연산에 대한 정보를 나타내는 정수 x
 *         x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산
 *         x가 0이라면 배열에서 가장 큰 값을 출력하고 그 값을 배열에서 제거
 * 출력
 *     입력에서 0이 주어진 횟수만큼 답을 출력
 * */

public class Q11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(x);
            }
        } // while end
        System.out.println(sb);
    } // main end
} // class end
