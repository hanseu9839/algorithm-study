package src.Week11.Baekjoon4796;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon4796 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int L = 0; // 사용 가능한 일
        int P = 0; // 연속하는 일
        int V = 0; // 휴가 기간

        int caseCount = 0;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            if(V==0) break;

            int answer = L * (V / P) + Math.min(L, V % P);
            System.out.println("Case " + ++caseCount +": " + answer);
        }
    }

}
