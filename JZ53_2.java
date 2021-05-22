/*
0~n-1中缺失的数字
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内
在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */

/*
二分
 */
public class JZ53_2 {
}

class JZ53_2Solution {
    public int missingNumber(int[] nums) {
        int low = 0,high = nums.length-1;
        int pivot = low+(high-low)/2;
        while (low<=high){
            pivot = low+(high-low)/2;
            // pivot是索引与数字对应的最后一个
            // low=pivot+1才是缺失的数字
            if (nums[pivot] == pivot) low = pivot+1;
            else high = pivot - 1;
        }
        return low;
    }
}