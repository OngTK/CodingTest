package baekjoon;

/**
 * 백준 1271
 * 엄청난 부자
 *
 * 문제
 *      돈을 동일하게 배분하고 남는 돈을 계산
 * 입력
 *      첫째줄
 *          n : 가진돈
 *          m : 나눌 수
 * 출력
 *      몫 / 나머지
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Q1271 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(n.divide(m)).append("\n").append(n.remainder(m));
        System.out.println(sb);
    }
}
