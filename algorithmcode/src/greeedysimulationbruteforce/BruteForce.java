package greeedysimulationbruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BruteForce {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[9];

        for(int i=0;i<array.length;i++)//값할당
            array[i] = Integer.parseInt(br.readLine());

        for(int i=0;i<array.length-1;i++){//9명중에 두명을 구하기위한 for문
            for(int j=i+1;j<array.length;j++){
                int sum = 0;
                for(int k=0;k<array.length;k++){
                    if(k!=i&&k!=j)
                        sum+=array[k];
                }
                if(sum==100){//두명을 제외한 합이 100일때 
                    array[i] = 0;
                    array[j] = 0;
                    Arrays.sort(array);
                    break;
                }
            }
        }
        for(int i=2;i<array.length;i++)
            System.out.println(array[i]);


    }
}
