# 최솟값 찾기
[link](https://www.acmicpc.net/problem/11003)

## 문제 풀이

1. Deque를 이용하여 문제를 풀었다.
2. 슬라이딩 윈도우 문제였음.
3. 처음에는 Deque를 사용하지 않고 for문을 이중for문을 사용하여 2개 돌렸지만... 시간초과가 나서.. 다른 사람 코드를 참고하였다.
````````
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


````````