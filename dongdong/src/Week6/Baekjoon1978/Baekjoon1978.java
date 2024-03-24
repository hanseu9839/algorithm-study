package src.Week6.Baekjoon1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1978 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());



        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            boolean flag = true;

            if(num == 1 || num ==0) continue;
            if(num == 2) {
                count++;
                continue;
            }
            for(int i=2;i<=(int)Math.sqrt(num); i++){
                if(num%i==0) {
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }

        System.out.println(count);
    }
}
