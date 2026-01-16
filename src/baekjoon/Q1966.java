package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 * 백준 1966
 * 프린터 큐
 *
 * 문제
 *     조건
 *         1. 현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
 *         2. 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다. 그렇지 않다면 바로 인쇄를 한다.
 * 입력
 *     첫째 줄 : 테스트 케이스
 *     각 테스트 케이스는 두 줄로 이루어짐
 *         첫째 줄 : 문서의 개수
 *         몇 번째로 인쇄되었는지 궁금한 문서가 현재 queue에서 몇 번째 놓여 있는지를 나타내는 정수
 *         둘째 줄에는 N개의 문서의 중요도가 차례대로, 1~9, 중요도가 같은 문서가 여러개 있을 수 있음
 * 출력
 *     각 테스트 케이스에 대해 문서가 몇 번째로 인쇄되는 지
 * */

public class Q1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 갯수
            int M = Integer.parseInt(st.nextToken()); // 찾는 인덱스

            st = new StringTokenizer(br.readLine());
            LinkedList<int[]> queue = new LinkedList<>();

            for(int i = 0 ; i < N ; i++){
                queue.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            int count = 0;
            while(!queue.isEmpty()){
                int[] front = queue.poll();
                boolean isMax = true;

                for(int i = 0 ; i < queue.size(); i++){
                    if(front[1] < queue.get(i)[1]){
                        queue.offer(front);
                        for(int j = 0 ; j < i ; j++){
                            queue.offer(queue.poll());
                        }
                        isMax = false;
                        break;
                    }
                }
                if(isMax == false){
                    continue;
                }
                count++;
                if(front[0] == M){
                    break;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    } // main end
} // class end
