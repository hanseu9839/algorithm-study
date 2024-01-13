# 문제
강호는 코딩 교육을 하는 스타트업 스타트링크에 지원했다. 오늘은 강호의 면접날이다. 하지만, 늦잠을 잔 강호는 스타트링크가 있는 건물에 늦게 도착하고 말았다.

스타트링크는 총 F층으로 이루어진 고층 건물에 사무실이 있고, 스타트링크가 있는 곳의 위치는 G층이다. 강호가 지금 있는 곳은 S층이고, 이제 엘리베이터를 타고 G층으로 이동하려고 한다.

보통 엘리베이터에는 어떤 층으로 이동할 수 있는 버튼이 있지만, 강호가 탄 엘리베이터는 버튼이 2개밖에 없다. U버튼은 위로 U층을 가는 버튼, D버튼은 아래로 D층을 가는 버튼이다. (만약, U층 위, 또는 D층 아래에 해당하는 층이 없을 때는, 엘리베이터는 움직이지 않는다)

강호가 G층에 도착하려면, 버튼을 적어도 몇 번 눌러야 하는지 구하는 프로그램을 작성하시오. 만약, 엘리베이터를 이용해서 G층에 갈 수 없다면, "use the stairs"를 출력한다.
- - -
# 입력
첫째 줄에 F, S, G, U, D가 주어진다. (1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000) 건물은 1층부터 시작하고, 가장 높은 층은 F층이다.
- - -
# 출력
첫째 줄에 강호가 S층에서 G층으로 가기 위해 눌러야 하는 버튼의 수의 최솟값을 출력한다. 만약, 엘리베이터로 이동할 수 없을 때는 "use the stairs"를 출력한다.
- - -


## 문제 풀이 
- - -
1. 버튼은 두가지 밖에 없다. 내려가는 버튼 , 올라가는 버튼 버튼을 UP이면 UP만큼 올라 갈 수 있고, DOWN이면 DOWN만큼 내려갈 수 있음.  
2. UP, DOWN으로 최소값으로 갈 수 있는 걸 Goal구하는 것은 BFS로직을 사용해야 한다. 
3. 아예 해당 층에 도달하지 못할 수도 있음. (BFS에서 무한루프에 빠지지 않게 조건처리를 해주어야함.)


``````
package Week1.Baekjoon5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** 스타트링크
 *  강호는 코딩 교육을 하는 스타트업 스타트링크에 지원했다. 오늘은 강호의 면접날이다. 하지만, 늦잠을 잔 강호는 스타트링크가 있는 건물에 늦게 도착하고 말았다.
 *  스타트링크는 총 F층으로 이루어진 고층 건물에 사무실이 있고, 스타트링크가 있는 곳의 위치는 G층이다. 강호가 지금 있는 곳은 S층이고 , 이제 엘리베이터를 타고 G층으로 이동하려고 한다.
 *  보통 엘리베이터에는 어떤 층으로 이동할 수 있는 버튼이 있지만, 강호가 탄 엘리베이터는 버튼이 2개밖에 없다. U버튼은 위로 U층을 가는 버튼 , D버튼은 아래로 D층을 가는 버튼이다.
 */
public class Main {
    static int floor;
    static int startFloor;
    static int targetFloor;
    static int up;
    static int down;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        floor = Integer.parseInt(st.nextToken());
        startFloor = Integer.parseInt(st.nextToken());
        targetFloor = Integer.parseInt(st.nextToken());
        up = Integer.parseInt(st.nextToken());
        down = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
        
    }

    static String bfs(){
        int count=-1; // 처음 startFloor도 카운터로 세어지기 때문에 -1을 해주어 뺴줌
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[floor+1];

        q.add(startFloor);

        while(!q.isEmpty()){ // queue빌 때까지 넣어준다.
            count++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                int currentFloor = q.poll();

                if(currentFloor == targetFloor){
                    return String.valueOf(count);
                }

                int u = currentFloor + up; 
                if(u <= floor && !visited[u]){ // floor보다 크면 튕겨내야함 u<=floor를 앞에 두지 않으면 OutOfBoundIndex에러가나서 팅겨 나간다.
                    visited[u] = true;

                    q.add(u);
                }

                int d = currentFloor- down;
                if(d  > 0 && !visited[d]){
                    visited[d] = true;
                    q.add(d);
                }
            }
        }
        return "use the stairs";
    }
}
``````