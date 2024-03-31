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

    public static int calculate(int N, int count){
// N이 2 미만인 경우 누적된 count값을 반환
        if (N < 2) {
            return count;
        }
        return Math.min(calculate(N / 2, count + 1 + (N % 2)), calculate(N / 3, count + 1 + (N % 3)));
    }

}
