package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 7576
 * 토마토
 * <p>
 * 문제
 * 격자 모양의 상자에 토마토를 보관
 * 익은 토마토에 인접한 인익은 토마토는 다음날 익음
 * 토마토가 전부 익는 최소 일수를 구하시오
 * 입력
 * 상자의 크기 M N
 * 1 - 익은 토마토
 * 0 - 안익은 토마토
 * -1 - 빈 칸
 * 출력
 * 토마토가 모두 익는 최소 날짜 출력
 * 모든 토마토가 익은 상태로 상자에 담겼으면 0을 출력
 * 토마토가 모두 익지 못하는 상황이면 -1
 *
 */

public class Q7576 {
    static int M, N;
    static int[][] box;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Deque<int[]> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        boolean check = true;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    deque.addLast(new int[]{i, j, 0});
                }
                if (box[i][j] == 0) {
                    check = false;
                }
            }
        }

        if (check) {
            System.out.println(0);
            return;
        }
        int resultDays = bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    resultDays = -1;
                    break;
                }
            }
        }
        System.out.println(resultDays);

    } // main end

    static public int bfs() {
        int day = 0;
        while (!deque.isEmpty()) {
            int[] d = deque.removeFirst();
            int x = d[0];
            int y = d[1];
            day = d[2];

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }

                if (box[nextX][nextY] == 0) {
                    box[nextX][nextY] = 1;
                    deque.addLast(new int[]{nextX, nextY, day + 1});
                }
            }
        }
        return day;
    } // func end

} // class end
