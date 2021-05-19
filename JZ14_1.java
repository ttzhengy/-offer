/*
题目描述
剪绳子
一根长度为n的绳子，把绳子剪成整数长度的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1]
请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */

/*
动态规划
数学推导，得出当剩余长度>4时，每个子段为3的情况下乘积最大
等于4时，分成两个2子段
 */
public class JZ14_1 {
}

class JZ14_1Solution {
    public int cuttingRope(int n) {
        if (n<=3)return n-1;
        int a = n/3;
        int b = n%3;
        if (b==0)return (int)Math.pow(3,a);
        if (b==1)return (int)Math.pow(3,a-1)*4;
        return (int)Math.pow(3,a-1)*6;
    }
}