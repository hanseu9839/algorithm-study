package src.Week8.Baekjoon1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1463 {
    public static int dp[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];

        System.out.println(calculate(n));

    }

    public static int calculate(int number){
        if(number==1) return 0;
        if(dp[number] > 0) return dp[number];
        dp[number] = calculate(number-1) + 1;
        if(number%3 == 0) dp[number] = Math.min(dp[number], calculate(number/3) + 1);
        if(number%2 == 0) dp[number] = Math.min(dp[number], calculate(number/2) + 1);

        return dp[number];
    }

}
