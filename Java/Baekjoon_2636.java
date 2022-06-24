package Java;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2636 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st1.nextToken());
        int col = Integer.parseInt(st1.nextToken());

        int[][] arr = new int[row][col];
        int[][] hole = new int[row][col];
        Queue<Hole> que = new LinkedList<>();
        Queue<Hole> first = new LinkedList<>();
        int firsts = 0;
        for(int i =0;i<row;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0;j<col;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] ==0) hole[i][j] = 1;
                if(i==0 || j==0) {
                    hole[i][j] = 2;
                    que.offer(new Hole(i,j));
                }

            }
        }
        int[] ni = new int[]{1,0,-1,0};
        int[] nj = new int[]{0,1,0,-1};
        while (!que.isEmpty()){
            Hole tmp = que.poll();
            for(int i =0;i<4;i++){
                if(tmp.i+ni[i]<arr.length && tmp.i+ni[i]>-1 && tmp.j+nj[i]>-1 && tmp.j+nj[i]<arr[0].length) {
                    if(hole[tmp.i+ni[i]][tmp.j+nj[i]] == 1){
                        hole[tmp.i+ni[i]][tmp.j+nj[i]] = 2;
                        que.offer(new Hole(tmp.i+ni[i],tmp.j+nj[i]));
                    }
                    if(hole[tmp.i+ni[i]][tmp.j+nj[i]] == 0){
                        //System.out.println("first /// i : " + (tmp.i + ni[i]) + " / j : " + (tmp.j + nj[i]) + " / cnt :  " + (tmp.cnt+1));
                        hole[tmp.i+ni[i]][tmp.j+nj[i]] = 2;
                        first.offer(new Hole(tmp.i+ni[i],tmp.j+nj[i],1));
                        firsts +=1;
                    }

                }
            }
        }

        String res = solution(arr,hole,first);
        //System.out.println(res.charAt(0));
        int a = res.charAt(0) - '0';
        if(res.charAt(0) == '-'){
            bw.write(1 + "");
            bw.newLine();
            bw.write(firsts + "");
            bw.flush();
            return;
        }
        st1 = new StringTokenizer(res);

        bw.write(st1.nextToken() + "");
        bw.newLine();
        bw.write(st1.nextToken() + "");
        bw.flush();
    }
    public static String solution(int[][] arr, int[][] hole, Queue<Hole> next){
        int answer = -1;

        int[] ni = new int[]{1,0,-1,0};
        int[] nj = new int[]{0,1,0,-1};
        HashMap<Integer,Integer> cheese = new HashMap<>();
        Queue<Hole> tmpp = new LinkedList<>();
        while (!next.isEmpty()){
            Hole tmp = next.poll();
            for(int i =0;i<4;i++) {
                if (tmp.i + ni[i] < arr.length && tmp.i + ni[i] > -1 && tmp.j + nj[i] > -1 && tmp.j + nj[i] < arr[0].length) {
                    //치즈였을경우
                    if(hole[tmp.i + ni[i]][tmp.j + nj[i]] ==  0){
                        //공기넣고 카운트 +1하고 다시 넣고
                        hole[tmp.i + ni[i]][tmp.j + nj[i]]=2;
                        next.offer(new Hole(tmp.i + ni[i],tmp.j + nj[i],tmp.cnt+1));
                        if(cheese.containsKey(tmp.cnt+1)){
                            cheese.put(tmp.cnt+1,cheese.get(tmp.cnt+1)+1);
                        }else{
                            cheese.put(tmp.cnt+1,1);
                        }
                        //System.out.println("i : " + (tmp.i + ni[i]) + " / j : " + (tmp.j + nj[i]) + " / cnt :  " + (tmp.cnt+1));
                        answer = Math.max(answer,tmp.cnt+1);
                    }
                    //막힌 구멍이었을 경우
                    if(hole[tmp.i + ni[i]][tmp.j + nj[i]] ==  1){
                        //공기 넣고 카운트는 증가없이 다시 넣고
                        hole[tmp.i + ni[i]][tmp.j + nj[i]]=2;
                        tmpp.offer(new Hole(tmp.i + ni[i],tmp.j + nj[i],tmp.cnt));
                        while (!tmpp.isEmpty()){
                            Hole asd = tmpp.poll();
                            for(int k =0;k<4;k++){
                                if(asd.i+ni[k]<arr.length && asd.i+ni[k]>-1 && asd.j+nj[k]>-1 && asd.j+nj[k]<arr[0].length) {
                                    if(hole[asd.i+ni[k]][asd.j + nj[k]]==1)
                                    {
                                        hole[asd.i+ni[k]][asd.j + nj[k]]=2;
                                        tmpp.offer(new Hole(asd.i+ni[k],asd.j + nj[k],asd.cnt));
                                        //System.out.println("막힌놈 뚫자 i : " + (asd.i + ni[k]) + " / j : " + (tmp.j + nj[k]) + " / cnt :  " + (tmp.cnt+1));
                                    }
                                    if(hole[asd.i+ni[k]][asd.j + nj[k]]==0) {
                                        hole[asd.i+ni[k]][asd.j + nj[k]]=2;
                                        next.offer(new Hole(asd.i+ni[k],asd.j + nj[k],asd.cnt+1));
                                        if(cheese.containsKey(asd.cnt+1)){
                                            cheese.put(asd.cnt+1,cheese.get(asd.cnt+1)+1);
                                        }else{
                                            cheese.put(asd.cnt+1,1);
                                        }
                                        answer = Math.max(answer,asd.cnt+1);
                                    }
                                }
                            }
                        }


                        //answer = Math.max(answer,tmp.cnt);
                    }
                }
            }
        }
        String res = answer + " " + cheese.get(answer);
        return res;
    }
}
class Hole{
    int i;
    int j;
    int cnt;
    public Hole(int i , int j){
        this.i = i;
        this.j = j;
    }
    public Hole(int i, int j, int cnt){
        this.i = i;
        this.j = j;
        this.cnt = cnt;
    }
}