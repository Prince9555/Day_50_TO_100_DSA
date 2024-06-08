class GfG
{
    int maxChainLength(Pair arr[], int n)
    {
       // your code here
       Arrays.sort(arr, Comparator.comparingInt(o -> o.y));

        int chainLen = 1;
        int chainEnd = arr[0].y;

        for (int i = 1; i < n; i++) {
            if (arr[i].x > chainEnd) {
                chainLen++;
                chainEnd = arr[i].y;
            }
        }

        return chainLen;
    }
}


