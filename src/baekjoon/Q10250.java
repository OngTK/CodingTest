package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 10250
 * ACM 호텔
 *
 * 문제
 *      정문으로부터 걷는 거리가 가장 짧도록 방을 배정
 *      H층 / 각 층이 W개의 방 / 엘리베이터는 가장 완쪽
 *      정문은 엘리베이터 바로 앞
 * 입력
 *      첫째 줄 : 테스트 횟수
 *      둘째 줄 이하
 *          H W N / 층수, 각 층 방 수 / 몇 번째 손님
 * */

public class Q10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 첫째 줄
        int T = Integer.parseInt(br.readLine());

        // 둘재 줄 이하
        String s;
        for(int i = 0 ; i < T ; i ++){
            s = "";
            st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken()); // 층 수
            int W = Integer.parseInt(st.nextToken()); // 방 수
            int N = Integer.parseInt(st.nextToken()); // 온 횟수

            int floor ;
            int roomNum;
            if( N % H ==0 ){
                floor = H;
                roomNum = (N / H) ;
            } else {
                floor = N % H;
                roomNum = (N / H) + 1 ;
            }
            sb.append(floor * 100 + roomNum).append("\n");
        }
        System.out.println(sb);
    } // main end
} // class end
