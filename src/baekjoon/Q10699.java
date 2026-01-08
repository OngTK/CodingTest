package baekjoon;

/**
 * 백준 10699
 * 오늘 날짜
 *
 * 문제
 *      서울의 오늘 날짜를 출력하는 프로그램을 작성
 * 입력
 *      X
 * 출력
 *      서울의 오늘 날짜를 "YYYY-MM-DD" 형식으로 출력한다.
 * */

import java.time.LocalDate;

public class Q10699 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
    }
} // class end
