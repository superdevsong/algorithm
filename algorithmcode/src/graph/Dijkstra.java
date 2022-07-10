package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    public int index;
    public int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        if(this.distance<o.distance)
            return -1;
        else
            return 1;
    }
}
public class Dijkstra {
    private static ArrayList<ArrayList<Node>> nodeList;
    private static int minDistance[];
    public static void main(String[] args) throws IOException {
        //값 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M =  Integer.parseInt(br.readLine());

        minDistance = new int[N+1];//최단 거리 테이블

        //2 최단 거리 테이블 초기화
        Arrays.fill(minDistance, Integer.MAX_VALUE);//minDistance의 값들을 제일 높은 값으로 초기화 해준다.

        nodeList = new ArrayList<>();

        //list 초기화
        for(int i=0;i<N+1;i++){
            nodeList.add(new ArrayList<>());
        }

        //정점 리스트를 만들어 넣어준다.
        for(int i=0;i<M;i++){
            String[] sArr = br.readLine().split(" ");
            int startV = Integer.parseInt(sArr[0]);
            nodeList.get(startV)
                    .add(new Node(Integer.parseInt(sArr[1]),Integer.parseInt(sArr[2])));
        }

        String[] startEnd = br.readLine().split(" ");
        int start = Integer.parseInt(startEnd[0]);
        int end = Integer.parseInt(startEnd[1]);

        //다익스트라를 실시한다.
        dijkstra(start,end);

    }


    private static void dijkstra(int start, int end) {
        PriorityQueue<Node> nodeQueue = new PriorityQueue<>();

        //1 스타트 노드 0으로 초기화
        minDistance[start] = 0;
        nodeQueue.offer(new Node(start,0));

        while(!nodeQueue.isEmpty()){//큐가 비어있을때 종료
            //3 방문하지 않은 노드중에서 가장 짧은 노드 선택
            Node node = nodeQueue.poll();

            //노드 초기화 하였는지 했으면 넘김
            if(minDistance[node.index]<node.distance)
                continue;

            for(Node n : nodeList.get(node.index)) {
                //현 노드의 거리와 다음으로 이동할 거리를 더한다.
                int cost = minDistance[node.index] + n.distance;

                //4 이후 그값이 최단 거리 테이블을 구해서 비교후 이동한 cost가 더 작으면 최단 거리 테이블을 최신화 해준다.
                if(cost<minDistance[n.index]){
                    minDistance[n.index] = cost;
                    nodeQueue.offer(new Node(n.index,cost));
                }
            }
        }
        System.out.println(minDistance[end]);

    }


}
