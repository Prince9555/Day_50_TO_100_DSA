//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getPrimes(n);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends




class Solution {
    public static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        return isPrime;
    }
    public static ArrayList<Integer> getPrimes(int n) {
         boolean[] isPrime = sieve(n);
        ArrayList<Integer> prime = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(isPrime[i]){
                prime.add(i);
            }
        }
        
        int i=0;
        int j=prime.size()-1;
        while(i<=j){
            int a = prime.get(i);
            int b = prime.get(j);
            if(a+b==n){
                ans.add(a);
                ans.add(b);
                return ans;
            }
            else if(a+b<n){
                i++;
            }
            else{
                j--;
            }
        }
        ans.add(-1);
        ans.add(-1);
        return ans;
    }
}