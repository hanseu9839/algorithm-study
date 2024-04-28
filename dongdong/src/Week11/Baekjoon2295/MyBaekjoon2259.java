package src.Week11.Baekjoon2295;

import java.util.Arrays;
import java.util.Scanner;

public class MyBaekjoon2259 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int []arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }

        int []sum = new int[(n*n)];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i; j<n; j++){
                sum[count++] = (arr[i] + arr[j]);
            }
        }

        Arrays.sort(sum);

        int answer = -1;
        for(int i=n-1; 0<=i; i--){
            for(int j=n-1; 0 <=j; j--){
                if(binarySearch(sum, arr[i]-arr[j])) {
                    answer = Math.max(answer, arr[i]);
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean binarySearch(int[] arr, int value){
        int l =0;
        int r = arr.length - 1;
        while(l <= r){
            int m = (l + r) / 2;
            if(arr[m] > value) {
                r = m - 1;
            } else if(arr[m] < value){
                l = m + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
