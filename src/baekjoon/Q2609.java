package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2609
 * 최대공약수와 최소공배수
 *
 * 문제
 *     두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성
 * 입력
 *     첫째 줄 두개의 정수
 * 출력
 *     첫째 줄 : 최대 공약수
 *     둘째 줄 : 최대 공배수
 * */

public class Q2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        br.close();

        int g = gcd(a,b);
        int l = a * b / g ;

        sb.append(g).append("\n").append(l);
        System.out.println(sb);

    } // main end

    /*
    * 유클리드 호제법
    * A, B의 최대공약수는 r
    * r = A mod B
    *
    * 이때 최대공약수 = A * B / r
    * */

    private static int gcd(int a, int b){
        if( b == 0 ) return a;
        return gcd(b, a%b);
    } // func end

} // class end
