# 나는야 포켓몬 마스터 이다솜
[link](https://www.acmicpc.net/problem/1620)

## 문제 풀이
1. 이 문제는 어떤 자료구조를 사용해서 문제를 풀 수 있냐였고 중복이 들어 오지 않기때문에 HashMap을 사용하여 문제를 풀었다.
2. 비교적 쉬운 문제였음. 

````````
package src.week9.baekjoon1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Baekjoon1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int answerRn = Integer.parseInt(st.nextToken());

        Map<String, Integer> names = new HashMap<>();
        Map<Integer, String> numbers = new HashMap<>();

        for(int i=1;i<=n;i++){
           String name = br.readLine();
           names.put(name, i);
           numbers.put(i, name);
        }

        for(int i=0;i<answerRn; i++){
          String monster = br.readLine();
            if(parseInt(monster)) {
                sb.append(numbers.get(Integer.parseInt(monster))).append("\n");
            }else {
                sb.append(names.get(monster)).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean parseInt(String str){
        try{
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}

````````