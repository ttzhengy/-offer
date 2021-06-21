/*
约瑟夫环
 */

/*
数学解
当有n,m时，有算式f(n)=[f(n-1)+m]%n
且f(1)=0，可迭代求解
 */
public class JZ62 {
}

class JZ62Solution {
    public int lastRemaining(int n, int m) {
        int x = 0;
        for(int i=2;i<=n;i++){
            x = (x + m) % i;
        }
        return x;
    }
}
