package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 1697
 * 숨바꼭질
 *
 * 문제
 *     수빈이 위치 N (0 ≤ N ≤ 100,000)
 *     동생 위치 K (0 ≤ K ≤ 100,000)
 *     걷기 : 1초 후 ± 1 이동
 *     순간이동 : 1초 후 2 * N 으로 이동
 *     수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지
 * 입력
 *     수빈위치 N 동생위치 K
 * 출력
 *     동생을 찾는 가장 빠른 시간
 * */

public class Q1697 {
    static int N, K, count = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        bfs(N);
    } // main end

    static void bfs(int start){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while(!queue.isEmpty()){
            int p[] = queue.poll();

            if( p[0] == K ){
                System.out.println(p[1]);
                return;
            }

            for(int i = 0 ; i < 3 ; i++){
                int next;
                if( i == 0 ){
                    next = p[0] - 1 ;
                } else if( i == 1 ) {
                    next = p[0] + 1 ;
                } else {
                    next = p[0] * 2 ;
                }

                if( next >= 0 && next <= 100000 && !visited[next] ){
                    queue.add(new int[]{next,  p[1]+1 });
                    visited[next] = true;
                }
            }
        } // while end
    } // func end

} // class end
