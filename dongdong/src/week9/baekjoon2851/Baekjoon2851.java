package src.week9.baekjoon2851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int s = 0;
        for(int i=0;i<10; i++){
            sum += Integer.parseInt(br.readLine());
            if(sum>100){
                if(Math.abs(sum-100) <= Math.abs(s-100)){
                    break;
                } else if(Math.abs(sum-100) >= Math.abs(s-100)){
                    sum = s;
                    break;
                }
            }
            s = sum;
        }

        System.out.println(sum);
    }
}
