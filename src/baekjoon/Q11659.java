package baekjoon;

/**
 * Baekjoon 11659
 * 구간 합 구하기 4
 *
 * 문제
 *      수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
 * 입력
 *      첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다.
 *      둘째 줄에는 N개의 수가 주어진다.
 *      수는 1,000보다 작거나 같은 자연수이다.
 *      셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
 * 출력
 *      총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11659 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        // 첫째 줄
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

        // 둘째 줄
        st = new StringTokenizer(br.readLine());

        int[] list = new int[N + 1];
        list[0] = 0;
        for(int i = 1 ; i <= N ; i++){
            list[i] = list[i-1] + Integer.parseInt(st.nextToken());
        }

        // 셋째 줄
        int i;
        int j;
        for(int z = 0 ; z < M ; z++){
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());

            sb.append((list[j]-list[i-1])+"\n");
        }
        System.out.println(sb);

    } // main end
} // class end


/**
 * 시간초과 오답 ==============================================================
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         StringTokenizer st ;
 *         StringBuilder sb = new StringBuilder();
 *
 *         // 첫째 줄
 *         st = new StringTokenizer(br.readLine());
 *         int N = Integer.parseInt(st.nextToken()); // 수의 개수
 *         int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수
 *
 *         // 둘째 줄
 *         int[] list = new int[N];
 *         st = new StringTokenizer(br.readLine());
 *         for(int i = 0 ; i < N ; i++){
 *             list[i] = Integer.parseInt(st.nextToken());
 *         }
 *
 *         // 셋째 줄 이하
 *         int sum ;
 *         for( int z = 0 ; z < M ; z++){
 *             st = new StringTokenizer(br.readLine());
 *             int i = Integer.parseInt(st.nextToken()) -1;
 *             int j = Integer.parseInt(st.nextToken()) -1;
 *
 *             // i~j 까지의 합 구하기
 *             sum = 0 ; // 초기화
 *             for (int k = i ; k <= j ; k++){
 *                 sum += list[k]; // i부터 j까지 합산
 *             }
 *             sb.append(sum + "\n"); // 합산결과 + 줄바꾸기
 *         }
 *         System.out.println(sb);
 * */
