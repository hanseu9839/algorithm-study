package src.Week5.Baekjoon17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon17298 {
    static int N;
    static int arr[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        int count = 0;
        while(st.hasMoreTokens()){
            arr[count] = Integer.parseInt(st.nextToken());
            count++;
        }
        solved();
        System.out.println(sb);

    }

    public static void solved(){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++){

            while(!stack.isEmpty() && arr[i]>arr[stack.peek()]){
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }

        for(int i=0;i<N;i++){
            sb.append(arr[i]).append(' ');
        }
    }
}
