import java.util.*;

/*
题目描述
找出数组中重复的数字。
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */

/*
两种思路：
    第一种，哈希表做法。添加表中已有的value时，set.add()返回-1

    第二种：书本做法。根据给出的长度和数字范围，将数字都放到对应索引的位置。
    直到比较过程中发现重复的数字，或者全都不重复
 */
public class JZ3 {
    public static void main(String[] args) {
        // int[] arr = {2, 3, 1, 0, 2, 5, 3};
        int[] arr = {9,8,7,6,5,5,3,2,1,0};
        JZ3Solution jz3Solution = new JZ3Solution();
        System.out.println(jz3Solution.findRepeatNumber(arr));
    }
}

class JZ3Solution {
    public int findRepeatNumber(int[] nums) {
        int length = nums.length;
        int temp;
        for (int i = 0; i < length; i++) {
            while (nums[i]!=i){
                if (nums[nums[i]] == nums[i]){
                    return nums[i];
                }
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;
    }

    public int findRepeatNumberBySet(int[] nums){
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}