package src.Week12.Baekjoon1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1018 {
    public static boolean [][]all;
    public static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input," ");

        int row =Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        all = new boolean[row][column];

        for(int i=0;i<row;i++){
            String line=br.readLine();
            for(int j=0;j<column;j++){
                if(line.charAt(j)=='W'){//W일 떄 True
                    all[i][j]=true;
                }else{
                    all[i][j]=false; //W가 아니면 False (즉, Black일 때 false)
                }
            }
        }
        int r = row - 7;
        int c = column - 7;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                checkNumber(i,j);
            }
        }
        System.out.println(min);
    }

    public static void checkNumber(int r,int c){
        int end_row = r + 8;
        int end_column = c + 8;
        int count =0;
        boolean TF = all[r][c]; //첫 번째 칸의 색
        for(int i=r;i<end_row;i++){
            for(int j=c;j<end_column;j++){
                //올바른 색이 아닐 경우 count 1 증가
                if(all[i][j]!=TF){
                    count ++;
                }
                //다음 칸의 색이 바뀌므로 true라면 false , false라면 True로
                TF = (!TF);
            }
            TF = (!TF);
        }
        /*첫 번째 칸을 기준으로 하면 count , 첫번째 칸과 반대되는 수로 해주는 것은 64-count
          그래서 두가지가 반대되는 수로 구함
        */
        count = Math.min(count,64-count);
        min = Math.min(count,min);
    }
}
