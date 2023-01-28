package Java;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_GamemapShort{
    public static void main(String[] args) throws IOException{
        int[][] maps = new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        Programmers_GamemapShort PG = new Programmers_GamemapShort();
        int answer = PG.solution(maps);

        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //bw.write(answer);
        //bw.flush();
        System.out.println(answer);

    }

    public int solution(int[][] maps){
        int answer = -1;
        int[][] visit = new int[maps.length][maps[maps.length-1].length];
        //Arrays.fill(visit,0);
        int rend = maps.length-1;
        int hend = maps[maps.length-1].length;
        visit[0][0] = 1;
        int[] ir = new int[]{1,0,-1,0};
        int[] ih = new int[]{0,1,0,-1};
        Queue<int[]> que = new LinkedList<>();

        que.offer(new int[]{0,0,0});
        //System.out.println("maps.length ::" + maps.length + " // map[maps.length-1].length :: " + maps[maps.length-1].length);
        while (!que.isEmpty()){
            int[] tmp = que.poll();
            if(tmp[0] == maps.length-1 && tmp[1] == maps[maps.length-1].length -1){
                answer = tmp[2] +1;
                break;
            }
            for(int i =0;i<ir.length;i++){
                int r = tmp[0] + ir[i];
                int h = tmp[1] + ih[i];

                if(r<maps.length && r>-1 && h<maps[maps.length-1].length && h>-1 && maps[r][h] != 0 && visit[r][h] ==0){
                    //System.out.println("r :: " + r + " // h :: " + h);
                    visit[r][h] = 1;
                    que.offer(new int[]{r,h,tmp[2]+1});
                }
            }
        }
        return answer;
    }
}