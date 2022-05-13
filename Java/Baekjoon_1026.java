package Java;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arrA = new int[n];
        Integer[] arrB = new Integer[n];
        for(int i=0;i<n;i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());
        int res = 0;
        for(int i=0;i<n;i++){
            res += arrA[i] * arrB[i];
        }
        bw.write(res + "");
        bw.flush();
    }
}
