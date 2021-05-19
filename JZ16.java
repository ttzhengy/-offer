/*
题目描述
数值的整数次方
实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 */

/*
快速幂
 */
public class JZ16 {
    public static void main(String[] args) {
        JZ16Solution jz16Solution = new JZ16Solution();
        // double pow = jz16Solution.pow(100.0,10000);

    }
}

class JZ16Solution {
    public double myPow(double x, int n) {
        if (n==0)return 1;
        if (x==0)return 0;
        long b = n;
        if (n<0){
            b = -b;
            x = 1/x;
        }
        double res = 1.0;

        // 快速幂
        while(b > 0) {
            // 当前位为1，则res乘当前位的幂次
            if((b & 1) == 1) res *= x;
            // 下一位的幂次
            x *= x;
            // 右移一位
            b >>= 1;
        }
        return res;
    }

    // public double pow(double x, int n){
    //     double result = 1.0;
    //     for (int i = 1; i <= n ; i++) {
    //         result *= x;
    //     }
    //     return result;
    // }


}