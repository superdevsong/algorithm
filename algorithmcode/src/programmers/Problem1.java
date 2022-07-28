package programmers;

import java.util.HashMap;

//프로그래머스 완주하지 못한선수
public class Problem1 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> hashMap = new HashMap<>();

        for(int i =0;i<participant.length;i++){
            if(hashMap.containsKey(participant[i]))
                hashMap.put(participant[i],hashMap.get(participant[i])+1);
            else
                hashMap.put(participant[i],1);
        }


        for(int i =0;i<completion.length;i++){
            int value = hashMap.get(completion[i])-1;
            if(value!=0)
                hashMap.put(completion[i],value);
            else
                hashMap.remove(completion[i]);
        }

        for(String key :hashMap.keySet())
            return key;
        return "";
    }
}
