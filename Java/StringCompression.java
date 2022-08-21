package Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StringCompression {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringCompression s = new StringCompression();
        System.out.println(s.solution("abcabcabcabcdededededede"));
    }
    public int solution(String s){
        int answer = 0;
        int totalLength = s.length();
        int mid = s.length()/2;
        String answerStr= s;
        for(int i =1;i<=mid;i++){
            String compStr = "";
            String tmp = s.substring(0,i);
            int comp = 1;
            for(int j=i;j<s.length();j+=i){
                if(j+i<=s.length() && tmp.equals(s.substring(j,j+i))){
                    //같으면  comp+1;
                    comp+=1;
                    if(j+i==s.length()){
                        if(comp==1){
                            compStr += tmp;
                        }else{
                            compStr+= comp+tmp;
                        }
                    }
                }
                else{
                    if(comp==1){
                        compStr += tmp;
                    }else{
                        compStr+= comp+tmp;
                    }
                    if(j+i>=s.length()){
                        compStr += s.substring(j);
                    }
                    else{
                        tmp = s.substring(j,j+i);
                    }
                    comp = 1;
                }
            }
           // System.out.println(compStr);
            if(compStr.length()<answerStr.length()){
                answerStr = compStr;
            }

        }
        answer = answerStr.length();
        return answer;
    }
}
