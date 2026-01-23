package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 11726
 * 2×n 타일링**
 * <p>
 * 문제
 * 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성
 * 입력
 * 첫째줄 n
 * 출력
 * 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력
 * <p>
 * 직접 그려보니
 * 1 → 2 → 3 → 5 → 8 → ...
 * 규칙적으로 증가
 */

public class Q11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[1001];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = ( arr[i - 1] + arr[i - 2] ) % 10007;
        }
        System.out.println(arr[n]);

    } // main end
} // class end
