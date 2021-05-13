/*
题目描述
顺时针打印矩阵
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */

/*
设定上下左右四个边界值，每遍历一条边就让对应边界值++或--
 */
public class JZ29 {
}

class JZ29Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length==0){return new int[0];}
        int left = 0;
        int right = matrix[0].length-1;
        int up = 0;
        int down = matrix.length-1;
        int[] arr = new int[(right+1)*(down+1)];
        int index = 0;

        while (true){
            for (int i = left; i <= right; i++) {
                arr[index++]=matrix[up][i];
            }
            if (++up > down)break;

            for (int i = up; i <= down; i++) {
                arr[index++]=matrix[i][right];
            }
            if (--right < left)break;

            for (int i = right; i >= left; i--) {
                arr[index++]=matrix[down][i];
            }
            if (--down < up)break;

            for (int i = down; i >= up; i--) {
                arr[index++]=matrix[i][left];
            }
            if (++left > right)break;
        }
        return arr;
    }
}