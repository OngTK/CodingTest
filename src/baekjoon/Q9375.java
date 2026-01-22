package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 백준 9375
 * 패션왕 신해빈
 *
 * 문제
 *     한 번 입었던 옷 조합은 절대 다시 입지 않음
 * 입력
 *     첫째 줄 : 테스트 케이스 ≤ 100
 *     둘째 줄 : 각 테스트 케이스
 *         - 가진 의상의 수
 *         - 의상의 이름과 종류
 * 출력
 *     각 테스트 케이스에 대해 해빈이가 알몸이 아닌 상태로 의상을 입을 수 있는 경우를 출력
 * */

public class Q9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        while (T-- > 0){
            HashMap<String, Integer> hm = new HashMap<>(); // <종류, 갯수>
            int N = Integer.parseInt(br.readLine());

            while( N -- > 0){
                st = new StringTokenizer(br.readLine(), " ");
                st.nextToken(); // 옷 이름 생략
                String kind = st.nextToken();

                // 종류가 존재하면 갯수 +1 / 없으면 종류와 갯수 1 생성
                if(hm.containsKey(kind)) {
                    hm.put(kind, hm.get(kind) + 1 );
                } else {
                    hm.put(kind, 1);
                }
            }
            int result = 1;
            // 종류  * 종류 * ....  - 1
            for(int val : hm.values()){
                result *= (val +1);
            }
            sb.append(result -1).append("\n");
        }
        System.out.println(sb);
    } // main end
} // class end
