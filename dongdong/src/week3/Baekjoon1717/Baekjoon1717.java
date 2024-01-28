package src.week3.Baekjoon1717;

import java.util.Scanner;

public class Baekjoon1717 {
    static int[] parent;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        parent = new int[n + 1];
        for(int i = 0; i <=n; i++){
            parent[i] = i;
        }
        int m = scan.nextInt();
        for(int i=0; i < m; i++){
            int kind = scan.nextInt();
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();

            int p1 = find(num1);
            int p2 = find(num2);

            if(kind == 0 && p1 != p2) union(p1,p2);
            else if(kind == 1 && p1 != p2) System.out.println("NO");
            else if(kind == 1 && p1 == p2) System.out.println("YES");
        }
    }
    public static void union(int a, int b){
        parent[a] = b;
    }
    public static int find(int a){
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
}
