package Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Programmers_FarthestNode {
    int max;
    int ea;
    public static void main(String[] args){
        Programmers_FarthestNode p = new Programmers_FarthestNode();
        int n = 6;
        int[][] vertex = new int[][]{{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        System.out.println(p.solution(n,vertex));
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        max = Integer.MIN_VALUE;
        List<ArrayList<Integer>> lst = new ArrayList<>();
        for(int i =0;i<n;i++){
            lst.add(new ArrayList<>());
        }
        //int[][] vertex = new int[n][n];
        for(int i =0;i<edge.length;i++){
            int a = edge[i][0]-1;
            int b = edge[i][1]-1;
            lst.get(a).add(b);
            lst.get(b).add(a);
            //vertex[a][b] = 1;
            //vertex[b][a] = 1;
        }
        Queue<int[]> que = new LinkedList<>();
        int[] visit = new int[n];
        visit[0] = 1;
        for(int i =0;i<lst.get(0).size();i++){

                int[] arr = new int[]{1,lst.get(0).get(i)};
                que.offer(arr);

        }
        while (!que.isEmpty()){
            int[] arr = que.poll();
            int cnt = arr[0];
            int node = arr[1];
            if(visit[node]!=1){
                if(cnt>max){
                    max = cnt;
                    ea = 1;
                }
                else if(cnt==max){
                    ea+=1;
                }
                visit[node] = 1;
                for(int i =0;i<lst.get(node).size();i++){

                        int[] tmp = new int[]{cnt+1,lst.get(node).get(i)};
                        que.offer(tmp);

                }
            }
        }
        answer = ea;
        return answer;
    }
}

