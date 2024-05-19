## 백준 알고리즘 2012 등수매기기

## [link](https://www.acmicpc.net/problem/2012)

정렬을 하여 앞에 있는 값을 기준으로 하나씩 뽑아서 겹친다면 뒤로 보내는 방법으로 하면 최소 불만도를 구할 수 있다. 

# 문제 풀이
````
package src.Week14.Baekjoon2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon2012 {
    static int answer = 0;
    static int n =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int []grades = new int[n];

        for(int i=0; i < n; i++){
            int grade = Integer.parseInt(br.readLine());
            grades[i] = grade;
        }

        Arrays.sort(grades);

        long answer = 0;
        for(int i=0; i < n; i++) {
            answer += Math.abs(grades[i] - (i+1));
        }

        System.out.println(answer);
    }

}

````