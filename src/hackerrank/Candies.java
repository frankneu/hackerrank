package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/candies/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
 * 除动态规划外，还有双向搜索这种思路
 * https://blog.csdn.net/u010885899/article/details/50254171
 */
public class Candies {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        int[] dp1 = new int[n];
        dp1[0] = 1;
        for(int i=1;i<n;i++){
            if(arr[i] > arr[i-1]){
                dp1[i] = dp1[i-1] + 1;
            }else{
                dp1[i] = 1;
            }
        }
        int[] dp2 = new int[n];
        dp2[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            if(arr[i] > arr[i+1]){
                dp2[i] = dp2[i+1] + 1;
            }else{
                dp2[i] = 1;
            }
        }
        long ans = 0;
        for(int i=0;i<n;i++){
            ans += dp1[i]>dp2[i]?dp1[i]:dp2[i];
        }
        return ans;
    }


    public static void main(String[] args){
        System.out.println(candies(3, new int[]{1, 2, 2}));
        System.out.println(candies(10, new int[]{9, 2, 3, 6, 5, 4, 3, 2, 2, 2}));
    }
}
