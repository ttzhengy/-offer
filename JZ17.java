/*
题目描述
打印从1到最大的n位数
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3
则打印出 1、2、3 一直到最大的 3 位数 999。
 */

/*
本题是考验的是大数输出，需要使用字符数组组合数字，用深度遍历的思想
 */
import java.util.Arrays;

public class JZ17 {
    public static void main(String[] args) {
        JZ17Solution jz17 = new JZ17Solution();
        int[] arr = jz17.printNumbers(2);
        System.out.println(Arrays.toString(arr));
    }
}

class JZ17Solution {
    // public int[] printNumbers(int n) {
    //     int size = (int)Math.pow(10,n);
    //     int[] arr = new int[size-1];
    //     for (int i = 1; i < size; i++) {
    //         arr[i-1] = i;
    //     }
    //     return arr;
    // }

    int[] res;
    // n是一共有的位数，nine是当前数字中9的个数
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int)Math.pow(10, n) - 1];
        // num是每一个数字的字符数组
        num = new char[n];
        // start用于屏蔽高位的0，将num的前几位丢弃
        start = n - 1;
        dfs(0);
        return res;
    }

    // 深度遍历的思路
    // x是从左到右处理到的位数
    void dfs(int x) {
        // 数字填充到最低位
        if(x == n) {
            // 高位0屏蔽
            String s = String.valueOf(num).substring(start);
            // 数字装到res数组
            if(!s.equals("0")) res[count++] = Integer.parseInt(s);
            // 当nine第一次增加时，即准备进位，屏蔽标志start退一位
            if(n - start == nine) start--;
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
}