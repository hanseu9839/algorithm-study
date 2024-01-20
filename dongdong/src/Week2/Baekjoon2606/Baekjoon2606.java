package src.Week2.Baekjoon2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2606 {
    static int N;
    static int M;
    static int[][] branch;
    static boolean[] visit;
    static int count;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        branch = new int[N+1][N+1];
        visit = new boolean[N+1];

        StringTokenizer st;
        for(int i=1; i<M+1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            branch[a][b] = branch[b][a] = 1;
        }

        bfs(1);
    }

    static void bfs(int start){
        queue = new LinkedList<Integer>();

        visit[start] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int j=1; j<N+1; j++){
                if(branch[temp][j]==1 && visit[j]==false){
                    count++;
                    queue.add(j);
                    visit[j] = true;
                }
            }
        }
    }
}
