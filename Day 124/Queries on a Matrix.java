//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int q = Integer.parseInt(s[1]);
            int[][] Queries = new int[q][4];
            for (int i = 0; i < q; i++) {
                String[] s1 = br.readLine().trim().split(" ");
                for (int j = 0; j < 4; j++)
                    Queries[i][j] = Integer.parseInt(s1[j]);
            }
            Solution obj = new Solution();
            int[][] ans = obj.solveQueries(n, Queries);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++) {
                    out.print(ans[i][j] + " ");
                }
                out.println();
            }
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    public int[][] solveQueries(int n, int[][] Q) {
        int[][] res = new int[n][n];

        // Applying the 2D difference array approach
        for (int i = 0; i < Q.length; i++) {
            int l1 = Q[i][0];
            int l2 = Q[i][1];
            int r1 = Q[i][2];
            int r2 = Q[i][3];

            // Top-left corner
            res[l1][l2]++;

            // Top-right corner (out of bounds check)
            if (r2 + 1 < n) {
                res[l1][r2 + 1]--;
            }

            // Bottom-left corner (out of bounds check)
            if (r1 + 1 < n) {
                res[r1 + 1][l2]--;
            }

            // Bottom-right corner (out of bounds check)
            if (r1 + 1 < n && r2 + 1 < n) {
                res[r1 + 1][r2 + 1]++;
            }
        }

        // Calculate the prefix sum to get the final matrix
        // First for rows
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] += res[i][j - 1];
            }
        }

        // Then for columns
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                res[i][j] += res[i - 1][j];
            }
        }

        return res;
    }
}