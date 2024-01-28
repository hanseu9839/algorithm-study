package src.week3.Baekjoon13023;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjoon13023 {
    private static int m;
    private static List<Integer>[] list;
    private static int ans = 0;
    private static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        v = new boolean[N];
        for(int i = 0; i< N; i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }

        for(int i = 0; i < N; i++){
            if(ans == 0) dfs(i,1);
        }

        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dfs(int start, int depth){
        if(depth == 5) {
            ans = 1;
            return ;
        }
        v[start] = true;
        for(int i : list[start]) {
            int next = i;
            if(!v[next]){
                dfs(next, depth+1);
            }
        }
        v[start] = false;
    }
}
