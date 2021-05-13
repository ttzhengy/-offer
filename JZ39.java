/*
题目描述
数组中出现数字次数超过一半的数字
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 */

/*
思路1：超过一半的数即众数，可以遍历数组，使用摩尔投票法摩尔投票法
 */
public class JZ39 {
}

class JZ39Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != temp){
                if (count == 1){
                    temp = nums[i];
                }else {
                    count--;
                }
            }else {
                count++;
            }
        }
        return temp;
    }
}