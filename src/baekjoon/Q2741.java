package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2741
 * N 찍기
 *
 * 문제
 *      자연수 N이 주어졌을 때, 1부터 N까지 한 줄에 출력하는 프로그램을 작성
 * */
public class Q2741 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        br.close();

        for(int i = 1 ; i <= n ; i++){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    } // main end
} // class end
