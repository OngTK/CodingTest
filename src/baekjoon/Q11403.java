package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11403
 * 경로 찾기
 *
 * 문제
 *     가중치 없는 방향 그래프 G
 *     모든 정점 ( i , j )에 대해 i에서 j로 가는 길이가 양수인 경로가 있는 지 없는 지 구하시오
 * 입력
 *     첫째 줄 : 정점의 개수 N (1 ≤ N ≤ 100)
 *     둘째 줄 : N개 줄, 그래프의 인접 행렬
 *         i번째 줄의 j의 숫자가 1인 경우에는 i에서 j로 가는 간선이 존재
 *         i에서 i는 항상 0
 * 출력
 *     총 N개의 줄에 걸쳐서 문제의 정답을 인접행렬 형식으로 출력
 *     정점 i에서 j로 가는 길이가 양수인 경로가 있으면 i 번째 줄의 j 번째 숫자를 1 or 0
 * */
public class Q11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] path = new int[N][N];
        for( int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                path[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플루이드-위셜 알고리즘
        for(int k = 0 ; k < N ; k++){
            for( int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(path[i][k] == 1 && path[k][j] ==1 ){
                        path[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                sb.append(path[i][j]).append(' ');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    } // main end
} // class end
