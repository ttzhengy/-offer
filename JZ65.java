/*
不用加减乘除做加法
写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 */

/*
位运算
两数相加，不进位的数位由异或得出，进位的数位由与得出并左移一位
循环至进位数为0
 */
public class JZ65 {
}

class JZ65Solution {
    public int lastRemaining(int n, int m) {
        int x = 0;
        for(int i=2;i<=n;i++){
            x = (x + m) % i;
        }
        return x;
    }
}
