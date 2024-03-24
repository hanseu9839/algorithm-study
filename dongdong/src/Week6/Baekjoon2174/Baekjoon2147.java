package src.Week6.Baekjoon2174;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2147 {
    static int[][] map;
    static int A;
    static int B;
    static int N,M;
    static int []dx = {0, 1, 0, -1};  // 상하좌우
    static int []dy = {1, 0, -1, 0};
    static boolean flag;
    static Robot []robots;
    static class Robot {
        int x;
        int y;
        int dir;
        public Robot(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

    }

    public static void main(String[] args) throws IOException, AWTException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[B+1][A+1];

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        robots = new Robot[N+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            char dir = st.nextToken().charAt(0);
            int d=0;
            if(dir=='N')
                d = 0;
            else if(dir =='E')
                d = 1;
            else if(dir =='S')
                d = 2;
            else if(dir == 'W')
                d = 3;
            map[y][x] = i;
            robots[i] = new Robot(x,y,d);
        }

        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int robotNum = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            int count = Integer.parseInt(st.nextToken());
            answer(robotNum, dir, count);
            if(flag) break;
        }
        if(!flag) System.out.println("OK");
    }

    static void answer(int robotNum, char dir, int count){
        for(int i=0;i<count; i++){
            Robot robot = robots[robotNum];
            if(dir=='L' || dir=='R'){
                int nextDir = changeDir(robot.dir ,dir);
                robots[robotNum] = new Robot(robot.x, robot.y, nextDir);
            } else if(dir=='F'){
                int nextX = robot.x + dx[robot.dir];
                int nextY = robot.y + dy[robot.dir];
                if(1<=nextX && nextX <= A && 1<=nextY && nextY <= B){
                    if(map[nextY][nextX]>0){
                        flag = true;
                        System.out.println("Robot "+ robotNum +" crashes into robot " + map[nextY][nextX]);
                        return;
                    } else {
                        map[robot.y][robot.x] = 0;
                        map[nextY][nextX] = robotNum;
                        robots[robotNum] = new Robot(nextX, nextY, robot.dir);
                    }
                } else {
                    System.out.println("Robot "+robotNum+" crashes into the wall");
                    flag = true;
                    return;
                }
            }
        }
    }


    static int changeDir(int dir, char ch){
        if(ch == 'L') {
            if(dir == 0){
                dir = 3;
            }else {
                dir--;
            }

        }else if(ch == 'R') {
            if(dir==3) {
                dir = 0;
            }else {
                dir++;
            }
        }
        return dir;
    }

}

