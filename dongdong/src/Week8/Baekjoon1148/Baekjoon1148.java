package src.Week8.Baekjoon1148;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Baekjoon1148 {
    static int MAX_COUNT= 200000;
    static int A_TO_Z = 26;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int[][] wordList = new int[MAX_COUNT][A_TO_Z];

        int wordCount = 0;
        while(true) {
            String word = br.readLine();

            if(word.equals("-")) break;

            for(int i=0;i<word.length(); i++){
                wordList[wordCount][word.charAt(i)-'A']++;
            }
            wordCount++;
        }

        while(true) {
            String board = br.readLine();

            if(board.equals("#")) break;

            int[] boardArr = new int[26];
            for(int i=0; i<board.length(); i++) boardArr[board.charAt(i)-'A']++;

            int min = MAX_COUNT;
            int max = 0;
            int[] result = new int[A_TO_Z];
            for(int i=0; i<wordCount; i++){
                if(!isValid(wordList[i], boardArr)) continue;

                for(int j=0;j<A_TO_Z;j++){
                    if(wordList[i][j] > 0) result[j]++; // 위에서 valid에서 알파벳이 타당한것은 확인 완료 , result++을 단어가 포함되어있으면 하나 증가
                }
            }


            for(int i=0;i<A_TO_Z; i++){
                 if(boardArr[i]==0) continue;
                 if(min > result[i]) min = result[i];
                if(max < result[i]) max = result[i];
            }

            for(int i=0;i<A_TO_Z;i++){
                if(boardArr[i]!=0 && result[i] == min) sb.append((char)(i+'A'));
            }
            sb.append(' ').append(min).append(' ');

            for(int i=0;i<A_TO_Z;i++){
                if(boardArr[i]!=0 && result[i] == max) sb.append((char)(i+'A'));
            }
            sb.append(' ').append(max).append('\n');
        }

        System.out.print(sb);
    }
    static boolean isValid(int[] wordList, int[] boardArr){
        for(int i=0; i<A_TO_Z;i++){
            if(boardArr[i] < wordList[i]) return false;
        }

        return true;
    }
}
