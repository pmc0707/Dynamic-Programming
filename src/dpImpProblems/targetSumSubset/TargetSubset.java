package dpImpProblems.targetSumSubset;

public class TargetSubset {
    public static boolean targetSumSubset(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][target+1];
        //
        for (int i = 0; i < n + 1; i++) {
            //i - items
            //j - target sum
            dp[i][0] = true;

        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target+1; j++) {
                int v = nums[i-1];
                //include
                if(v <= j && dp[i - 1][j - v]) {
                    dp[i][j] = true;
                }//exclude
                else if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][target];
    }
    public static void main(String[] args) {
        int [] numbers = {4,2,7,1,3};
        int targetSum = 20;
        System.out.println(targetSumSubset(numbers, targetSum));
    }
}
