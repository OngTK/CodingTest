package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 7568
 * 덩치
 * <p>
 * 문제
 * 몸무게 x kg, 키 y cm ⇒ 덩치 (x,y)
 * 입력
 * 첫째 줄 : N 사람수
 * 둘째 줄 이하 : 몸무게와 키
 * 출력
 * 덩치 등 수를 공백을 포함하여 한 줄로 표현
 */

public class Q7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] people = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
            people[i][1] = Integer.parseInt(st.nextToken()); // 키
        }

        int rank;
        int[] person = new int[2];
        for (int i = 0; i < N; i++) {
            person = people[i];
            rank = 1;
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    if ((person[0] < people[j][0]) && (person[1] < people[j][1])) {
                        rank++;
                    }
                }
            } // for j end
            sb.append(rank).append(" ");
        } // for i end
        System.out.println(sb);
    } // main end
} // class end
