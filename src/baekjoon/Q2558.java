package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1012
 * A+B -2
 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성
 * */

public class Q2558 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        System.out.println(A+B);

    }
}
