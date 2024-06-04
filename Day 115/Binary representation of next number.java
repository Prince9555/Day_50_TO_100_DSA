import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String binaryNextNumber(String s) {
        String ans = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '1') {
                ans = "0" + ans;;
                if(i == 0) {
                    return "1" + ans;
                }
            } else {
                ans = s.substring(0, i) + "1" + ans;
                break;
            }
        }
        ans = ans.replaceAll("^[0]*", "");
        return ans;
    }
}