package src.Week13.Baekjoon1005;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon1005 {
    static int n, w;
    static ArrayList<Integer>[] list; // 연결 간선 정보
    static int[] building;
    static int[] indegree;
    static int[] buildCost;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        for(int i=0; i<t; i++){
            n = scan.nextInt();
            int k = scan.nextInt();

            building = new int [n+1];
            list = new ArrayList[n+1];
            for(int j=1; j <= n; j++){
                building[j] = scan.nextInt();
                list[j] = new ArrayList<>();
            }

            indegree = new int[n+1];
            for(int j = 0; j < k; j++){
                int s = scan.nextInt();
                int e = scan.nextInt();
                list[s].add(e);
                indegree[e]++;
            }

            w = scan.nextInt(); // 건설해야하는 건물 번호
            buildCost = new int[n + 1];
            topologySort();
            System.out.println(buildCost[w]);
        }

    }

    public static void topologySort() {
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<indegree.length; i++){
            if(indegree[i] == 0){
                buildCost[i] = building[i];
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int current = q.poll();

            for(int i=0; i < list[current].size(); i++){
                int next = list[current].get(i);
                buildCost[next] = Math.max(buildCost[current] + building[next] , buildCost[next]);
                indegree[next]--;
                if(indegree[next] == 0 ) q.offer(next);
            }
        }
    }
}
