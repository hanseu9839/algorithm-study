package Week1.Baekjoon1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** DFS와 BFS
 *  그래프를 DFS로 탐색한 결과와 BFS 탐색한 결과를 출력하는 프로그램을 작성하시오.
 *  단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 */
public class Baekjoon1260 {
    static int n; // 정점 개수
    static int m; // 간선 개수
    static int start; // 시작
    static int [][]graph; // 그래프
    static boolean []visited; // 방문한 장소
    static int count; // count
    static Queue<Integer> queue = new LinkedList<>(); // bfs를 위한 queue
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.valueOf(st.nextToken());

        graph= new int[n+1][n+1]; // n + 1 정점의 개수 0번부터 시작하기때문에 +1 을 더해줌
        visited = new boolean[n+1];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[n][v]= graph[v][n] = 1; // 양방향이기 떄문에 1
        }

        dfs(start);
        System.out.println();
        visited = new boolean[n+1];
        bfs();
    }
    public static void dfs(int start){
        visited[start] = true;
        System.out.print(start + " ");
        if(count == n) { // count 와 n 간선의 개수가 똑같으면 리턴
            return;
        }
        count++;
        for(int i=1;i<=n;i++){
            if(graph[start][i]==1 && visited[i]== false){
                dfs(i);
            }
        }
    }

    public static void bfs(){
        queue.add(start);
        visited[start] = true;
        System.out.print(start+ " ");
        while(!queue.isEmpty()){
            start = queue.poll();
            for(int i=1;i<=n;i++){
                if(graph[start][i]==1 && visited[i]==false){
                    queue.offer(i);
                    visited[i]=true;
                    System.out.print(i+ " ");
                }
            }
        }
    }
}

