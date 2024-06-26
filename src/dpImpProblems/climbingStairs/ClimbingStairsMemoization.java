package dpImpProblems.climbingStairs;

import java.util.Arrays;

public class ClimbingStairsMemoization {
    //0(n)
    public static int countWays(int number,int[] ways) {
        if(number == 0) return 1;
        if(number<0) return 0;
        if(ways[number]!=-1) return ways[number];

        ways[number] = countWays(number-1,ways) + countWays(number-2,ways);
        return ways[number];
    }
    public static int countWaysTabulation(int number) {
        int[] dp = new int[number+1];
        dp[0] = 1;
        //tabulation loop
        for (int i = 1; i<=number; i++) {
            if(i==1) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[number];
    }
    public static void main(String[] args) {
        int number = 5;
        int[] ways = new int[number+1];
        Arrays.fill(ways, -1);
        System.out.println(countWays(number,ways));
        System.out.println(countWaysTabulation(number));
    }
}

