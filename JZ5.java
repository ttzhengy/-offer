/*
题目描述
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */

/*
String.toCharArray方法
内存优秀版：直接建立一个长度*3的字符数组，遍历原字符串数组，分别判断
 */

public class JZ5 {
    public static void main(String[] args) {
        String s = " dfg afger sdf";
        JZ5Solution jz5Solution = new JZ5Solution();
        System.out.println(jz5Solution.replaceSpace(s));
    }
}

class JZ5Solution {
    // public String replaceSpace(String s) {
    //     StringBuilder stringBuilder = new StringBuilder();
    //     for (char c:s.toCharArray()){
    //         if (c==' '){
    //             stringBuilder.append("%20");
    //         }else {
    //             stringBuilder.append(c);
    //         }
    //     }
    //     return stringBuilder.toString();
    // }

    // 内存优秀版
    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }
}