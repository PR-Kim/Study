package Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_GameMap {
    public static void main(String[] args){

        //int[][] map = new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int[][] map = new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        Programmers_GameMap p = new Programmers_GameMap();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        System.out.println(p.solution(map));
    }
    public int solution(int[][] maps){
        int answer = -1;
        int endr = maps.length-1;
        int endc = maps[0].length -1;
        int[] dr = new int[]{1,0,-1,0};
        int[] dc = new int[]{0,1,0,-1};
        int[][] visit = new int[maps.length][maps[0].length];

        Queue<int[]> que  = new LinkedList<>();
        que.offer(new int[]{0,0,0});
        while (!que.isEmpty()){
            int[] tmp = que.poll();

            if(tmp[0] == endr && tmp[1] == endc){
                answer = tmp[2];
                break;
            }
            for(int i =0;i<4;i++){
                if(tmp[0]+dr[i]>-1 && tmp[0]+dr[i]<endr+1 && tmp[1]+dc[i]>-1 && tmp[1]+dc[i]<endc+1){
                    int row = tmp[0] + dr[i];
                    int col = tmp[1] + dc[i];
                    if(maps[row][col] == 0)continue;
                    if(visit[row][col] == 1) continue;
                    int cnt = tmp[2] +1;
                    int[] tmpval = new int[]{row,col,cnt};
                    que.offer(tmpval);
                    visit[row][col] = 1;
                }
            }
        }
        answer = (answer==-1)? answer : answer+1;
        return answer;
    }
}
