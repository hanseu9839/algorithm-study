package src.Week11.baekjoon2617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon2617 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> parent = new ArrayList<>();
        ArrayList<ArrayList<Integer>> child = new ArrayList<>();

        for(int i = 0; i < n+1; i++){
            parent.add(new ArrayList<>());
            child.add(new ArrayList<>());
        }

        for(int i = 0; i < m;i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            parent.get(num2).add(num1);
            child.get(num1).add(num2);
        }

        boolean []visited = new boolean[n+1];

        int answer = 0;

        for(int i=1;i<=n;i++){
            init(visited);
            visited[i] = true;

            int biggerNum = dfs(i, parent, visited, 0);

            if(biggerNum > n/2){
                answer+= 1;
                continue;
            }

            int smallNum = dfs(i, child, visited, 0);
            if(smallNum > n/2){
                answer +=1;
                continue;
            }
        }
        System.out.println(answer);
    }

    public static int dfs(int x, ArrayList<ArrayList<Integer>> list, boolean []visited, int count){
        for(int i=0;i<list.get(x).size(); i++){
            if(!visited[list.get(x).get(i)]) {
                visited[list.get(x).get(i)] = true;
                count += dfs(list.get(x).get(i), list, visited, 1);
            }
        }
        return count;
    }

    public static void init(boolean []visited) {
        for(int i=0;i< visited.length; i++){
            visited[i] = false;
        }
    }
}
