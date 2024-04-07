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
