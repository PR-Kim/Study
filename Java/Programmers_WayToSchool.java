package Java;

public class Programmers_WayToSchool {
    public static void main(String[] args){
        Programmers_WayToSchool p = new Programmers_WayToSchool();
        int[][] puddles = new int[][]{{2,2}};
        System.out.println(p.solution(4,3,puddles));
    }
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] arr = new int[n][m];
        for(int i = 0;i<puddles.length;i++){
            arr[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        arr[0][0] = 1;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(i==0 &&j==0)continue;
                if(arr[i][j] == -1){
                    arr[i][j]=0;
                    continue;
                }
                int col = ((j!=0)? arr[i][j-1]:0)%1000000007;
                int row = ((i!=0)? arr[i-1][j]:0)%1000000007;
                arr[i][j] = (col+row)%1000000007;
            }
        }
        answer = arr[n-1][m-1];
        return answer;
    }
}
