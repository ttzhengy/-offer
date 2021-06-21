/*
反转单词顺序
输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理
例如输入字符串"I am a student. "，则输出"student. a am I"。
*/

/*
双指针
指针分别指向单词前的空格和单词尾
倒序遍历字符串，每确定一个单词的边界，就将该单词填充到StringBuilder
 */
public class JZ58_1 {
    public static void main(String[] args) {

    }
}

class JZ58_1Solution{
    public String reverseWords(String s){
        // trim:取出两端空格
        s = s.trim();
        int i = s.length()-1;
        int j = s.length();
        StringBuilder sb = new StringBuilder();

        while(i>=0){
            // 当头指针指向单词前空格或指向字符串前
            while(i>=0 && s.charAt(i) != ' ')i--;
            sb.append(s, i + 1, j + 1).append(" ");
            // 令指针移到前一个单词上
            while(i>=0 && s.charAt(i) == ' ')i--;
            j=i;
        }

        return sb.toString().trim();
    }
}