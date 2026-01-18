package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 백준 11723
 * 집합
 *
 * 문제
 *     - `add x`: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
 *     - `remove x`: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
 *     - `check x`: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
 *     - `toggle x`: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
 *     - `all`: S를 {1, 2, ..., 20} 으로 바꾼다.
 *     - `empty`: S를 공집합으로 바꾼다.
 * 입력
 *     첫째 줄에 수행해야 하는 연산의 수 M (1 ≤ M ≤ 3,000,000)
 *     둘째 줄부터 M개의 줄에 수행해야 하는 연산
 * 출력
 *     `check` 연산이 주어질때마다, 결과를 출력
 *
 * */
public class Q11723 {

    private static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int S = 0;
        int M = Integer.parseInt(br.readLine());

        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("all")){
                S = (1 << 21) - 1;
            } else if(str.equals("empty")){
                S = 0;
            } else {
                int num = Integer.parseInt(st.nextToken());
                if(str.equals("add")){
                    S |= (1 << num);
                } else if (str.equals("remove")){
                    S &= ~(1 << num);
                } else if (str.equals("check")){
                    sb.append((S & (1 << num)) != 0 ? 1 : 0 ).append("\n");
                } else if (str.equals("toggle")){
                    S ^= (1 << num);
                }
            }
        }
        System.out.println(sb);
    } // main

} // class end
