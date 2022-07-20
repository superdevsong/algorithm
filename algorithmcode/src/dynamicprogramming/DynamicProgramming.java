package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicProgramming {
    static long dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new long[N+1];//dp배열
        dp[0] = 0;
        dp[1] = 1;

        System.out.println(fibo(N));

    }
    static long fibo(int n){//함수를 리턴하지말고 dp배열을 리턴해 재귀횟수를 줄인다.
        if(n==0)
            return dp[0];
        else if(n==1)
            return dp[1];
        if(dp[n]==0)
            return dp[n] = fibo(n-1)+fibo(n-2);
        else
            return dp[n];
    }
}
