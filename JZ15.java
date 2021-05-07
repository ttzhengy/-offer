/*
题目描述
二进制中1的个数
请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数
例如，把9表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2
 */

/*
一个二进制数-1，其最右边的1（假设为m位）变成0，m位右边的0全部变成1
拿这个数与原数字做与运算，则得到一个m位及后面位全部置0的新数字，count++
循环直到所得数字成为0，输出count
 */
public class JZ15 {
    public static void main(String[] args) {
        JZ15Solution jz15 = new JZ15Solution();
        System.out.println(jz15.hammingWeight(0x7FFFFFFF));
        System.out.println(jz15.hammingWeight(0x80000000));
        System.out.println(jz15.hammingWeight(0xFFFFFFFF));
        System.out.println(jz15.hammingWeight(0));
    }
}

class JZ15Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n!=0){
            n = (n-1)&n;
            count++;
        }
        return count;
    }

    //普通做法
    // public int  hammingWeight(int n){
    //     int count = 0;
    //     int flag = 1;
    //     while (flag!=0){
    //         if ((n&flag)!=0){
    //             count++;
    //         }
    //         flag = flag<<1;
    //     }
    //     return count;
    // }
}