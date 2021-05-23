/*
和为s的两个数字
输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s
如果有多对数字的和等于s，则输出任意一对即可。
 */

/*
因为数组是递增的，所以可以用双指针，分别从头尾向中间移动
和小于目标则low++，大于目标则high--
 */
public class JZ57 {
}

class JZ57Solution {
    public int[] twoSum(int[] nums, int target) {
        int low = 0,high = nums.length-1;
        while (low<high){
            if (nums[low]+nums[high]>target)high--;
            else if (nums[low]+nums[high]<target)low++;
            else return new int[]{nums[low],nums[high]};
        }
        return new int[0];
    }
}
