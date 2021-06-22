public class JZ10_2 {

}

class JZ10_2Solution {
    public int numWays(int n) {
        if(n==0 || n==1)return 1;
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2;i<=n;i++){
            arr[i] = (arr[i-1]+arr[i-2])%1000000007;
        }
        return arr[n];
    }
}
