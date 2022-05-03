package Java;

import java.io.*;
import java.util.*;

public class MaximumIncome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Lecture> arrLst = new ArrayList<>();

        for(int i =0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrLst.add(new Lecture(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        MaximumIncome m = new MaximumIncome();
        int res = m.solution(arrLst);

        bw.write(res+"");
        bw.flush();
    }
    public int solution(ArrayList<Lecture> arrLst){
        int answer = 0;

        ArrayList<Lecture> priority = new ArrayList<>();
        Collections.sort(arrLst);
        /*
        for (Lecture a: arrLst) {
            System.out.println("day : " + a.dday + " / pay : " + a.pay);
        }

         */
        priority.add(arrLst.get(0));

        for(int i =1;i<arrLst.size();i++){
            if(priority.size()<arrLst.get(i).dday)
            {
                priority.add(arrLst.get(i));
            }
            else{
                do {
                    if(priority.get(priority.size()-1).pay<arrLst.get(i).pay)
                    {
                        priority.remove(priority.size()-1);
                        priority.add(arrLst.get(i));
                    }
                    else{
                        break;
                    }
                }while (priority.size()<=arrLst.get(i).dday);
            }
            Collections.sort(priority,new Comparator<Lecture>(){
                public int compare(Lecture a, Lecture b){
                    if(a.pay>b.pay)return -1;
                    else if(a.pay<b.pay) return 1;
                    return 0;
                }
            });
            /*
            for (Lecture a: priority) {
                System.out.println(" priority day : " + a.dday + " / pay : " + a.pay);
            }
            */

        }
        int i =0;
        while (i<priority.size()){
            answer += priority.get(i).pay;
            i+=1;
        }

        return answer;
    }
}
class Lecture implements Comparable<Lecture> {
    int pay;
    int dday;
    public Lecture(int pay, int dday){
        this.pay = pay;
        this.dday = dday;
    }
    public int compareTo(Lecture t){
        if(this.dday>t.dday) return 1;
        else if(this.dday == t.dday){
            if(this.pay>t.pay) return 1;
            else if(this.pay<t.pay) return -1;
            else return 0;
        }
        else if(this.dday<t.dday) return -1;
        return 0;
    }
}
