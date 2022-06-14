package Java;

import java.io.*;

public class Baekjoon_6588 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tmp=-1;
        Baekjoon_6588 b = new Baekjoon_6588();

        boolean[] primeArr = b.getPrimeList();
        while (tmp!=0){
            tmp = Integer.parseInt(br.readLine());
            if(tmp==0) break;
            bw.write(b.solution(tmp,primeArr));
            bw.newLine();
            bw.flush();
        }


    }
    public String solution(int a,boolean[] primeArr){
        String answer = "Goldbach's conjecture is wrong";
        for(int i =0;i<a;i++){
            if(!primeArr[i] && !primeArr[a-i]){
                answer = a + " = " + i + " + " + (a-i);
                break;
            }
        }
        return answer;
    }
    public boolean[] getPrimeList(){
        boolean[] arr = new boolean[1000001];
        arr[0]=arr[1]=true;
        for(int i =2;i*i<arr.length;i++){
            if(!arr[i]) for(int j=i*i; j<=1000000; j+=i) arr[j]=true;
        }
        return arr;
    }
}
