package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 백준 11286
 * 절댓값 힙
 *
 * 문제
 *     1. 배열에 정수 x (x≠ 0)를 넣는다.
 *     2. 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
 *         절댓값이 가장 작은 값이 여러 개일 때는, 가장 작은 수를 출력하고,
 *         그 값을 배열에서 제거
 * 입력
 *     첫째 줄에 연산의 개수 N(1≤N≤100,000)
 *     다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x
 * 출력
 *     입력에서 0이 주어진 회수만큼 답을 출력
 *     배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력
 * */

public class Q11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        // 절대값 비교, 절대값이 작은 수와 자리를 교체
                        if(Math.abs(o1) > Math.abs(o2)){
                            return Math.abs(o1) - Math.abs(o2);
                        } else if (Math.abs(o1) == Math.abs(o2)){
                            return o1 - o2;
                        } else {
                            return -1;
                        }
                    };
                }
        );

        while( N -- > 0){
            int x = Integer.parseInt(br.readLine());
            if(x == 0 ){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.offer(x);
            }
        }
        System.out.println(sb);
    } // main end
} // class end
