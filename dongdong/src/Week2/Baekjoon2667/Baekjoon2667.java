package src.Week2.Baekjoon2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon2667 {
    static int [][]map;
    static int n, count;
    static int []dx = {1, 0, -1, 0};
    static int []dy = {0, 1, 0, -1};

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        map[x][y] = 0;

        while(!q.isEmpty()){
            count += 1;
            int now [] =  q.poll();
            for(int i=0; i < 4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1){
                    map[nx][ny] = 0;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int result = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                count = 0;
                if(map[i][j] == 1){
                    bfs(i,j);
                    list.add(count);
                    result++;
                }
            }
        }
        Collections.sort(list);
        System.out.println(result);
        for(int i : list){
            System.out.println(i);
        }
    }
}
