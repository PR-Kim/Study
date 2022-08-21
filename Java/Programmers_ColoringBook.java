package Java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_ColoringBook {
    public static void main(String[] args){
        Programmers_ColoringBook p = new Programmers_ColoringBook();
        int[][] pic = new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        System.out.println(Arrays.toString(p.solution(6,4,pic)));
    }
    public int[] solution(int m, int n, int[][] picture){
        int[] answer = {};
        int[] ni = {1,0,-1,0};
        int[] nj = {0,1,0,-1};

        int[][] visit = new int[m][n];
        Queue<int[]> que = new LinkedList<>();
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(picture[i][j]!=0 && visit[i][j]==0){
                    int curr = 0;
                    numberOfArea+=1;
                    visit[i][j] = 1;
                    que.offer(new int[]{i,j,picture[i][j]});
                    while (!que.isEmpty()){
                        int[] pos = que.poll();
                        curr +=1;
                        int row = pos[0];
                        int col = pos[1];
                        int val = pos[2];
                        for(int k=0;k<4;k++){
                            if(row+ni[k]>-1 && row+ni[k]<picture.length && col+nj[k]>-1 && col+nj[k]<picture[0].length&& picture[row+ni[k]][col+nj[k]] == val && visit[row+ni[k]][col+nj[k]]==0){
                                visit[row+ni[k]][col+nj[k]] = 1;
                                que.offer(new int[]{row+ni[k],col+nj[k],val});
                            }
                        }
                    }
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,curr);
                }
            }
        }
        answer = new int[]{numberOfArea,maxSizeOfOneArea};
        return answer;
    }
}
