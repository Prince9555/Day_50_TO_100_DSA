import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
   static int findPlatform(int arr[], int dep[], int n)
    {
        int maxP = 2500;
        int[] rangeSums = new int[maxP];
        int sol = 0;
        for(int i = 0; i < n; i++){
            rangeSums[arr[i]]++;
            rangeSums[dep[i]+1]--;
        }
        for(int i = 1; i < maxP; i++){
            rangeSums[i] += rangeSums[i-1];
            sol = Math.max(sol, rangeSums[i]);
        }
        return sol;
    }
}
