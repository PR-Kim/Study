package Java;

import java.io.*;
import java.util.*;

public class Baekjoon_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Word[] arr = new Word[n];
        for(int i =0;i<arr.length;i++){
            arr[i] = new Word(br.readLine());
        }
        Arrays.sort(arr);
        // Word라는 클래스 구현없이 아래와 같이 썻어도 됐음
        /*
        Arrays.sort(arr, new Comparator<String>() {
	   	 		@Override
	   	 		public int compare(String s1, String s2) {
	   	 		if(s1.length() == s2.length()) {
	   	 			return s1.compareTo(s2);
	   	 		}else {
	   	 			return s1.length() - s2.length();
	   	 		}

	   	 	}
	   	 	});
         */
        // 그리고 큐 없이 출력할 때, i가 i-1이랑 같으면 출력 안하도록 했어도 됐음
        Queue<Word> que = new LinkedList<>();
        String ex = "";
        for(int i =0;i<arr.length;i++){
            //System.out.println(ex + " / " + arr[i].value);
            if(que.isEmpty()||!arr[i].value.equals(ex)){
                ex = arr[i].value;
                que.offer(arr[i]);
            }
        }
        while (!que.isEmpty()){
            bw.write(que.poll().value + "\n");
        }
        bw.flush();
    }
}
class Word implements Comparable<Word>{
    String value;
    public Word(String value){
        this.value = value;
    }
    public int compareTo(Word w){
        if(this.value.length()>w.value.length()) return 1;
        else if(this.value.length()<w.value.length()) return -1;
        else{
            if(this.value.compareTo(w.value)>0)return 1;
            else if(this.value.compareTo(w.value)<0) return -1;
            else return 0;
        }

    }

}