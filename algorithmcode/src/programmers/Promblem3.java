package programmers;

import java.util.*;
//프로그래머스 신고결과 받기문제
//https://school.programmers.co.kr/learn/courses/30/lessons/92334
//Hash와 set을 활용해 중복값이 없게 풀었다.
class Promblem3 {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String,Integer> users = new HashMap<>();
        HashMap<String,HashSet<String>> reports = new HashMap<>();
        int answer[] = new int[id_list.length];
        Arrays.stream(id_list).forEach(s -> users.put(s,0));
        Arrays.stream(id_list).forEach(s -> reports.put(s,new HashSet<>()));

        for(String re : report){
            String sarr[] = re.split(" ");
            reports.get(sarr[1]).add(sarr[0]);
        }

        for(String key : id_list){
            HashSet<String> selectUser = reports.get(key);
            if(selectUser.size()>=k){
                for(String user : selectUser){
                    users.put(user,users.get(user)+1);
                }
            }
        }

        for(int i=0;i<id_list.length;i++){
            answer[i] = users.get(id_list[i]);
        }

        return answer;
    }
}