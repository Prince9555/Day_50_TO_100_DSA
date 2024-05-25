import java.util.*;

class GFG {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T > 0) {
            int N = sc.nextInt();
            int k = sc.nextInt();
            int ar[] = new int[N];
            //	int count = 0;
            for (int i = 0; i < N; i++) ar[i] = sc.nextInt();

            System.out.println(new Solution().max_Books(ar, N, k));
            T--;
        }
    }
}
// } Driver Code Ends


class Solution {
    long max_Books(int arr[], int n, int k) {
        // Your code here
        int i = 0;
        long max =0;
        while(i <n)
        {
            long temp =0;
    while(i <n && arr[i]<= k)
            {
                temp += arr[i];
                i++;
            }
            max = Math.max(max,temp);
        
            i++;
        }
        return max;
    }
}