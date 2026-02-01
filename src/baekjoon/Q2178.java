package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2178
 * 미로 탐색
 *
 * 문제
 *     N×M크기의 배열로 표현되는 미로
 *     1은 이동할 수 있고 0은 이동할 수 없음
 *     (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램
 * 입력
 *     첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)
 *     둘째 줄 이하는 미로가 표시
 * 출력
 *     첫째 줄에 지나야 하는 최소의 칸 수
 * */

public class Q2178 {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0 ; i < N ; i++ ){
            String s = br.readLine();
            for (int j = 0 ; j < M ; j++){
                maze[i][j] = s.charAt(j) - '0' ;
            }
        }

        visited[0][0] = true;
        bfs(0,0);

        System.out.println(maze[N-1][M-1]);
    } // main end

    static void bfs(int a, int b){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});

        while (!q.isEmpty()){
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0 ; i < 4 ; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M ) continue;
                if(visited[nextX][nextY] || maze[nextX][nextY] == 0) continue;

                q.add(new int[] {nextX, nextY});
                maze[nextX][nextY] = maze[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }
        } // while end
    } // func end
} // class end
