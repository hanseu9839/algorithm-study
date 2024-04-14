package src.Week10.baekjoon2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int []h = new int[N];

        int max = 0;
        for(int i=0;i<N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, h[i]);
        }

        int left = 0;
        int right = max;

        while(left < right){
            int mid = (right + left) / 2;
            long length = 0;

            for(int hight : h){
                if(hight-mid > 0) length += hight - mid;
            }

            if(length >= M) left = mid +1;
            else right = mid;
        }

        System.out.println(left-1);
    }
}
