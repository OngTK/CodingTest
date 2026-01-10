package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[8];
        for(int i = 0 ; i < numbers.length ; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        String result = "";
        for(int i = 1 ; i < numbers.length ; i++){
            if(numbers[i-1] - numbers[i] == -1){
                result = "ascending";
            } else if(numbers[i-1] - numbers[i] == 1){
                result = "descending";
            } else {
                result = "mixed";
                break;
            }
        }
        System.out.println(result);
    } // main end
} // class end
