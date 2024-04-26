
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(n, m, matrix);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] FindExitPoint(int n, int m, int[][] arr) {
        // code here
        int[] ex = new int[2];
        int i = 0;
        int j = 0;
        int rdir = 0;
        int cdir = 1;
        while(i < n && j < m && i >= 0 && j >=0){
            if(arr[i][j] == 1){
                arr[i][j] = 0;
                if(rdir == 0 && cdir == 1){
                    rdir = 1;
                    cdir = 0;
                }
                else if(rdir == 1 && cdir == 0){
                    rdir = 0;
                    cdir = -1;
                }
                else if(rdir == 0 && cdir == -1){
                    rdir = -1;
                    cdir = 0;
                }
                else if(rdir == -1 && cdir == 0){
                    rdir = 0;
                    cdir = 1;
                }
            }
            ex[0] = i;
            ex[1] = j;
            i+=rdir;
            j+=cdir;
        }
        return ex;
    }


}