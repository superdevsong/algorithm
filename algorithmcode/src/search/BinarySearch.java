package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. 입력
        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);// 나무개수
        int M = Integer.parseInt(input1[1]);//원하는 나무 길이

        int[] trees = new int[N];
        int start = 0;
        int end = 0;
        int result=0;

        String[] input2 = br.readLine().split(" ");

        for(int i=0;i<N;i++){
            trees[i] = Integer.parseInt(input2[i]);//각 나무 길이들
            //2 끝에 값 구하기
            end = Math.max(end,trees[i]);
        }


        while(start<=end){//4 반복
            long total = 0;
            //3 중간값 구하기
            int mid = (start + end) / 2;
            for(int i = 0;i<N;i++){
                if(trees[i]>mid) total += trees[i]-mid;
            }
            if(total == M){ 
                result = mid;
                break;
            }
            else if(total<M) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }
        System.out.println(result);

    }
}
