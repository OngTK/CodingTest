package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 30802
 * 웰컴 키트
 * 문제
 *         티셔츠 한 장 +펜 한자루 ⇒ 웰컴키트
 *         키트 주문 조건
 *             - 티셔츠는 S, M, L, XL, XXL, 그리고 XXXL의 6가지 사이즈가 있음
 *             티셔츠는 같은 사이즈의 T장 묶음으로만 주문할 수 있음
 *             - 펜은 한 종류로, P자루씩 묶음으로 주문하거나 한 자루씩 주문할 수 있음
 *         총 N명의 참가자 중 S, M, L, XL, XXL, XXXL 사이즈의 티셔츠를 신청한 사람은 각각 $S, M, L, XL, XXL, XXXL$명
 *         티셔츠는 남아도 되지만 부족해서는 안되고 신청한 사이즈 대로 나눠주어야 함
 *         펜은 남거나 부족해서는 안되고 정확히 참가자 수만큼 준비되어야 함
 *         티셔츠는 T장씩 최소 몇 묶음 주문해야 하는지,
 *         그리고 펜을 P자루씩 최대 몇 묶음 주문할 수 있고, 그 때 펜을 한 자루씩 몇 개 주문하는지
 * 입력
 *     첫째 줄
 *         N : 참가자의 수
 *     둘째 줄
 *         티셔츠 사이즈별 신청자의 수
 *     셋째 줄
 *         티셔츠와 펜의 묶음 수를 의미하는  T와 P
 * 출력
 *     첫 줄 : 티셔츠를 T장씩 최소 몇 묶음 주문해야 하는지
 *     둘째 줄 : 펜 P자루씩 몇 묶음 주문 / 그때 펜을 한자루씩 몇 개 주문하는 지
 * */

public class Q30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 참가자 수

        // 사이즈별 참가자 수
        st = new StringTokenizer(br.readLine());
        int[] sizes = new int[6];
        for(int i = 0 ; i < sizes.length ; i++){
            sizes[i] = Integer.parseInt(st.nextToken());
        }

        // 묶음
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());   // 티셔츠 묶음 수
        int p = Integer.parseInt(st.nextToken());   // 펜 묶음 수

        // [1] 셔츠 묶음
        int countT = 0;
        for(int i = 0 ; i< sizes.length ; i++){
            // 나누어지는 수 만큼 구매
            countT += sizes[i] / t;
            // 티셔츠는 남아도 되니, 나머지가 있다면 한 묶음 추가 구매
            if( sizes[i]%t != 0 ) countT++;
        }
        sb.append(countT).append("\n");

        // [2] 펜 묶음과 나머지
        sb.append( n / p ).append(" ").append(n%p);

        System.out.println(sb);

    } // func end
} // class end
