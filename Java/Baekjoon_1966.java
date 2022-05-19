package Java;

import java.io.*;
import java.util.*;

public class Baekjoon_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Baekjoon_1966 b= new Baekjoon_1966();
        for(int i = 0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            bw.write(b.solution(k,target,st) + "\n" );
        }
        bw.flush();
    }
    public int solution(int k, int target, StringTokenizer st){
        int answer = 0;
        PriorityQueue<priorityQue> prioQue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<priorityQue> que = new LinkedList<>();
        for(int i=0;i<k;i++){
            priorityQue tmp = new priorityQue(Integer.parseInt(st.nextToken()),i);
            prioQue.offer(tmp);
            que.offer(tmp);
        }
        int i=1;
        while (!que.isEmpty()){
            priorityQue tmp = que.poll();
            if(prioQue.peek().priority == tmp.priority){
                prioQue.poll();
                if(tmp.value==target)
                {
                    answer = i;
                    break;
                }
                i++;
            }
            else
            {
                que.offer(tmp);
            }

        }


        return answer;
    }
}
class priorityQue implements Comparable<priorityQue>{
    int priority;
    int value;
    public priorityQue(int priority, int value){
        this.priority = priority;
        this.value = value;
    }
    public int compareTo(priorityQue q){
        if(this.priority > q.priority) return 1;
        else if(this.priority < q.priority) return -1;
        return 0;
    }

}
