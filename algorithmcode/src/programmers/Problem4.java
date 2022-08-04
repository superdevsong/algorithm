package programmers;

import java.util.*;
//프로그래머스 K번째수
//https://school.programmers.co.kr/learn/courses/30/lessons/42748
//간단히 정렬을 사용하는 문제다.
class Problem4 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        for (int[] command : commands) {
            int[] copy = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(copy);
            answer[index] = copy[command[2] - 1];
            index++;

        }
        return answer;
    }
}