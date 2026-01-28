package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2805
 * 나무 자르기
 * <p>
 * 문제
 * 나무 M 미터 필요
 * 절단긱에 높이 H 지정, 나무가 H보다 크면 H 위에가 잘리고, 그보다 작은 나무는 잘리지 않음
 * 나무는 한 줄로 되어 있음
 * M미터를 가져가기 위해서
 * 입력
 * 첫째 줄 : 나무의 수 N , 필요한 길이 M
 * 둘재줄 : N 개 나무의 높이
 * 출력
 * 절단기의 최대 높이
 *
 */

public class Q2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int min = 0, max = 0;
        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (max < trees[i]) max = trees[i];
        }

        // 이분 탐색
        while (min < max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for (int tree : trees) {
                if (tree - mid > 0) {
                    sum += (tree - mid);
                }
            }

            if (sum < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min-1);

    } // main end
} // class end
