import java.util.*;
class LeetCode_WhereWillTheBallFall{
    public static void main(String[] args) {
        int [][] grid = {
            {1,1,1,-1,-1},
            {1,1,1,-1,-1},
            {-1,-1,-1,1,1},
            {1,1,1,1,-1},
            {-1,-1,-1,-1,-1}
        };
        System.out.println(Arrays.toString(findBall(grid)));
    }
    public static int[] findBall(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            int k =i;
            for(int j=0;j<m;j++){
                if(grid[j][k]==1){
                    if(k+1<n && grid[j][k+1]==1){
                        k++;
                    }else{
                        k=-1;
                        break;
                    }
                }else{
                    if(k-1>=0 && grid[j][k-1]==-1){
                        k--;
                    }else{
                        k=-1;
                        break;
                    }
                }
            }
            ans[i]=k;
        }
        return ans;
    }
}