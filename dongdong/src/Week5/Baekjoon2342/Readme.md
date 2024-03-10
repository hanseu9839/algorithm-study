# Dance Dance Revolution
[link](https://www.acmicpc.net/problem/2342)
---

## 문제 풀이 

1. 가장 우선적으로 해당 문제는 DP 로 문제를 풀었다. 이전에 한 행동이 현재 행동에 영향을 주기에 DP로 풀어야함. 
2. 이전 행동을 저장하려면 어떻게 해야할까? 3차원 배열을 통해서 현재 진행하려는 현재 스텝과 내 발위치를 정한다. 
3. dp[left발위치][오른쪽발위치][현재진행하려는스텝] 해당 방식으로 진행된다.  

# 코드
``````
package src.Week5.Baekjoon2342;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2342 {

    static int[][][]dp;
    static int[] move;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []line = br.readLine().split(" ");

        move = new int[line.length - 1];
        for(int i=0; i < line.length-1; i++){
            move[i] = Integer.parseInt(line[i]);
        }

        dp = new int[5][5][line.length];

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(solve(0,0,0));
    }

    public static int solve(int left, int right, int cnt){
        if(cnt == move.length) return 0;
        if(dp[left][right][cnt]!=-1) return dp[left][right][cnt];
        dp[left][right][cnt] = Math.min(solve(move[cnt],right, cnt+1) + energy(left, move[cnt]), solve(left, move[cnt], cnt+1) + energy(right,move[cnt]));

        return dp[left][right][cnt];
    }

    static int energy(int pos, int des){
        int num = Math.abs(pos-des);
        if(pos==0) return 2;
        else if(num == 0) return 1;
        else if(num == 1 || num == 3) return 3;
        else return 4;
    }
}


``````