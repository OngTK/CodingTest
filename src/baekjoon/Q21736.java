package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 백준 21736
 * 헌내기는 친구가 필요해
 * <p>
 * 문제
 * N * M 크기
 * 상하좌우로 이동
 * 도연이가 만날 수 있는 사람의 수를 출력
 * 입력
 * 첫째 줄 : N, M ( 1 ≤ N, M ≤ 600 )
 * 둘째 줄 : 0는 빈 공간, X는 벽, I는 도연이, P는 사람
 * 출력
 * 만날 수 있는 사람의 수
 * 아무도 못 만나면 TT
 *
 */

public class Q21736 {
    static int n, m;
    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static Deque<int[]> q = new ArrayDeque<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            if(q.isEmpty()){
                for(int j = 0 ; j < m ; j++){
                    if(map[i][j] == 'I'){
                        // I에 위치 큐에 삽입
                        q.addLast(new int[]{i, j});
                        visited[i][j] = true;
                        break;
                    }
                }
            }
        }
        bfs();
        System.out.println( count > 0 ? count : "TT" );

    } // main end

    static void bfs(){
        while(!q.isEmpty()){
            int[] tmp = q.removeFirst();
            int x = tmp[0];
            int y = tmp[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                    continue;
                }
                // 벽이 아니고 방문한 적이 없으면 체크
                if(map[nx][ny] != 'X' && !visited[nx][ny]){
                    if(map[nx][ny] == 'P'){
                        count++;
                    }
                    visited[nx][ny] = true;
                    q.addLast(new int[]{nx, ny});
                }
            }
        }
    } // func end
} // class end
