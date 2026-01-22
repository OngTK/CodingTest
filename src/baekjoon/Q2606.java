package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2606
 * 바이러스
 *
 * 문제
 *     1번 컴퓨터가 웜 바이러스에 감염
 *     컴퓨터 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때,
 *     1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터 수를 출력
 * 입력
 *     첫째 줄 : 컴퓨터의 수 < 100 이하, 각 컴퓨터는 1번부터 번호를 매김
 *     둘째 줄 : 네트워크 상에서 직접 연결되어 있는 컴퓨터의 쌍의 수
 *     그 수 만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍
 * 출력
 *     1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력
 * */

public class Q2606 {

    static boolean[] check;
    static int[][] arr;
    static int count = 0;
    static int node, line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        node = Integer.parseInt(br.readLine()); // 컴퓨터 대 수
        line = Integer.parseInt(br.readLine()); // 관계 수

        arr = new int[node+1][node+1];
        check = new boolean[node+1];

        int a,b;
        for(int i = 0 ; i < line ; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }
        dfs(1);
        System.out.println(count - 1);
    } // main end
    public static void dfs(int a){
        check[a] = true;
        count++;
        for(int i = 0 ; i <= node ; i++){
            if(arr[a][i] == 1 && !check[i]){
                dfs(i);
            }
        }

    }
} // class end
