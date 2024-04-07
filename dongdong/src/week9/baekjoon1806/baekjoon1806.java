package src.week9.baekjoon1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int answer = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int []numbers = new int[n+1];

        st = new StringTokenizer(br.readLine());
        int count =0;
        while(st.hasMoreTokens()){
            numbers[count++] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int total = 0;

        while(start <= n && end <= n){
            if(total >= answer && min > end - start ) min = end -start;
            if(total < answer) total += numbers[end++];
            else total -= numbers[start++];
        }

        if(min == Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(min);

    }
}
