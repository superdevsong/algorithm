package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFSBFS {

    private static ArrayList<ArrayList<Integer>> nodeList;

        public static void main(String[] args) throws IOException {
            //값 입력 및 초기화
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] NMV = br.readLine().split(" ");

            int vertexLen = Integer.parseInt(NMV[0]);
            int EdgeLen =  Integer.parseInt(NMV[1]);
            int startVer = Integer.parseInt(NMV[2]);

            boolean dfsVisit[] = new boolean[vertexLen+1];//dfs 방문배열
            boolean bfsVisit[] = new boolean[vertexLen+1];//bfs 방문배열

            nodeList = new ArrayList<>();

            for(int i=0;i<vertexLen+1;i++){//list 정점 개수+1만큼 생성
                nodeList.add(new ArrayList<>());
            }

            for(int i=0;i<EdgeLen;i++){//각 각 노드에 대한 연결 정리
                String[] node = br.readLine().split(" ");
                int node1 = Integer.parseInt(node[0]);
                int node2 = Integer.parseInt(node[1]);

                nodeList.get(node1).add(node2);

                nodeList.get(node2).add(node1);
            }

            for(int i=1;i<=vertexLen;i++){//정렬
                nodeList.get(i).sort(Comparator.naturalOrder());
            }

            //dfs bfs 구현

            dfs(startVer,dfsVisit);
            System.out.println();
            bfs(startVer,bfsVisit);

        }

    private static void dfs(int vertex,boolean[] visit) {
            System.out.print(vertex+" ");
                visit[vertex] = true;// 1 방문처리

                for(int i : nodeList.get(vertex)){
                    if(!visit[i])// 2 이미 방문했다면 재귀를 사용하지 않고 안했다며 방문한다.
                        dfs(i,visit);
                }

    }
    private static void bfs(int vertex,boolean[] visit) {
        visit[vertex] = true;// 방문처리
        Queue<Integer> nodeQueue = new LinkedList<>();
        nodeQueue.add(vertex);
        while(nodeQueue.size()>0){
            int v = nodeQueue.poll();
            System.out.print(v+" ");
            for(int i : nodeList.get(v)){
                if(!visit[i]) {
                    nodeQueue.add(i);
                    visit[i] = true;
                }
            }

        }
    }
}
