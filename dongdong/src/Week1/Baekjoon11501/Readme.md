# Baekjoon Algorithm 11501

## 문제 
홍준이는 요즘 주식에 빠져있다. 그는 미래를 내다보는 눈이 뛰어나, 날 별로 주가를 예상하고 언제나 그게 맞아떨어진다. 매일 그는 아래 세 가지 중 한 행동을 한다.

1. 주식 하나를 산다.
2. 원하는 만큼 가지고 있는 주식을 판다.
3. 아무것도 안한다.
홍준이는 미래를 예상하는 뛰어난 안목을 가졌지만, 어떻게 해야 자신이 최대 이익을 얻을 수 있는지 모른다. 따라서 당신에게 날 별로 주식의 가격을 알려주었을 때, 최대 이익이 얼마나 되는지 계산을 해달라고 부탁했다.

예를 들어 날 수가 3일이고 날 별로 주가가 10, 7, 6일 때, 주가가 계속 감소하므로 최대 이익은 0이 된다. 그러나 만약 날 별로 주가가 3, 5, 9일 때는 처음 두 날에 주식을 하나씩 사고, 마지막날 다 팔아 버리면 이익이 10이 된다.
- - -
## 입력
- - -
입력의 첫 줄에는 테스트케이스 수를 나타내는 자연수 T가 주어진다. 각 테스트케이스 별로 첫 줄에는 날의 수를 나타내는 자연수 N(2 ≤ N ≤ 1,000,000)이 주어지고, 둘째 줄에는 날 별 주가를 나타내는 N개의 자연수들이 공백으로 구분되어 순서대로 주어진다. 날 별 주가는 10,000이하다.

## 출력
- - - 
각 테스트케이스 별로 최대 이익을 나타내는 정수 하나를 출력한다. 답은 부호있는 64bit 정수형으로 표현 가능하다.


## 문제 풀이 
- 손해는 보지 않는다. 손해를 보는 경우는 0으로 계산하여 진행한다. 
- 첫째 날, 둘째 날에 비해 셋째 날 주식의 주가가 올라간다면 첫째, 둘째날 둘 다 이익이 발생한다. (결론 최고값에서 각각의 값을 빼주어야함)
- Max와 Target이 되는 두개의 주식 주가 사이의 차이를 구하면 이익을 구할 수 있음. 
- - - 


``````
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

``````
