/*
扑克牌中的顺子
从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的
2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为0，可以看成任意数字。A不能视为 14。
 */

import java.util.HashSet;
import java.util.Set;

/*
当数组中的max-min>=5时，就不可能组成顺子，因此遍历数组得到max和min
再使用set判断数组元素是否重复（不计算大小王），重复也不可能组成顺子
 */
public class JZ61 {
}

class JZ61Solution {
    public boolean isStraight(int[] nums) {
        int min = 0;
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            if(i==0)continue;
            if(min == 0 || i < min)min = i;
            if(i > max)max = i;
            if(!set.add(i))return false;
        }

        return max - min < 5;
    }
}
