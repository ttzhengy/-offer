import java.util.ArrayList;

/*
题目描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

/*
用二分查找的方法找到array[left]>array[right]的区间
mid=（left+right）/2，令区间端点等于mid
结束循环条件为right-left==1
 */
public class JZ6 {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,1};
        System.out.println(new JZ6Solution().minNumberInRotateArray(arr));
    }
}

class JZ6Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array.length==0){
            return 0;
        }else {
            return bi(array,0,array.length-1);
        }
    }

    public int bi(int[] array,int left, int right){
        int mid = (left+right)/2;

        // 极端情况
        if (array[mid]==array[left] && array[right]==array[left]){
            int min = array[0];
            for (int i = 1; i < array.length; i++) {
                min = (min>array[i]?array[i]:min);
            }
            return min;
        }

        // 递归做法
        // if (right-left==1){
        //     return array[right];
        // }
        // if (array[mid]>array[right]){
        //     return bi(array,mid,right);
        // }else {
        //     return bi(array,left,mid);
        // }

        // 循环做法
        while (right-left!=1){
            mid = (left+right)/2;
            if (array[mid]>array[right]){
                left=mid;
            }else {
                right=mid;
            }
        }
        return array[right];
    }
}
