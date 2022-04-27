package Java;

import java.util.Arrays;

public class Shallow_DeepCopy {
    public static void main(String[] args){
        //얕은 복사
        //복사된 배열이나 원본 배열이 변경될 때 서로 간의 값이 같이 변경
        int[] a = {1,2,3,4,5};
        int[] b = a;

        //깊은 복사
        //복사된 배열이나 원본 배열이 변경될 때 서로 간의 값은 바뀌지 않음
        //case1.
        int[] c = {1,2,3,4,5};
        int[] d = new int[c.length];
        for(int i=0;i<c.length;i++){
            d[i] = c[i];
        }

        //case2.
        int[] e = {1,2,3,4,5};
        int[] f = a.clone();

        //case3.
        int[] g = {1,2,3,4,5};
        int[] h = Arrays.copyOf(g,g.length);

        //부분 복사
        int[] i = {1,2,3,4,5};
        int[] j = Arrays.copyOfRange(i,0,3);

    }
}
