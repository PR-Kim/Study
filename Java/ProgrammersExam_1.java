package Java;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ProgrammersExam_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ProgrammersExam_1 p = new ProgrammersExam_1();
        System.out.println("answer : " + p.solution("10001111111110000","2011111111111000003045"));
    }
    public String solution(String X, String Y){
        //List<Integer> aa= new ArrayList<>();

        String answer = "";
        long[] arr = new long[10];
        for(int i =9;i>-1;i--){
            int var = i;
            long xCnt = X.chars().filter(c->c-'0'==var).count();
            long yCnt = Y.chars().filter(c->c-'0'==var).count();
            long number = Math.min(xCnt,yCnt);
            answer+= (i+"").repeat((int)number);
        }

        if(answer.length()==0) answer="-1";
        if(answer.startsWith("0")) answer = "0";
        return answer;
    }
}
