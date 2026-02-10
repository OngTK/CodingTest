package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 14940
 * 쉬운 최단거리
 * <p>
 * 문제
 * 지도가 주어지면 모든 지점에 대해서 목표지점까지의 거리를 구하여라
 * 입력
 * 지도의 크기 n과 m (2 ≤ n ≤ 1000, 2 ≤ m ≤ 1000)
 * 0은 갈 수 없는 땅이고 1은 갈 수 있는 땅, 2는 목표지점
 * 출력
 * 각 지점에서 목표지점까지의 거리를 출력
 * 원래 갈 수 없는 땅인 위치는 0을 출력
 * 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치는 -1
 *
 */

public class Q14940 {
    static int N, M, x, y;
    static int[][] map, result;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        result = new int[N][M];
        visited = new boolean[N][M];

        // 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    x = i;
                    y = j;
                } else if (map[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        // bfs 실행
        bfs(x,y);

        // 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    result[i][j] = -1;
                }
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    } // main end

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int tmp[] = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = tmp[0] + dx[i];
                int nextY = tmp[1] + dy[i];

                if(nextX >=0 && nextY >=0 && nextX < N && nextY < M){
                    if(!visited[nextX][nextY] && map[nextX][nextY] == 1 ){
                        visited[nextX][nextY] = true;
                        result[nextX][nextY] = result[tmp[0]][tmp[1]] + 1;
                        q.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
    } // func end
} // class end
