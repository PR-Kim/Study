package Java;

import java.io.*;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FindFriend {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<String> arrLst = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        for(int i=0;i<m;i++){
            arrLst.add(br.readLine());
        }
        st = new StringTokenizer(br.readLine());
        int targeta = Integer.parseInt(st.nextToken());
        int targetb = Integer.parseInt(st.nextToken());
        String res = "";

        FindFriend f = new FindFriend();
        res = f.solution(map, arrLst,targeta,targetb);
        bw.write(res +"");
        bw.flush();
    }
    public String solution(HashMap<Integer,Integer> map, ArrayList<String> arrLst,int targeta,int targetb){
        String answer = "";
        for(int i =0;i<arrLst.size();i++){
            StringTokenizer st = new StringTokenizer(arrLst.get(i));
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(map.containsKey(a) && map.containsKey(b)){
                if(map.get(a) < map.get(b))
                {
                    map.put(b,map.get(a));
                }
                else
                {
                    map.put(a,map.get(b));
                }
            }
            else if (map.containsKey(a)){
                if(map.get(a) < b)
                {
                    map.put(b,map.get(a));
                }
                else
                {
                    map.put(b,b);
                    map.put(a,map.get(b));
                }
            }
            else if(map.containsKey(b)){
                if(map.get(b) < a)
                {
                    map.put(a,map.get(b));
                }
                else{
                    map.put(a,a);
                    map.put(b,a);
                }
            }
            else
            {
                if(a>b){
                    map.put(b,b);
                    map.put(a,b);
                }
                else
                {
                    map.put(b,a);
                    map.put(a,a);
                }

            }
        }
        /*
        for (Integer a: map.keySet()) {
            System.out.println("Key : " + a + " / Value : " + map.get(a));
        }
        */
        int tmp = targeta;
        int tmpa = targeta;
        while (map.get(tmp) != tmp && map.containsKey(tmp) ){
            tmpa = map.get(tmp);
            tmp = tmpa;
        }
        int tmp2 = targetb;
        int tmpb = targetb;
        while (map.get(tmp2) != tmp2 && map.containsKey(tmp2) ){
            tmpb = map.get(tmp2);
            tmp2 = tmpb;
        }

        if(tmpa == tmpb) return "YES";
        return "NO";
    }
}
