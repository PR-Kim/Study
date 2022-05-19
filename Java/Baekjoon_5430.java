package Java;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Baekjoon_5430 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i =0;i<n;i++){
            String func = br.readLine();
            int size = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();
            String[] arr = arrStr.replace("[","").replace("]","").split(",");
            //System.out.println(arr.length);
            ArrayList<Integer> intLst = new ArrayList<>();
            ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
            for(int j =0;j<size;j++){
                deque.add(Integer.parseInt(arr[j]));
            }
            String res = "";
            boolean isFront = true;
            for(int j =0;j<func.length();j++){
                res = "";
                if(func.charAt(j) == 'R'){
                    //Collections.reverse(intLst);
                    isFront = !isFront;
                }
                else if(func.charAt(j) == 'D'){
                    if(deque.isEmpty()){
                        res = "asdf";
                        break;
                    }
                    else{
                        if(isFront){
                            deque.pollFirst();
                        }
                        else
                            deque.pollLast();

                    }
                }
            }
            if(res.length()==0)
            {
                bw.write("[");
                if(deque.size()>0){
                    if(isFront)
                        bw.write(deque.pollFirst()+"");
                    else
                        bw.write(deque.pollLast()+"");
                    while (!deque.isEmpty()){
                        if(isFront){
                            bw.write(","+deque.pollFirst());
                        }
                        else
                        {
                            bw.write(","+deque.pollLast());
                        }
                    }
                }
                bw.write("]" + "\n");
            }
            else
                bw.write("error" + "\n");
        }
        bw.flush();
    }
}
