/*
字符串的排列
输入一个字符串，打印出该字符串中字符的所有排列。你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
*/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
深度遍历，回溯法
先固定第一位字符，再固定第二位字符。。。直到固定最后一位，得到一个结果
回溯到上一位，交换当前位与遍历位，再进行dfs，直到当前位遍历结束或剪枝
*/

public class JZ38 {
    public static void main(String[] args) {

    }
}

class JZ38Solution {
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    // dfs函数的传入参数代表当前的位数
    public void dfs(int x){
        if(x == c.length-1){
            res.add(String.valueOf(c));
            return;
        }
        // 对每一个位，建立一个新的set保存重复元素
        HashSet<Character> set = new HashSet<>();
        // 从当前位开始遍历后续位，逐个交换再复原
        for(int i = x;i<c.length;i++){
            // 判断是否重复元素，是则剪枝
            if(set.contains(c[i]))continue;
            // 否则将当前元素加入集合
            set.add(c[i]);
            // 交换当前位与遍历位
            swap(i,x);
            // 固定当前位，对后续位dfs
            dfs(x+1);
            // 回复
            swap(x,i);
        }

    }

    public void swap(int a, int b){
        char temp = c[b];
        c[b] = c[a];
        c[a] = temp;
    }
}