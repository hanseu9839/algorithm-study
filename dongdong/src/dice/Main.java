package src.dice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 게임 룰
 * 1. 처음에는 시작 칸에 말 4개
 * 2. 말은 게임판에 그려진 화살표 방향대로 이동 파란색 칸 이동 => 파란색 화살표 (무조건) , 이동하는 도중이면 빨간색 화살표 타기
 * 3. 게임 턴은 총 10턴 , 매 턴마다 1부터 5까지 한 면에 하나씩 적혀있는 5면체 주사위 굴린다. 도착 칸에 있지 않은 말을 하나 골라 주사위 굴림
 * 4. 말이 이동을 마치는 칸에 다른 말이 있으면 그 말 고를 수 없음
 */
// 조합 및 dfs 문제
public class Main {
    static int [] map = { // 도착하면 0
            0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0, //0 ~ 21
            10, 13, 16, 19, 25, 30, 35, 40, 0,  //22 ~ 30
            20, 22, 24, 25, 30, 35, 40, 0,      //31 ~ 38
            30, 28, 27, 26, 25, 30, 35, 40, 0}; //39 ~ 47
    static int[] dice = new int[10];
    static int[] gameP =  new int[10];

    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<10; i++){
            dice[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0);
        System.out.println(ans);
    }

    public static void permutation(int cnt){
        if(cnt == 10) { // 개수가 다 채워지면 시작
            game();
            return ;
        }

        for(int i=0; i<4; i++){ // 주사위는 4개이기때문에 (단 10번을 움직여서 각각의 조합에대한 것을 구해줌)
            gameP[cnt] = i; // 처음에는 gameP 0으로 열개 재귀가 반환되면서 가장 큰 값을 구해줄 것이다. 1111  1112  1113 이런식으로 쭉 진행됨
            permutation(cnt+1);
        }
    }

    public static void game(){
        boolean[] visited = new boolean[map.length];
        int score = 0;
        int []p = new int[4]; // 말이 4마리이니깐 위치도 4개

        for(int i=0; i<10; i++){ // 10번 움직이는 것에 대한 처리
            int nowD = dice[i]; // 현재 주사위 위치 번호
            int nowP = gameP[i]; // 현재 움직일 말 번호
            if(finsh(nowP)) return ; // 도착지점 처리 해주기

            int next = nextMove(p[nowP], nowD); // 다음에 움직이는 위치
            if(finsh(next)) {
                setVisited(visited, p[nowP], false); // finsh인 경우 방문 취소 그래야 중복해서 올 수 있음.
                p[nowP] = next;
                continue;
            }

            if(visited[next]) return;
            setVisited(visited, p[nowP], false); // 현재 위치 방문 취소
            setVisited(visited, next, true); // 다음 위치 방문 체크

            p[nowP] = next;
            score += map[p[nowP]];

        }

        ans = Math.max(ans, score);

    }


    public static void setVisited(boolean[] visited, int idx, boolean check){
        if(idx== 20 || idx== 29 || idx == 37 || idx == 46){
            visited[20] = check;
            visited[29] = check;
            visited[37] = check;
            visited[46] = check;
        } else if(idx == 26 || idx== 34 || idx == 43){
            visited[26] = check;
            visited[34] = check;
            visited[43] = check;
        } else if(idx == 27 || idx == 35 || idx == 44){
            visited[27] = check;
            visited[35] = check;
            visited[44] = check;
        } else if(idx == 28 || idx == 36 || idx == 45) {
            visited[28] = check;
            visited[36] = check;
            visited[45] = check;
        } else {
            visited[idx] = check;
        }
    }

    public static int nextMove(int nowIdx, int dice) {
        int nextIdx = nowIdx + dice;
        if(nowIdx < 21) {
            if (nextIdx >= 21) nextIdx = 21;
        } else if(nowIdx < 30) {
            if(nextIdx >= 30) nextIdx = 30;
        } else if(nowIdx < 38) {
            if(nextIdx >= 38) nextIdx = 38;
        }else if(nowIdx < 47) {
            if(nextIdx >= 47) nextIdx = 47;
        }

        if(nextIdx == 5) return 22;
        if(nextIdx == 10) return 31;
        if(nextIdx == 15) return 39;

        return nextIdx;
    }

    public static boolean finsh(int index){
        return index ==21 || index == 30 || index== 38 || index == 47;
    }
}
