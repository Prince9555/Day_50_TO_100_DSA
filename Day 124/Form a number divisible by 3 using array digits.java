//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(a[i]);

            Solution ob = new Solution();
            System.out.println(ob.isPossible(N, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int isPossible(int n, int arr[]) {
        // If any number is divisible by 3 then sum of those digits is also divisible by 3
        
        long sum = 0;
        
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        if(sum%3 == 0) return 1;
        
        return 0;
    }
}