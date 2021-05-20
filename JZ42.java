/*
连续子数组的最大和
输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
要求时间复杂度为O(n)。
 */
public class JZ42 {
}

class JZ42Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length==0)return 0;
        return maxSubArray1(nums);
    }
    
    public int maxSubArray1(int[] num){
        int greatest = num[0];
        int cur = 0;
        for (int j : num) {
            if (cur <= 0) {
                cur = j;
            } else {
                cur += j;
            }
            if (cur > greatest) {
                greatest = cur;
            }
        }
        return greatest;
    }
}