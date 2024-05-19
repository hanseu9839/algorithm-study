## Baekjoon1439 

## [link](https://www.acmicpc.net/problem/1439)

# 문제 풀이

````
package src.Week14.Baekjoon1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char []ch = str.toCharArray();

        int answer = 0;
        for(int i=1; i< ch.length; i++){
            if(ch[i-1] != ch[i]) { 
                answer++;
            }
        }

        answer = (answer + 1)/ 2;
        System.out.println(answer);
    }
}


````