//{ Driver Code Starts
import java.util.*;

class ExtraElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n - 1; i++) b[i] = sc.nextInt();
            Solution g = new Solution();
            System.out.println(g.findExtra(n, a, b));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int findExtra(int n, int arr1[], int arr2[]) {
        // add code here.
        int l=0;
        int h=n-2;
        while(l<=h)
        {
            int mid=(l+h)/2;
            if(arr1[mid]==arr2[mid])
            {
                l=mid+1;
            }
            else if(arr1[mid]<arr2[mid])
            {
                if(mid==0||arr1[mid-1]==arr2[mid-1])
                return mid;
                h=mid-1;
            }
        }
        return n-1; 
    }
}