package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1012
 * 유기농 배추
 *
 * 문제
 *     배추를 군데 군데 심어 놓음
 *     배추흰지렁이는 상하좌우의 인접한 배추로 이동하여 보호 가능
 * 입력
 *     첫 줄 : 테스트 케이스 T
 *     T1 : 가로길 이 M / 세로 길이  N / 배추의 갯수 K
 *     K : X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)
 * 출력
 *     각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력
 * */

public class Q1012 {
    static int m, n, k;
    static int[][] arr;
    static boolean[][] check;
    static int count;

    // 상하좌우 이동을 위한 배열
    static int[] dx = {0, -1, 0 ,1 };
    static int[] dy = {1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int x, y;

        while(t-- > 0){
            count = 0;
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[m][n];
            check = new boolean[m][n];

            while(k-- > 0){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            for(int a = 0 ; a < m ; a++){
                for(int b = 0 ; b < n ; b++){
                    if(arr[a][b] == 1 && !check[a][b]){
                        visit(a, b);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    } // main end

    static void visit(int x, int y){
        check[x][y] = true;

        for(int i = 0 ; i < 4 ; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx >= 0 && cy >=0 && cx < m && cy < n){
                if( !check[cx][cy] && arr[cx][cy] == 1 ){
                    visit(cx, cy);
                }
            }
        }
    } // func end

} // class end
