package hackerrank;

/**
 * https://www.hackerrank.com/challenges/max-array-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
 */
public class MaxArraySum {
    static int maxSubsetSum(int[] arr) {
        int[] dp = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(i==0){
                dp[0] = arr[0]>0?arr[0]:0;
            }else if(i==1){
                dp[i] = dp[0]>=arr[1]?dp[0]:arr[1];
            }else{
                int a = dp[i-2] + arr[i];
                int b = dp[i-1];
                dp[i] = a>b?a:b;
            }
        }
        return dp[arr.length-1];
    }
}
