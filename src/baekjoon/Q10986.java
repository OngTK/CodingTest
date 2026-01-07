package baekjoon;

/**
 * 백준 10986
 *
 * 문제
 *      수 N개 A1, A2, ..., AN이 주어진다.
 *      이때, 연속된 부분 구간의 합이
 *      M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
 *      즉, Ai+ ... + Aj(i ≤ j) 의 합이 M으로 나누어 떨어지는
 *      (i, j) 쌍의 개수를 구해야 한다.
 * 입력
 *      첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)
 *      둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai≤ 109)
 * 출력
 *      첫째 줄에 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 출력한다.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째 줄
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 숫자의 갯수
        int M = Integer.parseInt(st.nextToken()); // 나눌 수

        // 둘째 줄
        st = new StringTokenizer(br.readLine());

        long[] sums = new long[N+1]; // 누적합 배열
        long[] remains = new long[M]; // 누적합을 M으로 나누었을때 나머지를 저장하는 배열
        long count = 0;

        for(int i = 1 ; i < sums.length; i++) {
            sums[i] = sums[i-1] +Integer.parseInt(st.nextToken());
            int remain = (int) (sums[i] % M); // 합을 M으로 나눈 값
            if(remain == 0 ) ++count;
            ++remains[remain]; // 나머지 저장 배열 업데이트
        }

        // 나머지 배열에서 원소 값이 같은 개수를 조합
        // 원소 값이 같은 2개의 원소를 뽑는 모든 경우의 수
        for(int i = 0 ; i < M; i++){
            if(remains[i]>1){
                count += (remains[i] * (remains[i]-1) /2 );
            }
        }
        System.out.println(count);

    } // main end1
} // class end


// 시간초과
//public class Q10986 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        // 첫째 줄
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken()); // 숫자의 갯수
//        int M = Integer.parseInt(st.nextToken()); // 나눌 수
//
//        // 둘째 줄
//        st = new StringTokenizer(br.readLine());
//        // 누적합 배열 만들기
//        int[] arr = new int[N +1];
//        arr[0] = 0 ;
//        for(int i = 1 ; i <= N ; i++){
//            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
//        }
//
//        // 연산 시작
//        int sum = 0;
//        for(int i = 0 ; i < arr.length ; i++){
//            for(int j = 0 ; j < i ; j++){
//                int x = arr[i] - arr[j];
//                if(x % M == 0 ) sum++;
//            }
//        }
//        System.out.println(sum);
//
//    } // main end1
//} // class end