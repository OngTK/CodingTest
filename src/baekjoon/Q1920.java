package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1920
 * 수 찾기
 *
 * 문제
 *     N개의 정수, 중 X가 존재하는지 확인
 * 입력
 *     첫째 줄 자연수 N 개수
 *     둘째 줄 N개의 정수
 *     셋째 줄 자연수 M 개수
 *     넷째 줄 M개의 정수 ⇒ 이들이 N개의 정수에 있는 지
 * 출력
 *     M개의 줄에 답을 출력
 *     존재하면 1, 없으면 0
 * */

public class Q1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());    // 첫째 줄

        // 둘째 줄 행렬
        int[] nArray = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            nArray[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nArray);

        // 셋째 줄
        int M = Integer.parseInt(br.readLine());

        // 넷째 줄
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++){
            int c = Integer.parseInt(st.nextToken());

            if(Arrays.binarySearch(nArray,c) >= 0){ // 존재하면
                sb.append("1\n");
            } else{
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    } // main end
} // class end
