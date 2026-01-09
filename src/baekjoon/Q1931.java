package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 1931
 * 회의실 배정
 *
 * 문제
 *      한 개의 회의실, N개의 회의에 대한 회의실 사용표를 만듦
 *      각 회의 I에 대해 시작시간과 끝시간이 주어지고
 *      각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾기
 * 입력
 *      첫째 줄
 *          회의의 수 N
 *      둘째 줄
 *          회의 정보 : 시작시간 / 끝나는 시간
 * 출력
 *      첫째 줄에 최대 사용할 수  있는 회의의 최대 개수를 출력
 * */

public class Q1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        /*
            time[][0] : 시작 시간 / time[][1] : 종료 시간
         */
        int[][] times = new int[N][2];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            times[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        // 끝나는 시간을 기준으로 정렬 => Compare 재정의
        Arrays.sort(times, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                // 종료시간이 같을 경우 시작시간이 빠른 순으로 정렬
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        }); // Arrays.sort end

        int count = 0;
        int prev_end_time = 0 ;

        for(int i = 0 ; i < N ; i++){
            // 직전 종료시간이 다음 회의 시간 시작보다 작거나 같다면 갱신
            if(prev_end_time <= times[i][0]){
                prev_end_time = times[i][1];
                count++;
            }
        }
        System.out.println(count);
    } // main
} // class

