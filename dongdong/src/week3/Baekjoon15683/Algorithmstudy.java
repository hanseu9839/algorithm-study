package src.week3.Baekjoon15683;

public class Algorithmstudy {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int r = 2;

        permutation(arr, new int[r], new boolean[arr.length], 0, r);
        dupCombination(arr, new int[r], 0, 0, r);
    }
    // 순열
    public static void permutation(int []arr, int[] out, boolean[] visited, int depth, int r){
        if(depth == r) {
            for(int num : out) System.out.print(num);
            System.out.println();
            return;
        }
        for(int i=0;i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, out, visited, depth+1, r);
                visited[i] = false;
            }
        }
    }
    public static void dupPermutation(int[] arr, int[] out, int depth, int r){
        if(depth == r){
            for(int num: out) System.out.print(num);
            System.out.println();
            return;
        }
        for(int i=0; i<arr.length; i++){
            out[depth] = arr[i];
            dupPermutation(arr, out, depth+1, r);
        }
    }

    public static void combination(int[] arr, boolean[] visited, int start, int depth, int r){
        if(depth == r){
            for(int i = 0; i<arr.length; i++) {
                if(visited[i]) System.out.print(arr[i]);
            }
            System.out.println();
            return;
        }
        for(int i= start; i<arr.length; i++){
            if(!visited[i]) {
                visited[i]  = true;
                combination(arr, visited, i+1, depth+1, r);
                visited[i] = false;
            }
        }
    }

    public static void dupCombination(int[] arr, int[] out, int start, int depth, int r){
        if(depth == r){
            for(int num : out) System.out.print(num);
            System.out.println();
            return;
        }
        for(int i=start; i<arr.length; i++){
            out[depth] = arr[i];
            dupCombination(arr, out, i, depth+1, r);
        }
    }


}
