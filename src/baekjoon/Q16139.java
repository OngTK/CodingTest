package baekjoon;

/**
 * 백준 16139
 *
 * 문제
 *      '문자열에서 특정 알파벳이 몇 번 나타나는지 알아봐서
 *      자주 나타나는 알파벳이 중지나 검지 위치에 오는 알파벳인지 확인하면
 *      실용적인지 확인할 수 있을 것이다.'
 *      특정 문자열 S, 특정 알파벳 a, 문자열 구간 [l,r]이 주어짐
 *      s의 l번째 문자부터 r 번째 문자 사이에 a가 몇 번 나타나는지 구하는 프로그램 작성
 *      이를 q 번 질문
 * 입력
 *      첫째 줄 : S - 문자열 : 200,000자 이하, 소문자로만 구성
 *      둘째 줄 : q - 질문수
 *      세번째 줄 : a l r
 * 출력
 *      각 질문바다 줄을 구분해 순서대로 답변
 * SubTask1
 *      문자열의 길이는 2,000자 이하, 질문 수는 2,000개 이하
 * SubTask2
 *      추가 제한 조건이 없음
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Q16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 첫째줄
        String S = br.readLine(); // 문자열
        // 둘째줄
        int q = Integer.parseInt(br.readLine()); // 반복 횟수

        // 누적합 기록을 위한 알파벳 배열
        int[][] alphabet = new int[S.length() + 1][26];

        // S 누적합 계산
        for(int i = 1 ; i <= S.length(); i++){
            int index = S.charAt(i-1) - 'a';
            for(int j = 0 ; j < alphabet[i].length; j++){
                alphabet[i][j] = alphabet[i-1][j] + (index == j ? 1 : 0 ) ;
            }
        }

        // 셋째줄 이하
        for(int i = 0 ; i < q ; i++) {
            st = new StringTokenizer(br.readLine());
            int index = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int result = alphabet[end+1][index] - alphabet[start][index];
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    } // main end
} // class end

// 50점 ===========================================================
// 부분합 고려 X
//public class Q16139 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
//
//        // 첫째줄
//        String S = br.readLine(); // 문자열
//
//        // 둘째줄
//        int q = Integer.parseInt(br.readLine()); // 반복 횟수
//
//        // 셋째줄 이하
//        for(int i = 0 ; i < q ; i++){
//            st = new StringTokenizer(br.readLine());
//            String alpha = st.nextToken();
//            char c = alpha.charAt(0);
//            int start = Integer.parseInt(st.nextToken());
//            int end = Integer.parseInt(st.nextToken());
//
//            String s = S.substring(start, end+1);
//
//            if(!s.contains(alpha)){
//                sb.append(0 + "\n");
//            } else {
//                int sum = 0;
//
//                for(int j = 0 ; j < s.length() ; j++){
//                    if( s.charAt(j) == c ) sum++;
//                }
//                sb.append(sum + "\n");
//            }
//        }
//        System.out.println(sb);
//    } // main end
//} // class end
