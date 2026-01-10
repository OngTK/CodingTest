package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String answer;
        int result , point ;
        for(int i = 0 ; i < n ; i++ ){
            answer = br.readLine();
            result = 0;
            point = 0;

            for(int j = 0 ; j < answer.length() ; j++){
                if( answer.charAt(j) == 'O' ){
                    point++;
                    result += point;
                } else {
                    point = 0;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    } // main end
} // class end
