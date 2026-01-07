package baekjoon;

/**
 * 백준 11660
 *
 * 문제
 *      N * N 개의 수가 N * N 크기의 표에 채워져 있움
 *      (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성
 * 입력
 *      첫째 줄
 *          N : 표의 크기
 *          M : 합을 구하는 횟수
 *      둘째 줄 ~ N개 줄
 *          표에 채워져야 하는 수
 *      셋째 줄 ~ M개
 *          x1 y1 x2 y2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 첫째줄
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 표의 크기
        int M = Integer.parseInt(st.nextToken());   // 구하는 횟 수

        // 누적합 표 채우기
        int[][] sumTable = new int[N][N+1];    // x,y 반전 주의

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            sumTable[i][0] = 0;
            for(int j = 1 ; j <= N ; j++){
                sumTable[i][j] = sumTable[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(Arrays.deepToString(sumTable));
        // M번 반복하며, 누적합 구하기
        int sum;
        for(int i =0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sum = 0; // 초기화

            // y2-y1행에 대해서 반복
            for(int row = x1 - 1; row <= x2 - 1; row++){
                sum += sumTable[row][y2] - sumTable[row][y1 - 1];

                System.out.println("sumTable["+row+"]["+y2+"] : "+ sumTable[row][y2]);
                System.out.println("sumTable["+row+"]["+(y1 - 1)+"] : "+ sumTable[row][y1 - 1]);
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    } // main end
} // class end
