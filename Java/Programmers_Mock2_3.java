package Java;

import java.util.*;

public class Programmers_Mock2_3 {


    public static void main(String[] args){
        Programmers_Mock2_3 p = new Programmers_Mock2_3();

        int n =5;
        int[][] arr = new int[][]{{1,2},{1,4},{2,4},{2,5},{4,5}};
        int[] source = new int[]{1,3,5};
        int dest = 5;
        /*
        int n =3;
        int[][] arr = new int[][]{{1,2},{2,3}};
        int[] source = new int[]{2,3};
        int dest = 1;

         */
        System.out.println(Arrays.toString(p.solution(n,arr,source,dest)));
    }
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] path = new int[n];
        Arrays.fill(path,-1);
        //path[destination-1] = 0;
        int[] visit = new int[n];
        HashMap<Integer,List<Integer>> hash = new HashMap<>();
       // int[][] link = new int[n][n];

        for(int i =0;i<roads.length;i++){
            int a = roads[i][0];
            int b = roads[i][1];
            if(hash.containsKey(a))hash.get(a).add(b);
            else hash.put(a,new ArrayList<>(Arrays.asList(b)));
            if(hash.containsKey(b))hash.get(b).add(a);
            else hash.put(b,new ArrayList<>(Arrays.asList(a)));
        }

        visit[destination-1] = 1;
        path[destination-1] = 0;
        Queue<int[]> que = new LinkedList<>();

        for(int i =0; i<hash.get(destination).size();i++){
            visit[hash.get(destination).get(i)-1]= 1;
            path[hash.get(destination).get(i)-1] = 1;
            que.offer(new int[]{hash.get(destination).get(i),1});
           /* if(roads[i][1]==destination)
            {
                //System.out.println("i : " + i + "road[i] : " + roads[i][0] + "cnt : "+ 1);
                visit[roads[i][0]-1]= 1;
                path[roads[i][0]-1] = 1;
                que.offer(new int[]{roads[i][0],1});
            }
            else if(roads[i][0]==destination){
                visit[roads[i][1]-1]= 1;
                path[roads[i][1]-1] = 1;
                que.offer(new int[]{roads[i][1],1});
            }
            */
        }
        while (!que.isEmpty()){
            int[] tmp = que.poll();
            //System.out.println("tmp[0] : " + tmp[0] + " / tmp[1] : " +tmp[1] );
            for(int i =0; i<hash.get(tmp[0]).size();i++){

                if(visit[hash.get(tmp[0]).get(i)-1]==0){
                  //  System.out.println("hash.get(tmp[0]).get(i) : " + hash.get(tmp[0]).get(i));
                    visit[hash.get(tmp[0]).get(i)-1]=1;
                    path[hash.get(tmp[0]).get(i)-1]=tmp[1]+1;
                    que.offer(new int[]{hash.get(tmp[0]).get(i),tmp[1]+1});
                }

                //System.out.println("tmp[0] : " + tmp[0]);
                /*
                if(roads[i][1]==tmp[0] && visit[roads[i][0]-1]==0){
                    visit[roads[i][0]-1]=1;
                    path[roads[i][0]-1] = tmp[1]+1;
                    //System.out.println("i : " + i + "cnt : "+ path[tmp[0]]);
                    que.offer(new int[]{roads[i][0],tmp[1]+1});
                }
                else if(roads[i][0]==tmp[0] && visit[roads[i][1]-1]==0){
                    visit[roads[i][1]-1]=1;
                    path[roads[i][1]-1] = tmp[1]+1;
                    //System.out.println("i : " + i + "cnt : "+ path[tmp[0]]);
                    que.offer(new int[]{roads[i][1],tmp[1]+1});
                }
                 */
            }
        }
        //findPath(destination-1,0,visit,link);
        int[] answer = new int[sources.length];
        for(int i =0;i<sources.length;i++){
            answer[i] = path[sources[i]-1];
        }
        return answer;
    }
    /*
    public void findPath(int curr, int cnt,int[] visit, int[][] link){
        if(path[curr]==-1){
            path[curr] = cnt;
        }
        else{
            path[curr] = Math.min(cnt,path[curr]);
        }

        for(int i =0;i< link[curr].length;i++){
            if(link[curr][i] == 1 && visit[i]==0){
                visit[i] = 1;
                findPath(i,cnt+1,visit,link);
                visit[i] = 0;
            }
        }
    }
     */
}
