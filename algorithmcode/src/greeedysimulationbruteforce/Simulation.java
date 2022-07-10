package greeedysimulationbruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Simulation {
    public static int[] dx = {0,0,-1,1};//방향 벡터
    public static int[] dy = {-1,1,0,0};// 방향 벡터
    public static String[] move = {"L","R","U","D"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String sArr[] = br.readLine().split(" ");

        int x = 1;
        int y = 1;

        for(int i=0;i<sArr.length;i++){
            int idx = 0;
            for(int j=0;j<move.length;j++){
                if(move[j].equals(sArr[i])) {//방향을 읽음
                    idx = j;
                    break;
                }
            }
            //해당하는 방향벡터 설정
            int nx = x+dx[idx];
            int ny = y+dy[idx];
            if(nx>=1 && ny >=1 && nx<=N && ny <= N) {
                x=nx;
                y=ny;
            }
        }
        System.out.println(x+" "+y);

    }
}
