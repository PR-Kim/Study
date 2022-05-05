package Java;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TowerErecting {
    static int max;
    static Tower[] towers;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        towers = new Tower[n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            towers[i] = new Tower(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        max = Integer.MIN_VALUE;
        TowerErecting t= new TowerErecting();
        int res = t.solution();

        bw.write(res + "");
        bw.flush();
    }
    public int solution(){
        int answer = 0;
        Arrays.sort(towers);
        ArrayList<Tower> towerLst = new ArrayList<>();
        dfs(towerLst,0,0);
        return max;
    }

    public void dfs(ArrayList<Tower> towerLst,int currH ,int idx){
        if(idx>=towers.length) return;
        if(towerLst.size()!= 0 && (towers[idx].weight<towerLst.get(towerLst.size()-1).weight)){
            dfs(towerLst,currH,idx+1);
            max = Math.max(max,currH);
        }else{
            //현재값을 선택했을 때,
            towerLst.add(towers[idx]);
            currH+=towers[idx].height;
            dfs(towerLst,currH,idx+1);
            max = Math.max(max,currH);
            //현재값을 선택하지 않았을 때,
            towerLst.remove(towerLst.size()-1);
            currH-=towers[idx].height;
            dfs(towerLst,currH,idx+1);
            max = Math.max(max,currH);
        }
    }
}

class Tower implements Comparable<Tower>{
    int area;
    int height;
    int weight;
    public Tower(int area, int height, int weight){
        this.area = area;
        this.height = height;
        this.weight = weight;
    }
    public int compareTo(Tower t){
        if(this.area>t.area) return 1;
        else if(this.area<t.area) return -1;
        return 0;
    }

}
