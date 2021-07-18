/*
数字序列中某一位的数字
数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
请写一个函数，求任意第n位对应的数字。
 */

/*
思路：求解可分为3部：
1.确定n所在的数字的位数，记为digit
2.确定n所在的数字，记为num
3.确定n对应的数位
 */
public class JZ44 {
}

class JZ44Solution {
    public int findNthDigit(int n) {
        int digit = 1;
        //因为n<2^31，因此start和count在判断时可能溢出
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;         // 数位+1
            start *= 10;        // 每一个数位的起始是上一数位起始的10倍
            count = digit * start * 9;  //  每一个数位所含数字的数量是9*start，所含数字的位数总和就是9*start*digit
        }
        //
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }
}