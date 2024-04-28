package src.Week12.Baekjoon14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] T = new int[n];
        int[] P = new int[n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];

        for(int i=0;i<n; i++){
            if(i+T[i]<=n){
                dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i] + P[i]);
            }

            dp[i + 1] = Math.max(dp[i+1], dp[i]);
        }
    }
}
