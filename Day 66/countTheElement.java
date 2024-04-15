import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    int n=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String line2 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    String[] b1 = line2.trim().split("\\s+");
		    int a[]=new int[n];
		    int b[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(a1[i]);
		        b[i]=Integer.parseInt(b1[i]);
		    }
		    int q = Integer.parseInt(br.readLine());
		    int query[]=new int[q];
		    for(int i=0;i<q;i++)
		    {
		        query[i]=Integer.parseInt(br.readLine());
		    }
		    Solution ob=new Solution();
		    int ans[]=ob.countElements(a,b,n,query,q);
		    for(int i=0;i<q;i++)
		    System.out.println(ans[i]);
		    
		}
	}
}

// } Driver Code Ends



class Solution {
    public static int[] countElements(int a[], int b[], int n, int query[], int q) {
        // Step 1: Create a frequency array for elements in b
        int maxB = Arrays.stream(b).max().getAsInt();
        int[] freqB = new int[maxB + 1];
        for (int num : b) {
            freqB[num]++;
        }
        
        // Step 2: Process queries
        int[] result = new int[q];
        for (int i = 0; i < q; i++) {
            int count = 0;
            int value = a[query[i]]; // value of a[x]
            // Step 3 and 4: Sum up frequencies of elements less than or equal to a[x]
            for (int j = 0; j <= value; j++) {
                if (j <= maxB) {
                    count += freqB[j];
                }
            }
            result[i] = count;
        }
        
        return result;
    }
}
