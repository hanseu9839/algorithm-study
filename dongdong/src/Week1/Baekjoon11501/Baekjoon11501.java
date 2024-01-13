package Week1.Baekjoon11501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/** 주식
 * 매일 그는 세 가지 중 한 행동을 한다.
 * 1. 주식 하나를 산다.
 * 2. 원하는 만큼 가지고 있는 주식을 판다.
 * 3. 아무것도 안한다.
 */
public class Baekjoon11501 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        // 처음 값을 읽어 들어오는 부분 ( 케이스의 개수를 구함)
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine()); // 몇일까지 있을지 구한다.
            st = new StringTokenizer(br.readLine());
            int stocks[] = new int[n];

            for(int j=0;j<n;j++){
                stocks[j] = Integer.parseInt(st.nextToken()); // 각각의 날짜의 주식을 stocks 배열에 넣어준다.
            }

            int max = 0;
            long sum = 0; // long으로 해주어야함 값이 더해지는 부분이고 범위 밖으로 OverFlow가 발생하기 때문에 int가아닌 long으로 타입을 선언해주자.
            for(int j=n-1; j>=0;j--) {
                max = Math.max(max,stocks[j]); // 가장 큰 값으로 고쳐주는 부분 (뒤에서 부터라면 가장 큰 값인 경우에만 교체 후 뺴주면됨 그러면 문제될게 없음
                sum += max - stocks[j];

            }
            sb.append(sum+ "\n");
        }
        System.out.println(sb);
    }
}
