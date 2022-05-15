package Java;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_11650 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        Coord[] arr = new Coord[n];

        for(int i =0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Coord(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Baekjoon_11650 b = new Baekjoon_11650();
        b.solution(arr);
    }
    public void solution(Coord[] arr) throws  IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            bw.write(arr[i] + "\n");
        }

        bw.flush();
    }
}
class Coord implements Comparable<Coord>{
    int x;
    int y;
    public Coord(int x , int y){
        this.x = x;
        this.y = y;
    }
    public int compareTo(Coord c){
        if(this.x > c.x) return 1;
        else if(this.x < c.x) return -1;
        else {
            if (this.y > c.y) return 1;
            else if (this.y < c.y) return -1;
            else return 0;
        }
    }
    public String toString(){
        return this.x + " " + this.y;
    }
}
