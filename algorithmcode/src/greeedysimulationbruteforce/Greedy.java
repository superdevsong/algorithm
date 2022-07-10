package greeedysimulationbruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int money = 1000 - Integer.parseInt(br.readLine());

        int idx = 0;
        //제일 큰수부터 거슬러주기
        while(money>0){
            if(money>=500)
                money-=500;
            else if(money>=100)
                money-=100;
            else if(money>=50)
                money-=50;
            else if(money>=10)
                money-=10;
            else if(money>=5)
                money-=5;
            else if(money>=1)
                money-=1;
            idx ++;
        }
        System.out.println(idx);
    }
}
