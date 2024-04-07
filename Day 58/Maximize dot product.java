import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int m = sc.nextInt();
                    int a[] = new int[n];
                    int b[] = new int[m];
                    for(int i = 0;i<n;i++)
                        a[i] = sc.nextInt();
                    for(int i = 0;i<m;i++)
                        b[i] = sc.nextInt();    
                    Solution ob = new Solution();
                    System.out.println(ob.maxDotProduct(n, m, a, b));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution {
	public int maxDotProduct(int n, int m, int arr1[], int arr2[]) {
	    int[][] dp = new int[n + 1][m + 1];
	    
	    for (int j = 1; j < m; j++) {
	        dp[0][j] = -1_000_000_000;
	    }
	    
	    for (int i = 1; i <= n; i++) {
	        for (int j = 1; j <= m; j++) {
	            
	            int notPick = 0 + dp[i - 1][j];
	            
                int pick = arr1[i - 1] * arr2[j - 1] + dp[i - 1][j - 1];
                
                dp[i][j] = Math.max(pick, notPick);
	        }
	    }
	    
	    return dp[n][m];
	}
}