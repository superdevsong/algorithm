package programmers;

import java.util.*;

class Problem {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> proQueue = new LinkedList<>();
        Queue<Integer> speedQueue = new LinkedList<>();

        Arrays.stream(progresses).forEach(proQueue::add);
        Arrays.stream(speeds).forEach(speedQueue::add);
        ArrayList<Integer> list = new ArrayList<>();
        int i = 1;
        int proTemp = proQueue.peek();
        int speedTemp = speedQueue.peek();

        while(!proQueue.isEmpty()){
            if(proTemp+i*speedTemp>=100){
                int k = 1;
                proQueue.poll();
                speedQueue.poll();
                while(!proQueue.isEmpty()){
                    proTemp = proQueue.peek();
                    speedTemp = speedQueue.peek();
                    if(proTemp+i*speedTemp>=100){
                        k++;
                        proQueue.poll();
                        speedQueue.poll();
                    } else{
                        break;
                    }
                }
                list.add(k);
            }
            i++;
        }

        return  list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}