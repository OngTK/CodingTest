package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 18111
 * 마인 크래프트
 *
 * 문제
 *     땅고르기 작업 → 세로 N / 가로 M 크기의 집터
 *         - 좌표( i , j )의 가장 위에 있는 블록을 제거하여 인벤토리에 넣음 → 2초
 *         - 인벤토리에서 블록 하나를 꺼내어 좌표( i , j )의 가장 위에 있는 블록 위에 놓음 → 1초
 *     땅고르기 작업에 걸리는 최소 시간과 그 경우 땅의 높이
 *     작업 시작시 인벤토리에 B개의 블록이 들어 있음
 *     땅의 높이는 256을 초과할 수 없고, 음수 일 수 없음
 * 입력
 *     첫째 줄 : N M B (1 ≤ M, N ≤ 500, 0 ≤ B ≤ 6.4 × 10^7)
 *     둘째 줄 부터 N개의 줄에 M 개의 땅 높이
 * 출력
 *     첫째 줄에 땅을 고르는 데 걸리는 시간과 땅의 높이를 출력
 *     답이 여러 개 있다면 그중에서 땅의 높이가 가장 높은 것을 출력
 * */

public class Q18111 {

    static int N, M, B;
    static int[][] ground;
    static int max = 0, min = 256;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 세로
        M = Integer.parseInt(st.nextToken());   // 가로
        B = Integer.parseInt(st.nextToken());   // 인벤토리

        ground = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                ground[i][j] = Integer.parseInt(st.nextToken());
                if (ground[i][j] > max) max = ground[i][j];
                if (ground[i][j] < min) min = ground[i][j];
            }
        } // for end

        int time = Integer.MAX_VALUE;
        int high = 0;

        for(int i = min ; i <= max; i++){
            int count = 0 ;
            int block = B;

            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    // 현재 좌표의 층이 만들 층보다 높으면 제거
                    if( i < ground[j][k] ){
                        count += ((ground[j][k] - i) * 2);  // +2초
                        block += ground[j][k] - i;          // 인벤토리에 넣기
                    } else {    // 층보다 낮으면 채우기
                        count += (i -  ground[j][k]);       // +1초
                        block -= (i - ground[j][k]);        // 인벤토리에서 빼기
                    }

                }
            }
            if( block < 0 ) break;  // 인벤토리는 음수가 되면 종료
            if(time >= count) {
                time = count;
                high = i;
            }
        } // for end
        System.out.println(time+" "+high);
    } // main end
} // class end
