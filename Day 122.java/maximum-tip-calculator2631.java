//{ Driver Code Starts
import java.io.*;
import java.util.*;

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

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            int[] brr = IntArray.input(br, n);

            Solution obj = new Solution();
            long res = obj.maxTip(n, x, y, arr, brr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {

    static class Order {

        int tipDifference;

        int waiterATip;

        int waiterBTip;

        

        Order(int tipDifference, int waiterATip, int waiterBTip) {

            this.tipDifference = tipDifference;

            this.waiterATip = waiterATip;

            this.waiterBTip = waiterBTip;

        }

    }

    

    public static long maxTip(int n, int maxOrdersA, int maxOrdersB, int[] tipsA, int[] tipsB) {

        List<Order> orders = new ArrayList<>();

        

        for (int i = 0; i < n; i++) {

            orders.add(new Order(Math.abs(tipsA[i] - tipsB[i]), tipsA[i], tipsB[i]));

        }

 

        orders.sort((o1, o2) -> o2.tipDifference - o1.tipDifference);

 

        long totalTips = 0;

        int ordersTakenByA = 0;

        int ordersTakenByB = 0;

 

        for (Order order : orders) {

            if ((order.waiterATip >= order.waiterBTip && ordersTakenByA < maxOrdersA) || ordersTakenByB == maxOrdersB) {

                totalTips += order.waiterATip;

                ordersTakenByA++;

            } else {

                totalTips += order.waiterBTip;

                ordersTakenByB++;

            }

        }

 

        return totalTips;

    }

}