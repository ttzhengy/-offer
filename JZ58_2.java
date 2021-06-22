/*
左旋转字符串
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能
比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
*/

/*
注意边界条件
 */
public class JZ58_2 {
    public static void main(String[] args) {

    }
}

class JZ58_2Solution{
    public String reverseLeftWords(String s, int n) {
        if(s == null || s.length()<n)return s;
        return s.substring(n) + s.substring(0,n);
    }
}