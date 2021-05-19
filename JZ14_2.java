/*
题目描述
剪绳子
一根长度为n的绳子，把绳子剪成整数长度的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1]
请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
2 <= n <= 1000
 */

/*
求解思路一致，但是要注意大数问题
使用循环求余或者快速幂求余
 */
public class JZ14_2{
    public static void main(String[] args) {
        JZ14_2Solution jz14_2Solution = new JZ14_2Solution();
        int i = jz14_2Solution.cuttingRope(127);
        System.out.println(i);
    }
}

class JZ14_2Solution {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if(b == 0) return (int)(rem * 3 % p);
        if(b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);
    }

    // 快速幂求余
    public long remainder1(long x, int a, int p){
        long rem = 1;
        while (a>0){
            if (a%2==1)rem=(rem*x)%p;
            x = (x*x) % p;
            a/=2;
        }
        return rem;
    }

    // 循环求余
    public int remainder2(int x, int a, int p){
        int rem = 1;
        while (a>0){
            rem = (rem*x)%p;
            a--;
        }
        return rem;
    }
}