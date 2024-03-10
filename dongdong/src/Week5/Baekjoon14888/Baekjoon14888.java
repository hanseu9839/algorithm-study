package src.Week5.Baekjoon14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14888 {
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int N;
    static int[] operatorArr = new int[4];
    static int[] numArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        numArr = new int[N];
        int count = 0;
        while(st.hasMoreTokens()){
            numArr[count] = Integer.parseInt(st.nextToken());
            count++;
        }

        st = new StringTokenizer(br.readLine());
        count = 0;
        while(st.hasMoreTokens()){
            operatorArr[count] = Integer.parseInt(st.nextToken());
            count++;
        }

        solve(numArr[0],1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void solve(int num, int count){
        if(count == N) {
            MIN = Math.min(MIN, num);
            MAX = Math.max(MAX, num);
            return;
        }

        for(int i=0; i< 4; i++){
            if(operatorArr[i]>0){
                operatorArr[i]--;
                switch(i) {
                    case 0: solve(num + numArr[count],  count+1); break;
                    case 1: solve(num - numArr[count], count+1); break;
                    case 2: solve(num * numArr[count], count+1); break;
                    case 3: solve(num / numArr[count],  count+1); break;
                }
                operatorArr[i]++;
            }
        }
    }
}
