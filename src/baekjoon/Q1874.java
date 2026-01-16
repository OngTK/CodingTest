package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1874
 * 스택 수열
 *
 * 문제
 *     1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있음
 *     이때 스택에 Push는 반드시 오름차순으로
 *     임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지
 * 입력
 *     첫 줄에 갯수 n
 *     둘째 줄 이하에는 n개의 수열을 이루는 1~n 의 정수가 하나씩 주어짐
 * 출력
 *     입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력
 *     push ⇒ + / pop ⇒ -
 *     불가능한 경우 No
 * */

public class Q1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[N];
        int idx = 0, start = 0;
        while (N-- > 0){
            int value = Integer.parseInt(br.readLine());
            if(value > start){
                for(int i = start+1 ; i <= value; i++){
                    stack[idx] = i;
                    idx++;
                    sb.append("+").append("\n");
                }
                start = value;
            } else if (stack[idx -1] != value){
                System.out.println("NO");
                return;
            }
            idx--;
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    } // main end
} // class end
