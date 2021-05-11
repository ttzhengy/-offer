/*
题目描述
二维数组中的查找
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

/*
从右上角开始，左上最小，右下最大，以类似二分的思路搜索，注意输入为空的边界条件
 */
public class JZ4 {
    public static void main(String[] args) {
        int[][] matrix = {{}};
        JZ4Solution jz4 = new JZ4Solution();
        boolean bool = jz4.findNumberIn2DArray(matrix, 1);
        System.out.println(bool);
    }
}

class JZ4Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length-1;
        while (matrix[i][j]!=target){
            if (matrix[i][j]>target){
                if (j>0){
                    j--;
                }else break;
            }else {
                if (i<matrix.length-1){
                    i++;
                }else break;
            }
        }
        return matrix[i][j]==target;
    }
}