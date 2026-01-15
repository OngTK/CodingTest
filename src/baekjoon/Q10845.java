package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 10845
 * 큐
 *
 * 문제
 *     정수를 저장하는 큐를 구현하고 명령을 처리하는 프로그램을 작성
 *     - push X
 *         - 정수 X를 큐에 넣는 연산
 *     - pop
 *         - 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력
 *         - 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
 *     - size
 *         - 큐에 들어있는 정수의 개수를 출력
 *     - empty
 *         - 큐가 비어있으면 1, 아니면 0을 출력
 *     - front
 *         - 큐의 가장 앞에 있는 정수를 출력
 *         - 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
 *     - back
 *         - 큐의 가장 뒤에 있는 정수를 출력
 *         - 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력
 * 입력
 *     첫째 줄: 주어지는 명령의 수 N
 *     둘째 줄: N개의 줄에는 명령이 하나씩 주어짐
 * 출력
 *     출력해야 하는 명령이 주어질 때마다, 한 줄에 하나씩 출력
 * */

public class Q10845 {
    private static int[] queue;
    private static int start = 0, end = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        queue = new int[N];

        while( N-- > 0){
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    } // main end

    public static void push(int a){
        queue[end] = a;
        end++;
    }
    public static int pop(){
        if((end-start) == 0) return -1;

        int a = queue[start];
        queue[start] = 0;
        start++;
        return a;
    }
    public static int size(){
        return (end-start);
    }
    public static int empty(){
        if((end-start) == 0) return 1;
        return 0;
    }
    public static int front(){
        if((end-start) == 0) return -1;
        return queue[start];
    }
    public static int back(){
        if((end-start) == 0 ) return -1;
        return queue[end-1];
    }
} // class end