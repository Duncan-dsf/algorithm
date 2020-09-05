package dsf.algorithm.leetcode.offer;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/21 8:51
 */
public class P10_1 {

    public int f(int n) {
        if (arr[n] ==0 ){

            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            int res = f(n - 1) + f(n - 2);

            if(res>=100000000){
                res=res%100000000;
                return res;
            }
            arr[n] = res;
            return arr[n];
        }
        return arr[n];
    }
    int[] arr;
    public  int fib(int n){

        arr =new int[n+1];
        return f(n);

    }

    public static void main(String[] args) {

    }

}
