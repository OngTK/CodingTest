package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 백준 7569
 * 토마토
 * <p>
 * 문제
 * 격자모양 상자를 수직으로 쌓아 보관
 * 익은 토마토와 인접한 익지 않은 토마토는 하루 후에 익게 됨
 * 인접 = 6방향
 * 창고에 토마토들이 모두 익는데 걸리는 일 수
 * 입력
 * 첫째 줄: 상자의 크기와 높이 - M, N, H
 * 둘재 줄 : 가장 밑의 상자부터 가장 위 상자까지 토마토의 정보
 * 1 - 익은토마토
 * 0 - 안 익은 토마토
 * -1 - 빈칸
 * 출력
 * 토마토가 모두 익는 데 걸리는 시간
 *
 */
public class Q7569 {
    static int M, N, H;
    static int[] dx = {1, -1, 0, 0, 0, 0},
            dy = {0, 0, 1, -1, 0, 0},
            dz = {0, 0, 0, 0, 1, -1};
    static int[][][] boxes;
    static Deque<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        boxes = new int[H][N][M];

        // 전체 익었는지 확인하기 위한 boolean
        boolean alreadyFinished = true;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    boxes[i][j][k] = Integer.parseInt(st.nextToken());

                    if (boxes[i][j][k] == 1) {
                        // 익은 토마토를 queue에 저장
                        queue.addLast(new int[]{i, j, k, 0});
                    }

                    if (boxes[i][j][k] == 0) {
                        // 안익은 토마토가 1개라도 있으면 false
                        alreadyFinished = false;
                    }
                }
            }
        }

        // 모두 익음 = 0일 = 종료
        if (alreadyFinished) {
            System.out.println(0);
            return;
        }

        int answer = bfs();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(boxes[i][j][k] == 0){
                        answer = -1; // 하나라도 익지 않은 곳이 있으면 -1
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    } // main end

    static int bfs() {
        int days = 0;
        while (!queue.isEmpty()) {
            int[] tno = queue.removeFirst();
            int z = tno[0];
            int x = tno[1];
            int y = tno[2];
            days = tno[3]; // 익는데 걸리는 일 수

            for (int i = 0; i < 6; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                int nextZ = z + dz[i];

                if (nextX < 0 || nextY < 0 || nextZ < 0 || nextX >= N || nextY >= M || nextZ >= H) {
                    continue;
                }

                if (boxes[nextZ][nextX][nextY] == 0) {
                    boxes[nextZ][nextX][nextY] = 1;
                    queue.addLast(new int[]{nextZ, nextX, nextY, days + 1});
                }
            }
        }
        return days;
    } // func end
} // class end
