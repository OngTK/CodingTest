package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2775
 * 부녀회장이 될테야
 *
 * 문제
 *     a층 b호에 살려면 → a-1층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 사야함
 *     k층 n호에 몇 명이 살고 있는지
 *     단, 아파트는 0층 부터 있고, 각 층에는 1호부터 있음.
 *     0층 i호에는 i먕이 살고 있음
 * 입력
 *     첫째 줄: 테스트 케이스 T
 *     둘째 줄 + 2n: 층 k
 *     셋째 줄 + 2n: 호 n
 * 출력
 *     test case에 대한 거주민 수
 * */

public class Q2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // [1] 14층, 14호까지이므로, 한 번 사용할 2차원 배열을 만듦
        int[][] rooms = new int[15][15];
        for(int i = 0 ; i < rooms[0].length ; i++){
            rooms[0][i] = i+1;
        }
        for(int i = 1 ; i < rooms.length ; i++){
            rooms[i][0] = 1;
            for( int j = 1 ; j < rooms[i].length ; j++){
                rooms[i][j] = rooms[i-1][j] + rooms[i][j-1];
            }
        }

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
        int k , n = 0;
        for(int i = 0 ; i < T ; i++){
               k = Integer.parseInt(br.readLine()); // 층
               n = Integer.parseInt(br.readLine()); // 호
            sb.append(rooms[k][n-1]).append("\n");
        }
        System.out.println(sb);
    } // main end
} // class end
