package src.Week6.Baekjoon14916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int coin = Integer.parseInt(br.readLine());

        int count =0;
        while(coin > 0){
            if(coin%5==0){
                count = coin / 5 + count;
                break;
            }
            coin -= 2;
            count++;
        }

        if(coin < 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }

    }



}
