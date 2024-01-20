package src.Week2.Baekjoon2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 */
public class Main {
    static int N, start, goal, rN;
    static int graph[][];
    static int dist[];
    static boolean check[];
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        check = new boolean[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());

        rN = Integer.parseInt(br.readLine());
        for(int i=0; i<rN; i++){
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                graph[num1][num2] = graph[num2][num1] = 1;
        }
        dfs(start, 0);
        System.out.println(count==0? -1 : count);


    }

    static void dfs(int i, int d){
        if(i==goal) {
            count = d;
            return;
        }
        check[i]=true;

        for(int j= 1; j<=N; j++){
            if(graph[i][j]==1 && !check[j]){
                dfs(j, d+1);
            }
        }
    }

    static void bfs(int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        check[i] = true;
        while(!q.isEmpty()){
            int target = q.poll();
            for(int j=1; j<=N; j++){
                if(graph[target][j]==1&& !check[j]){
                    q.add(j);
                    dist[i] = dist[target] + 1;
                }
            }
        }
    }

}
