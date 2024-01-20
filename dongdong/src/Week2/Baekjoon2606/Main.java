package src.Week2.Baekjoon2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 */
public class Main {
    static int n,rn;
    static boolean virusCheck[];
    static int[][] arr;
    static int count =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        rn = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        virusCheck = new boolean[n+1];

        StringTokenizer st;

        for(int i=1;i<=rn;i++){
            st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            arr[num1][num2] = arr[num2][num1] = 1; // 양 방향
        }
        dfs(1);
        System.out.println(count - 1);
    }

    public static void dfs(int start){
        virusCheck[start]=true;
        count++;

        for(int i=1;i<=n;i++){
            if(arr[start][i]==1 && !virusCheck[i]) dfs(i);
        }
    }
}
