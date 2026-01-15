package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 18110
 * solved.ac
 *
 * 문제
 *     solved.ac가 사용자들의 의견을 바탕으로 난이도를 결정하는 방식
 *         - 아직 아무 의견이 없다면 문제의 난이도는 0으로 결정
 *         - 의견이 하나 이상 있다면, 문제의 난이도는 모든 사람의 난이도 의견의 30% 절사평균으로 결정
 *         절사평균이란 극단적인 값들이 평균을 왜곡하는 것을 막기 위해 **가장 큰 값들과 가장 작은 값들을 제외하고 평균을 내는 것**
 *         30% 절사평균의 경우 위에서 15%, 아래에서 15%를 각각 제외하고 평균을 계산
 * 입력
 *     첫 번째 줄에 난이도 의견의 개수 n
 *     이후 두 번째 줄부터 1 + n번째 줄까지 사용자들이 제출한 난이도 의견 n개
 * 출력
 *     solved.ac가 계산한 문제의 난이도를 출력
 * */

public class Q18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] diff = new int[n];

        for (int i = 0 ; i < diff.length ; i++){
            diff[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(diff);
        int rounded = Math.toIntExact(Math.round(n * 0.15));
        int sum = 0 ;
        for(int i = rounded; i < diff.length - rounded ; i++){
            sum += diff[i];
        }
        System.out.println( Math.round((float) sum / (diff.length-(rounded * 2))));
    } // main end
} // class end
