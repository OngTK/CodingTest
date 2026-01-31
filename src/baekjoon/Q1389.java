package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 백준 1389
 * 케빈 베이컨의 6단계 법칙
 *
 * 문제
 *     지구에 있는 모든 사람들은 최대 6단계 이내에서 서로 아는 사람으로 연결될 수 있다.
 *     케빈 베이컨 게임은 임의의 두 사람이 최소 몇 단계 만에 이어질 수 있는지 계산하는 게임
 * 입력
 *     첫째 줄 : 유저의 수 N, 친구 관계의 수 M
 *     둘째 줄 이하 : M개의 관계
 * 출력
 *     케빈 베이컨의 수가 가장 작은 사람의 수 출력
 * */

public class Q1389 {
    static int N, M, count = 0;
    static int[][] relation;
    static boolean[] visited;
    static Deque<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        relation = new int[N][N];

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1 ;
            int b = Integer.parseInt(st.nextToken()) - 1 ;
            relation[a][b] = relation[b][a] = 1;
        }

        int answer = 0;
        int tmp = Integer.MAX_VALUE;

        for(int i = N - 1 ; i >= 0 ; i--){
            visited = new boolean[N];
            count = 0 ;
            bfs(i);

            if(count <= tmp){
                tmp = count;
                answer = i+1;
            }
        }
        System.out.println(answer);
    } // main end

    static void bfs(int a){
        visited[a] = true;
        q.addLast(new int[]{a, 1});
        while (!q.isEmpty()){
            int[] tmp = q.removeFirst();
            int node = tmp[0];
            int cnt = tmp[1];
            for(int i = 0 ; i < N ; i++){
                if(!visited[i] && relation[node][i] == 1){
                    visited[i] = true;
                    count += cnt;
                    q.addLast(new int[]{i, cnt+1});
                }
            }
        }
    } // func end
} // class end
