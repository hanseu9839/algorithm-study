package src.Week6.Baekjoon1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.util.Arrays.stream;

public class Baekjoon1107 {
    static int n,target;
    static boolean[] isBroken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        if(n!=0){
            stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .forEach(e->isBroken[e]=true);
        }

        int ans = Math.abs(100-target);

        for(int i=0;i<=999999;i++){

            String cur = Integer.toString(i);
            boolean check=false;

            for(int j=0;j<cur.length();j++){
                if(isBroken[cur.charAt(j) - '0']){
                    check=true; // 고장난 버튼이면 break
                    break;
                }
            }
            if(!check) // 고장안났으면 target 까지 거리 계산해서 갱신
                ans = Math.min(ans,cur.length()+Math.abs(i-target));
        }
        System.out.println(ans);

    }
}
