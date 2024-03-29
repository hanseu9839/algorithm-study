package src.Week5.Baekjoon10986;

import java.io.IOException;
import java.util.Scanner;

public class Baekjoon10986 {


    static int N, M;
    static int[] arr, sArr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] S = new long[N]; // 합배열
        long[] C = new long[M]; // 합배열%M을 동일하게 만들어주는 i, j를 담는 배열

        long answer = 0;

        S[0] = sc.nextInt();

        // 합배열 생성
        for(int i=1; i < N; i++){
            S[i] = S[i - 1] + sc.nextInt();
        }

        for(int i = 0; i < N; i++){
            int remainder = (int) (S[i] % M);
            if(remainder == 0) {
                answer++;
            }

            C[remainder]++;
        }

        for(int i=0;i<M;i++){
            long cnt = C[i];
            answer = answer + (cnt * (cnt -1 ) / 2);
        }

        System.out.println(answer);
    }

}
