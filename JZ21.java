import java.util.Arrays;
/*
题目描述
调整数组顺序使奇数位于偶数前
输入一个整数数组，实现一个函数来调整该数组中数字的顺序
使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */

/*
类似快排的思路
 */
public class JZ21 {
    public static void main(String[] args) {
        int[] arr = {1,11,14};
        JZ21Solution jz21 = new JZ21Solution();
        int[] exchange = jz21.exchange(arr);
        System.out.println(Arrays.toString(exchange));
    }
}

class JZ21Solution {
    public int[] exchange(int[] nums) {
        int high = nums.length-1;
        int low = 0;
        int temp = 0;

        while (low<high){
            while (low<high && nums[low]%2!=0){
                low++;
            }
            while (low<high && nums[high]%2!=1){
                high--;
            }
            if (low<high){
                temp = nums[high];
                nums[high--] = nums[low];
                nums[low++] = temp;
            }
        }
        return nums;
    }
}