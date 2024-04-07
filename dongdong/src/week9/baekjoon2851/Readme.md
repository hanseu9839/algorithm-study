# 슈퍼 마리오
[link](https://www.acmicpc.net/problem/2851)

## 문제 풀이

1. 버섯 10개 집어넣음.
2. 중간에 중단 가능 (break)로 탈출 , 모두 주울 필요 없음 
3. 100을 넘으면 전 값을 비교해서 더 차이가 덜나는 걸로 가져옴 같다면 큰 값으로..!
````````
package src.week9.baekjoon2851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0; // 현재 더 해준 수
        int s = 0; // 이전에 더 해준 수 
        for(int i=0;i<10; i++){
            sum += Integer.parseInt(br.readLine());
            if(sum>100){
               //더 큰 값으로 가져오는 부분
                if(Math.abs(sum-100) <= Math.abs(s-100)){ // 크다면 지금 값
                    break;
                } else if(Math.abs(sum-100) >= Math.abs(s-100)){ // 작다면 이전 값
                    sum = s;
                    break;
                }
            }
            s = sum;
        }

        System.out.println(sum);
    }
}
````````