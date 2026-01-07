package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 25682
 * 체스판 다시 칠하기2
 *
 * 문제
 *      M x N 크기의 보드 => K x K 크기의 체스판으로 만듦
 *      체스판은 검정-흰색이 번갈아 칠해져 있어야 함
 *
 *      다시 칠해야 하는 정사각형의 최소 개수를 구하시오
 * 입력
 *  첫째줄
 *      N M K
 *      열 갯수 x 행 갯수 x 자를 정사각형 크기
 *  둘째줄
 *      각 보드의 행
 *      B 검정 / W 흰색
 * 출력
 *      첫째 줄에 지민이가 잘라낸 K×K 보드를 체스판으로 만들기 위해
 *      다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.
 * */

public class Q25682 {
    // 체스판
    static char[][] chessBoard;
    // setting
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫째줄
        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        K = Integer.parseInt(st.nextToken()); // 자를 크기

        // 체스판
        chessBoard = new char[N][M];
        char[] tmp;
        for(int i = 0 ; i < N ; i ++){
            tmp = br.readLine().toCharArray(); // 한 줄을 1차원 문자 배열로 저장
            for(int j = 0 ; j < M ; j++ ) {
                chessBoard[i][j] = tmp[j]; // 체스판에 하나씩 삽입
            }
        }

        // B or W로 시작할 때의 누적합
        int[][] prefixSumBlack = prefixSum('B'); // B로 시작할 때 누적 합
        int[][] prefixSumWhite = prefixSum('W'); // W로 시작할 때 누적 합

        // 체스판 자르기
        int result = Math.min(cutChessBoard(prefixSumBlack),cutChessBoard(prefixSumWhite));
        System.out.println(result);

    } // main end

    // 체스 누적합 구하기 func =====================================================
    private static int[][] prefixSum(char color){
        int[][] tmp = new int[N+1][M+1];

        for(int i = 0; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                // 스타트 지점을 0
                int currentValue = 0;
                if((i+j) % 2 == 0){
                    // 시작과 2배수로 떨어진 셀
                    // 스타트가 W면 인접 셀 W, 스타트가 B이면 인접 셀 B
                    currentValue = chessBoard[i][j] == color ? 0 : 1;
                } else {
                    // 인접한 셀
                    // 스타트가 W면 인접 셀 B, 스타트가 B이면 인접 셀 W
                    currentValue = chessBoard[i][j] != color ? 0 : 1;
                }
                // 누적셀에 삽입
                tmp[i+1][j+1] = tmp[i+1][j] + tmp[i][j+1] - tmp[i][j] + currentValue;
            }
        }
        return tmp;
    } // func end

    // 체스판 자르기 ==================================================================
    private static int cutChessBoard(int[][] prefixSum){
        int result = Integer.MAX_VALUE;

        for(int i = 1 ; i <= N-K +1 ; i++ ){
            for(int j = 1 ; j <= M-K+1 ; j++ ){
                int num = prefixSum[i+K-1][j+K-1]
                        - prefixSum[i-1][j+K-1] - prefixSum[i+K-1][j-1]
                        + prefixSum[i-1][j-1];
                result = Math.min(num, result);
            }
        }
        return result;
    } // func end

} // class end
