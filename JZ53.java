/*
在排序数组中查找数字
统计一个数字在排序数组中出现的次数。
 */

/*
用两次二分查找，找目标数字和目标数字-1的右边界
右边界条件：if (num[pivot]<=target) left = pivot+1;
 */

public class JZ53 {
}

class JZ53Solution {

    // 搜索target和target-1的有边界，作差
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    // helper作用是搜索target的右边界
    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}