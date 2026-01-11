package baekjoon;

/**
 * 백준 2577
 * 숫자의 개수
 *
 * 세 개의 숫자를 곱한 숫자에 대하여
 * 0~9가 몇 개가 있는지 카운트
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String multi = A * B * C +"" ;

        int[] result = new int[10];
        for(int i = 0 ; i < multi.length() ; i++){
            int num = (int) multi.charAt(i) -48;
            result[num]++;
        }

        for(int i = 0 ; i < result.length; i++){
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
} // class end
