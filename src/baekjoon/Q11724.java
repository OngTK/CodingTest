package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 11724
 * 연결 요소의 개수
 *
 * 문제
 *     방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램
 * 입력
 *     첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000) | 간선의 개수 M  (0 ≤ M ≤ N×(N-1)/2)
 *     둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v  (1 ≤ u, v ≤ N, u ≠ v)
 * 출력
 *     첫째 줄에 연결 요소의 개수
 * */

public class Q11724 {
    static int N, M, count = 0;
    static boolean[][] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N+1][N+1];
        visit = new boolean[N+1];

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = graph[v][u] = true;
        } // while end

        for(int i = 1 ; i <= N; i++){
            if(!visit[i]){
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    } // main end

    static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visit[s] = true;

        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i = 1 ; i <= N ; i++){
                if( graph[tmp][i] && !visit[i] ){
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    } // func end

} // class end
