package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 1260
 *
 * DFS와 BFS
 *
 * 문제
 *     그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성
 *     방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료
 * 입력
 *     첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000),
 *         간선의 개수 M(1 ≤ M ≤ 10,000),
 *         탐색을 시작할 정점의 번호 V
 *     다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어짐
 *         어떤 두 정점 사이에 여러 개의 간선이 있을 수 있음
 *         입력으로 주어지는 간선은 양방향
 * 출력
 *     첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력
 * */

public class Q1260 {

    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;
    static int node, line, start;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        arr = new int[node+1][node+1];
        check = new boolean[node+1];

        for(int i = 0 ; i < line ; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }
        dfs(start);
        sb.append("\n");

        check = new boolean[node+1];
        bfs(start);
        System.out.println(sb);
    } // main end

    static void dfs(int start){
        check[start] = true;
        sb.append(start).append(" ");

        for(int i = 0 ; i <= node ; i++){
            if(arr[start][i] == 1 & !check[i]){
                dfs(i);
            }
        }
    } // func end

    static void bfs(int start){
        q.add(start);
        check[start] = true;

        while(!q.isEmpty()){
            start = q.poll();
            sb.append(start).append(" ");

            for(int i = 1 ; i <= node ; i++){
                if(arr[start][i] == 1 && !check[i]){
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    } // func end

} // class end
