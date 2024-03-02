package src.week4.Baekjoon5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon5427 {

    static class info{
        int x, y, time;

        public info(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int h, w, answer;
    static char[][] map;
    static Queue<info> fire;
    static Queue<info> person;

    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc=0;tc<T; tc++){
            st= new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];

            fire = new LinkedList<>();
            person = new LinkedList<>();

            for(int i=0; i < h; i++){
                String str = br.readLine();
                for(int j=0; j < w; j++){
                    char ch = str.charAt(j);
                    map[i][j] = ch;
                    if(ch == '*')  {
                        fire.offer(new info(i,j,0));
                    } else if(ch == '@'){
                        person.offer(new info(i, j, 0));
                    }
                }
            }

            answer = 0;
            bfs();
            if(answer==0) sb.append("IMPOSSIBLE\n");
            else sb.append(answer+"\n");
        }
        System.out.println(sb.toString());
    }
    public static void bfs() {
        while(!person.isEmpty()){
            int size = fire.size();
            for(int i=0; i<size; i++){
                info temp = fire.poll();
                for(int d=0; d < 4; d++){
                    int nx = temp.x + dx[d];
                    int ny = temp.y + dy[d];
                    if(nx>= 0 && nx<h && ny >= 0 && ny<w && (map[nx][ny]=='.' || map[nx][ny]=='@')) {
                        map[nx][ny] = '*';
                        fire.offer(new info(nx, ny, 0));
                    }
                }
            }

            size = person.size();
            for(int i=0; i<size; i++){
                info temp = person.poll();
                for(int d = 0; d < 4; d++){
                    int nx = temp.x + dx[d];
                    int ny = temp.y + dy[d];

                    if(!(nx >= 0 && ny >= 0 && nx < h && ny < w)) {
                        answer = temp.time+1;
                        return;
                    }

                    if(map[nx][ny] == '.') {
                        map[nx][ny] = '@';
                        person.offer(new info(nx,ny, temp.time+1));
                    }
                }
            }
        }
    }
}

