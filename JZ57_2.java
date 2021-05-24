/*
和为s的连续正数数列
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）
序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */

/*
双指针，small指针标记连续数组的头，big指针标记连续数组的头
sum等于small到big之间的元素和
比较sum与target：
- 相等，则记录当前连续数组
- 大于等于，则sum-=small且small++
- 小于，则big++且sum+=big
 */
import java.util.ArrayList;
import java.util.List;

public class JZ57_2 {
    public static void main(String[] args) {
        JZ57_2Solution jz57_2Solution = new JZ57_2Solution();
        jz57_2Solution.findContinuousSequence(15);
    }
}

class JZ57_2Solution {
    public int[][] findContinuousSequence(int target) {
        if (target==0)return new int[0][0];
        List<int[]> res = new ArrayList<>();
        int small = 1,big = 2;
        int sum = small+big;
        while (small<big){
            if (sum==target){
                int[] temp = new int[big-small+1];
                for (int i = small; i <= big; i++) {
                    temp[i-small] = i;
                }
                res.add(temp);
            }
            if (sum>=target){
                sum-=small++;
            }
            if (sum<target){
                sum+=++big;
            }
        }
        return res.toArray(new int[0][]);
    }
}