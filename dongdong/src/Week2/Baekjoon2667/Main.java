package src.Week2.Baekjoon2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int [][]map;
    static int n, count;
    static boolean [][]checkMap;
    static int []dx = {1, 0, -1, 0};
    static int []dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        checkMap = new boolean[n][n];
        StringTokenizer st;
        String str;
        for(int i=0; i<n; i++){
            str = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j]=str.charAt(j)-'0';
            }
        }

        int result = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                count = 0;
                if(map[i][j]==1 && !checkMap[i][j]){
                    dfs(i,j);
                    arr.add(count);
                    result++;
                }
            }
        }
        Collections.sort(arr);
        System.out.println(result);
        for(int answer : arr){
            System.out.println(answer);
        }
    }
    static void dfs(int x, int y){
        checkMap[x][y] = true;
        count++;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && !checkMap[nx][ny] && map[nx][ny] == 1){
                dfs(nx,ny);
            }
        }

    }
}
