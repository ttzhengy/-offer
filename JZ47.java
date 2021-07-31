/*
礼物的最大价值
在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）
你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 */

/*
动态规划
可以在原矩阵上操作，某格的礼物价值最大值是左格和上格中的最大值加当前格
为了减少冗余循环判断，可以一开始先初始化行或列为0的格
 */
public class JZ47 {
}

class JZ47Solution {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 1;i < n;i++){
            grid[0][i] += grid[0][i-1];
        }
        for(int j = 1;j < m;j++){
            grid[j][0] += grid[j-1][0];
        }
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                grid[i][j] += (grid[i][j-1] > grid[i-1][j]) ? grid[i][j-1] : grid[i-1][j];
            }
        }
        return grid[m-1][n-1];
    }
}