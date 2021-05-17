/*
 题目描述
 TopK
 输入整数数组 arr ，找出其中最小的 k 个数
 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */

/*
思路1：partition函数
思路2：最大堆
 */

import java.util.Arrays;
import java.util.PriorityQueue;


public class JZ40{
}

class JZ40Solution1 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k==0 || arr.length==0){
            return new int[0];
        }
        return partitionArray(arr,0,arr.length-1,k-1);
    }

    public int[] partitionArray(int[] arr,int low,int high,int k){
        int p = quickSort(arr,low,high);
        if (p==k){
            return Arrays.copyOf(arr,k+1);
        }
        return p>k?partitionArray(arr,low,p-1,k):partitionArray(arr,p+1,high,k);
    }

    public int quickSort(int[] arr,int left,int right){
        int pivot = arr[left];
        while (left < right){
            while (left < right && pivot < arr[right]){
                right--;
            }
            if (left < right){
                arr[left++]=arr[right];
            }
            while (left < right && pivot > arr[left]){
                left++;
            }
            if (left < right){
                arr[right--] = arr[left];
            }
        }
        arr[left] = pivot;
        return left;
    }
}

class JZ40Solution{
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k==0 || arr.length==0){
            return new int[0];
        }
        return partitionArray(arr,k);
    }

    public int[] partitionArray(int[] arr,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int i : arr) {
            if (pq.size()<k){
                pq.offer(i);
            }else if (i<pq.peek()) {
                pq.poll();
                pq.offer(i);
            }
        }

        int[] res = new int[pq.size()];
        int index = 0;
        for (int a : pq) {
            res[index++] = a;
        }
        return res;
    }
}
