/*
题目描述
机器人的运动范围
地上有一个m行n列的方格，从坐标[0,0]到坐标[m-1,n-1]
一个机器人从坐标[0,0]的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子
例如，当k为18时，机器人能够进入方格[35, 37]，因为3+5+3+7=18
但它不能进入方格[35,38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */

import java.util.LinkedList;
import java.util.Queue;

/*
bfs求解，使用队列存放
 */
public class JZ13 {
}

class JZ13Solution{
    public int movingCount(int m, int n, int k) {
        if (k==0){
            return 0;
        }
        int res = 0, x = 0, y = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            x = poll[0];
            y = poll[1];
            if (x>=m || y>=n || sumDigit(x)+sumDigit(y)>k || visited[x][y])continue;
            res++;
            visited[x][y] = true;
            queue.add(new int[]{x+1,y});
            queue.add(new int[]{x,y+1});
        }
        return res;
    }

    public int sumDigit(int i){
        int sum = 0;
        while (i != 0){
            sum += i%10;
            i /= 10;
        }
        return sum;
    }
}
