package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */

public class Question238ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int total = 1;
        for(int i=0;i<nums.length;i++){
            result[i] = 1;
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    result[i] *= nums[j];
                }
            }
        }
        return result;
    }
}
