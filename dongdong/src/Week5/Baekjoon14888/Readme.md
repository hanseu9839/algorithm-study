# 연산자 끼워넣기
[link](https://www.acmicpc.net/problem/14888)
---


## 문제 풀이

1. 해당 문제는 백트래킹을 이용해서 문제를 풀었다. 
2. 연산자를 배열 4칸에다가 입력 하고, 반복문 안에서 재귀를 호출해주었다. 그리고 재귀를 호출 할 때 마다 해당 연산자 인덱스를 1감소시키며 0이 된다면 다음 인덱스(연산자)로 넘어간다. 


# 코드
``````
package src.Week5.Baekjoon14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14888 {
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int N;
    static int[] operatorArr = new int[4];
    static int[] numArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        numArr = new int[N];
        int count = 0;
        while(st.hasMoreTokens()){
            numArr[count] = Integer.parseInt(st.nextToken());
            count++;
        }

        st = new StringTokenizer(br.readLine());
        count = 0;
        while(st.hasMoreTokens()){
            operatorArr[count] = Integer.parseInt(st.nextToken());
            count++;
        }

        solve(numArr[0],1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void solve(int num, int count){
        if(count == N) {
            MIN = Math.min(MIN, num);
            MAX = Math.max(MAX, num);
            return;
        }

        for(int i=0; i< 4; i++){
            if(operatorArr[i]>0){
                operatorArr[i]--;
                switch(i) {
                    case 0: solve(num + numArr[count],  count+1); break;
                    case 1: solve(num - numArr[count], count+1); break;
                    case 2: solve(num * numArr[count], count+1); break;
                    case 3: solve(num / numArr[count],  count+1); break;
                }
                operatorArr[i]++;
            }
        }
    }
}

``````