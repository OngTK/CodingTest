package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 17219
 * 비밀번호 찾기
 *
 * 문제
 *     비밀번호 찾기
 * 입력
 *     첫째 줄 : 저장된 주소의 개수 N, 비밀번호를 찾으려는 사이트 주소의 수 M
 *     둘째 줄 ~ N : 각 사이트의 주소와 비밀번호
 *     N+2 ~ M개의 줄 : 비밀번호를 찾으려는 사이트 주소가 한줄에 하나씩 입력
 * 출력
 *     찾으려는 사이트 주소의 비밀번호 출력
 * */

public class Q17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String,Object> loginInfo = new HashMap<>();
        for( int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");

            loginInfo.put(st.nextToken(), st.nextToken());
        }

        for(int i = 0 ; i < M ; i++){
            sb.append(loginInfo.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    } // main end
} // class end
