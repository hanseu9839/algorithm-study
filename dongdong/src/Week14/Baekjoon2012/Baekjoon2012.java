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
