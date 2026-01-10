package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        br.close();

        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            // 대문자면 > 소문자
            if(Character.isUpperCase(c)){
                sb.append(Character.toLowerCase(c));
            } // 소문자면 > 대문자
            else {
                sb.append(Character.toUpperCase(c));
            }
        }
        System.out.println(sb);
    } // main end
} // class end
