package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2754
 * 학점 계산
 * */

public class Q2754 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String p = br.readLine();

        if (p.equals("F")){
            System.out.println("0.0");
            return;
        }

        double grade = 4.0 - (p.charAt(0)- 'A' );

        char d = p.charAt(1);
        if(d == '+'){
            grade += 0.3;
        } else if (d == '-'){
            grade -= 0.3;
        }
        System.out.println(grade);
    } // main end
} // class end
