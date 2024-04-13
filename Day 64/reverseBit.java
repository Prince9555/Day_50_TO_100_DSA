import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.reversedBits(X));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static Long reversedBits(Long x) {
        // code here
        long ans=0;
        long bitLength=32;
        for(int i=0;i<bitLength;i++){
            ans<<= 1;
            if((x & 1)==1){
                ans |=1;
            }
            x>>=1;
        }
        return ans;
    }
};