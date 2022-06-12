package Java;

import java.util.*;
import java.io.*;
//백준 1644 연속된 소수 합으로 나타낼 수 있는 경우의 수

public class Baekjoon_1644 {
    public static int res = 0;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        // System.out.println(n);
        Baekjoon_1644 m = new Baekjoon_1644();
        ArrayList<Integer> arrLst = m.getPrimeList(n);
        m.solution(n,arrLst);
        bw.write(res + "");
        bw.flush();

    }
    public boolean isPrime(int a){
        boolean answer = true;
        for(int i=2;i<(a/2)+1;i++){
            if(a%i == 0){
                //System.out.println("i : "+i);
                answer = false;
                break;
            }
        }
        return answer;
    }
    public ArrayList<Integer> getPrimeList(int a){
        ArrayList<Integer> arrLst  = new ArrayList<>();
        boolean[] prime = new boolean[a+1];
        prime[0] = prime[1] = true;
        for(int i=2; i*i<=a; i++){
            if(!prime[i]) for(int j=i*i; j<=a; j+=i) prime[j]=true;
        }
        for(int i=1; i<=a;i++){
            if(!prime[i]) arrLst.add(i);
        }
        //System.out.println(arrLst.toString());
        return arrLst;
    }
    public void solution(int a, ArrayList<Integer> arrLst){
        int curr = 0;
        int left = 0;
        int right = 0;
        while(right<arrLst.size()){
            if(curr==a){
                res+=1;
                //System.out.println("res +=1");
            }
            if(curr<a){
                curr+= arrLst.get(right);
                right+=1;
                //System.out.println("plus right : " + curr);
            }
            else if(curr>=a){
                curr-=arrLst.get(left);
                left+=1;
               // System.out.println("minus left : " + curr);
            }
            if(right==arrLst.size()){
                if(isPrime(a)) res+=1;
            }
        }

        //if(isPrime(a)) res+=1;
    }


}
