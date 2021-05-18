/*
题目描述
矩阵中的路径
给定一个m*n 二维字符网格board和一个字符串单词word。如果word存在于网格中，返回true；否则，返回false
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格
同一个单元格内的字母不允许被重复使用。
 */

/*
使用dfs的思想
可行性剪枝：对不可行的匹配路线直接返回f
节省空间：将当前经过的位置置为'\0'，防止深度遍历时重复经过。递归返回时恢复
 */

public class JZ12 {
}

class JZ12Solution {

    // int index = 0;

    public boolean exist(char[][] board, String word) {
        if (board==null || board.length==0 || board[0].length==0 || word==null){
            return false;
        }
        char[] wordChar = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board,wordChar,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] word, int i, int j, int index){
        // 剪枝判定，如果超出边界，或者当前位置字符与字符串不匹配，则返回
        if (i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || board[i][j] != word[index])return false;
        // 当前匹配字符串索引已到末尾，返回
        if (index==word.length-1)return true;
        // 对当前位置置空
        board[i][j] = '\0';
        // 深度遍历
        boolean res = dfs(board,word,i-1,j,index+1) || dfs(board,word,i,j-1,index+1) ||
                dfs(board,word,i+1,j,index+1) || dfs(board,word,i,j+1,index+1);
        // 恢复
        board[i][j] = word[index];
        return res;
    }
}