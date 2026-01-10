package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 4153
 * 직각 삼각형
 *
 * 문제
 *      세변의 길이로 삼각형이 직각인지를 구별
 * 입력
 *      여러 개의 테스트 케이스가 주어짐
 *      0 0 0 이 주어지면 종료
 * 출력
 *      직각 삼각형이 맞으면 right
 *      아니면 wrong
 * */

public class Q4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        int[] sides = new int[3];
        for(;;){
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < 3 ; i++){
                sides[i] = Integer.parseInt(st.nextToken());
            }
            if(sides[0] == 0 && sides[1] == 0 && sides[2] == 0) break;

            Arrays.sort(sides);

            if((Math.pow(sides[0],2) + Math.pow(sides[1],2)) == Math.pow(sides[2],2)){
                sb.append("right");
            } else {
                sb.append("wrong");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    } // main end
} // class end
