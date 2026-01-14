package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 10828
 * 스택
 *
 * 문제
 *     정수를 저장하는 스택을 구현하고 명령어를 처리하는 프로그램 작성
 *         - push X: 정수 X를 스택에 넣는 연산
 *         - pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력
 *             만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력
 *         - size: 스택에 들어있는 정수의 개수를 출력
 *         - empty: 스택이 비어있으면 1, 아니면 0을 출력
 *         - top: 스택의 가장 위에 있는 정수를 출력
 *             스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * 입력
 *     첫째 줄 : N 명령의 수 (1 ≤ N ≤ 10,000)
 *     둘째 줄 : N개의 명령이 하나씩 주어짐
 * 출력
 *     출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력
 * */

public class Q10828 {

    public int[] stack;
    public static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 실행 횟수

        int[] stack = new int[N];

        String quest;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            quest = st.nextToken();
            if (quest.equals("push")){
                // [1] Push
                stack[size] = Integer.parseInt(st.nextToken());
                size++;
            } else if (quest.equals("pop")){
                // [2] pop
                if(size == 0){
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack[size-1]).append("\n");
                    stack[size - 1] =0;
                    size--;
                }
            } else if (quest.equals("size")){
                // [3] size
                sb.append(size).append("\n");
            } else if (quest.equals("empty")){
                // [4] empty
                if(size == 0 ){
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (quest.equals("top")){
                // [5] top
                if(size == 0 ){
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack[size-1]).append("\n");
                }
            }
        } // func end
        System.out.println(sb);
    } // main end
} // class end
