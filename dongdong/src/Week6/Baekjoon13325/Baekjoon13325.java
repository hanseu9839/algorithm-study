package src.Week6.Baekjoon13325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon13325 {
    static int n, k, res;
    static int[] arr, tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        n = (int)Math.pow(2, k+1) -1;
        arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=2; i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1,0);
    }

    static int dfs(int idx, int h){
        if(h==k){
            res += arr[idx];
            return arr[idx];
        }

        int left = dfs(idx*2, h+1);
        int right = dfs(idx*2+1, h+1);
        res += arr[idx] + Math.abs(left - right);
        return arr[idx] + Math.max(left, right);
    }
}
