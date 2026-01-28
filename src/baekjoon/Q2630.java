package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2630
 * 색종이 만들기
 *
 * 문제
 *     정사각형으로 채워진 정사각형 종이
 *     파란색 1 / 흰색 0
 *     일정한 규칙에 따라 잘라서 다양한 크기를 가진 정사각형 모양의 하얀색 또는 파란색 종이를 만든다
 *     전체가 같은 색이 아니면 가로 세로의 중간 부분에서 자름 ⇒ 똑같은 크기의 네개의 정사각형
 *     하얀색, 파란색 종이의 개수를 구하는 프로그램
 * 입력
 *     첫째 줄 한 변의 길이 N
 *     둘째 줄 이하 각 칸의 색
 * 출력
 *     첫째 줄 : 흰색 종이 수
 *     둘째 줄 : 파란 종이 수
 * */

public class Q2630 {
    static int whiteCount = 0 , blueCount = 0;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++ ){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0,0,N);

        sb.append(whiteCount).append("\n").append(blueCount);
        System.out.println(sb);
    } // main end

    static void partition(int row, int col, int size){
        if(colorCheck(row, col, size)){
            if(paper[row][col] == 0){
                whiteCount++;
            } else {
                blueCount++;
            }
            return;
        }

        int newSize = size / 2 ;

        partition(row, col, newSize);
        partition(row, col+ newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row+newSize, col+newSize, newSize);
    } // func end

    static boolean colorCheck(int row, int col, int size){
        int color = paper[row][col];
        for(int i = row ; i < row + size ; i++ ){
            for(int j = col ; j < col + size ; j++ ){
                if(paper[i][j] != color) return false;
            }
        }
        return true;
    } // func end

} // class end
