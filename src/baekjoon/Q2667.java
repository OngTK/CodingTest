package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 2667
 * 단지 번호 붙이기
 *
 * 문제
 *     1은 집이 있는 곳을, 0은 집이 없는 곳
 *     연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 함
 * 입력
 *     첫째줄 지도의 크기 N
 *     각 집의 상태 0 or 1
 * 출력
 *     첫째 줄 : 총 단지 수
 *     둘째 줄 : 단지 내 집의 수를 오름차순 정렬하여 한 줄씩 출력
 * */


public class Q2667 {
    static int N;
    static int[][] houses;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1}, dy = {-1, 1, 0 , 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        houses = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0 ; i < N ; i++ ){
            String s = br.readLine();
            for(int j = 0 ; j < N ; j++){
                houses[i][j] = s.charAt(j) - '0';
            }
        }
        int count = 0;
        List<Integer> results = new LinkedList<>();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if( houses[i][j] == 1 && !visited[i][j]) {
                    int sum = bfs(i, j);
                    results.add(sum);
                    count++;
                }
            }
        }
        Collections.sort(results);
        sb.append(count).append("\n");
        for(int i : results){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    } // main end

    static int bfs(int a, int b){
        visited[a][b] = true;
        int count = 1 ;

        for (int i = 0 ; i < 4 ; i++){
            int nextX = a + dx[i];
            int nextY = b + dy[i];

            if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N ){
                if( houses[nextX][nextY] == 1 && !visited[nextX][nextY] ){
                    count += bfs(nextX, nextY);
                }
            }
        }
        return count;
    } // func end
} // class end
