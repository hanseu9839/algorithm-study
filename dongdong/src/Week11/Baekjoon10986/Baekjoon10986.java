package src.Week11.Baekjoon10986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Baekjoon10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] S = new long[n];
        int[] M = new int[n];
        int[] C = new int[m];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (i == 0)
                S[i] = num;
            else
                S[i] = S[i - 1] + num;
            M[i] = (int) (S[i] % m);
            C[M[i]]++;
        }

        long sum = C[0];
        for(int i = 0; i < m; i++){
            sum += combo(C[i]);
        }
        System.out.println(sum);
    }
     static long combo(long num){
        if(num<2) return 0;
        else return num * (num-1) / 2;
    }
}
