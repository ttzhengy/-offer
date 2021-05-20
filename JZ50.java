import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/*
第一个只出现一次的字符
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class JZ50 {
}

class JZ50Solution {
    public char firstUniqChar(String s) {
        // LinkedHashMap有序哈希表
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)){
                map.put(c,2);
            }else {
                map.put(c,1);
            }
        }
        for (char c : chars) {
            if (map.get(c)==1){
                return c;
            }
        }
        return ' ';
    }
}
