package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 백준 30804
 * 과일 탕후루
 *
 * 문제
 *     N개의 과일이 꽂혀있는 과일 탕후루
 *     과일의 종류는 1~9
 *     과일의 종류는 두개 이하
 *     앞, 뒤에서 몇 개의 과일을 빼서 두 종류 이하의 과일만 만들기
 *     이렇게 만들 수 있는 두 종류 이하 탕후루 중 과일의 개수가 가장 많은 탕후루
 * 입력
 *     첫 줄에 과일의 개수 N (1≤N≤200000)
 *     탕후루에 꽂힌 과일을 의미한는 S1 ~ Sn
 * 출력
 *     과일 두 종류 이하의 탕후루 중 과일의 개수가 가장 많은 탕후루의 과일 개수 출력
 * */

public class Q30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] fruits = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 배열에 과일 번호 저장
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        // 현재 구간(window)에 포함된 과일 종류별 개수를 저장하는 맵
        HashMap<Integer, Integer> fruitsCnt = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        // 오른쪽 포인터를 한 칸씩 늘려가며 구간을 확장
        for (int right = 0; right < N; right++) {
            // right 위치의 과일을 맵에 추가
            // 이미 있으면 +1, 없으면 0으로 시작해서 +1
            fruitsCnt.put(fruits[right], fruitsCnt.getOrDefault(fruits[right], 0) + 1);

            // 만약 현재 구간에 포함된 과일 "종류"가 2개를 초과하기 전까지 반복
            while (fruitsCnt.size() > 2) {
                // left 위치 과일 개수 1 감소
                fruitsCnt.put(fruits[left], fruitsCnt.get(fruits[left]) - 1);

                // 감소 결과 개수가 0이면
                // 맵에서 제거 → 과일 종류 수 감소
                if (fruitsCnt.get(fruits[left]) == 0) {
                    fruitsCnt.remove(fruits[left]);
                }

                // 왼쪽 포인터를 오른쪽으로 이동 → 구간 축
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        System.out.println(maxLength);
    } // main end
} // class end
