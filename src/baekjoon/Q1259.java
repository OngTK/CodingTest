package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1259
 * 팰린드롬
 *
 * 문제
 *     앞으로 읽어도 뒤로 읽어도 똑같은 단어 ⇒ 팰린드롬
 * 입력
 *     여러 케이스
 *     마지막 줄에 0 이 주어지면 종료
 * 출력
 *     팰린드롬이면 yes 아니면 no
 * */

public class Q1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(;;){
            int n = Integer.parseInt(br.readLine());

            if( n == 0 ) break;

            String s = n + "";
            String b = "";
            for(int i = s.length() - 1 ; i >= 0 ; i-- ){
                b += s.charAt(i);
            }

            if(s.equals(b)){
                sb.append("yes");
            } else {
                sb.append("no");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    } // main end
} // class end
