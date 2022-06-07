package Java;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon_15686 {
    public static int MIN_DISTANCE = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        ArrayList<String> shopArrLst = new ArrayList<>();
        ArrayList<String> homeArrLst = new ArrayList<>();
        ArrayList<String> selectedLst = new ArrayList<>();
        for(int i =0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==2) shopArrLst.add(i + " " + j);
                if(arr[i][j]==1) homeArrLst.add(i + " " + j);
            }
        }

        Baekjoon_15686 b = new Baekjoon_15686();
        b.dfs(0,m,shopArrLst,selectedLst,homeArrLst);
        bw.write(MIN_DISTANCE + "");
        bw.flush();
    }
    public void dfs(int idx, int m,ArrayList<String> shopArrLst, ArrayList<String> selectedLst, ArrayList<String> homeLst ){
        if(selectedLst.size()>=m){
            findWay(selectedLst,homeLst);
            return;
        }
        if(idx>shopArrLst.size()-1)return;
        selectedLst.add(shopArrLst.get(idx));
        idx+=1;
        dfs(idx,m,shopArrLst,selectedLst,homeLst);

        selectedLst.remove(selectedLst.size()-1);

        dfs(idx,m,shopArrLst,selectedLst,homeLst);




    }
    public void findWay(ArrayList<String> selectedLst, ArrayList<String> homeLst){
        int tmpRes = 0;
        for(int i=0;i<homeLst.size();i++){
            StringTokenizer st = new StringTokenizer(homeLst.get(i));
            int homeI = Integer.parseInt(st.nextToken());
            int homeJ = Integer.parseInt(st.nextToken());

            int tmp = Integer.MAX_VALUE;
            for(int j=0;j<selectedLst.size();j++){
                StringTokenizer st2 = new StringTokenizer(selectedLst.get(j));
                int selI = Integer.parseInt(st2.nextToken());
                int selJ = Integer.parseInt(st2.nextToken());
                tmp = Math.min(tmp, (Math.abs(homeI-selI)+Math.abs(homeJ-selJ)));
            }
            tmpRes += tmp;
        }
        MIN_DISTANCE = Math.min(MIN_DISTANCE,tmpRes);
    }
}
