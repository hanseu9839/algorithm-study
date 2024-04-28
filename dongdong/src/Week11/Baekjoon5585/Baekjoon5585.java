package src.Week11.Baekjoon5585;

import java.util.Scanner;

public class Baekjoon5585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputMoney = sc.nextInt();
        int outputMoney = 1000 - inputMoney;

        int []money = {500, 100, 50, 10, 5, 1};
        int answer = 0;
        int index = 0;
        while(outputMoney > 0) {
            int count = outputMoney / money[index];
            outputMoney -= money[index++] * count;
            answer += count;
        }

        System.out.println(answer);
    }
}