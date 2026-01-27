package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1654
 * 랜선 자르기
 *
 * 문제
 *     K개의 서로 다른 길이의 랜선 → N개의 모두 같은 길이의 랜선 (n개보다 많이 만드는 것 ok)
 * 입력
 *     첫줄 : K N
 *     둘째줄 이하 : K개의 랜선의 길이 ( ≤ 2^31 -1)
 * 출력
 *     만들 수 있는 최대 랜선의 길이
 * */

public class Q1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lengthArray = new int[K];
        long max = 0, min = 0, mid;
        for(int i = 0 ; i < K ; i++){
            int len = Integer.parseInt(br.readLine());
            lengthArray[i] = len;
            if( max < len ) max = len;
        }
        max++;

        while(min < max){
            mid = (max + min) / 2;
            long count = 0;

            for(int i = 0 ; i < K ; i ++){
                count += (lengthArray[i] / mid);
            }
            if(count < N ){
                max = mid;
            } else {
                min = mid + 1 ;
            }
        }

        System.out.println(min-1);
    } // main end
} // class end
