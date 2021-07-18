/*
把数组排成最小的数
输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 */

/*
快排，对排序的逻辑做改动
使用compareTo函数对两元素的拼接字符串比较
 */
public class JZ45 {
}

class JZ45Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0;i<nums.length;i++){
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs,0,strs.length-1);
        StringBuilder res = new StringBuilder();
        for(String str: strs){
            res.append(str);
        }
        return res.toString();
    }

    public void quickSort(String[] strs,int l,int r){
        if(l>=r)return;
        int i = l;
        int j = r;
        String temp = strs[i];
        while(i<j){
            while((strs[j] + strs[i]).compareTo(strs[i] + strs[j]) >= 0 && i<j)j--;
            while((strs[i] + strs[j]).compareTo(strs[j] + strs[i]) <= 0 && i<j)i++;
            temp =  strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
        }
        strs[i] = strs[l];
        strs[l] = temp;
        quickSort(strs,i+1,r);
        quickSort(strs,l,i-1);
    }
}