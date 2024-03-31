package src.Week8.Baekjoon11003;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baekjoon11003 {
    static int N, L;
    static int []arr,answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Node> deque = new LinkedList<>();
        for(int i=0;i<N; i++){
            int num = Integer.parseInt(st.nextToken());

            while(!deque.isEmpty() && deque.getLast().value > num){
                deque.removeLast();
            }
            deque.addLast(new Node(num, i));

            if(deque.getFirst().index <= i-L){
                deque.removeFirst();
            }
            bw.write(deque.getFirst().value + " ");
        }

        bw.flush();
        bw.close();
    }

    static class Node{
        public int value;
        public int index;
        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }

}
