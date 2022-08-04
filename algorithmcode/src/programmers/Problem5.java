package programmers;
import java.util.*;

//프로그래머스 모의고사 문제
//https://school.programmers.co.kr/learn/courses/30/lessons/42840#
//완전탐색 문제다. 탐색방식은 좀 더 생각해봐도 될듯하다
public class Problem5 {
    public static int num = 1;
    public static HashMap<Integer,Integer> map = new HashMap<>();
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        exam(one,answers);
        exam(two,answers);
        exam(three,answers);

        return map.keySet().stream()
                .mapToInt(Integer::intValue).toArray();
    }
    public void exam(int[] student,int[] answers){
        int n = student.length;
        int value = 0;
        for(int i=0;i<answers.length;i++){
            if(student[i%n]==answers[i])
                value++;
        }

        if(!map.isEmpty()){
            for(int i : map.keySet()){
                if(map.get(i)<value){
                    map.remove(i);
                }
                else if(map.get(i)>value){
                    num++;
                    return;
                }
            }

        }
        map.put(num++,value);


    }
}
