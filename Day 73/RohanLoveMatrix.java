import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.firstElement(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
        static long mod = 1000000007;

    static int firstElement(int n) {
        // code here
        long a=0;
        long b=1;
        while(n-- > 0){
      
            long c = (a+b)%mod;
            a = b%mod;
            b = c%mod;
        }
        return (int)a;
    }
}