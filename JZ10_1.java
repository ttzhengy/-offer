public class JZ10_1 {
    public static void main(String[] args) {
        JZ10_1Solution jz10_1Solution = new JZ10_1Solution();
        for (int i = 0; i < 101; i++) {
            System.out.printf("fib(%d)=%d\n",i,jz10_1Solution.fib(i));
        }
    }
}

class JZ10_1Solution {
    // public int fib(int n) {
    //     if (n==0){
    //         return 0;
    //     }else if (n==1){
    //         return 1;
    //     }else {
    //         return ((fib(n-1)+fib(n-2))%1000000007);
    //     }
    // }

    int[] arr;

    public JZ10_1Solution(){
        arr = new int[101];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < 101; i++) {
            arr[i] = (arr[i-1] + arr[i-2])%1000000007;
        }
    }

    public int fib(int n){
        return arr[n];
    }
}
