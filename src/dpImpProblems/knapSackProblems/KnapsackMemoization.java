package dpImpProblems.knapSackProblems;

public class KnapsackMemoization {
    // Time complexity : 0(number*capacity)
    public static int knapsack(int[] value, int[] weight, int capacity, int number,int [][]dp){
        if(capacity == 0 || number == 0){
            return 0;
        }
        if(dp[number][capacity] != -1){
            return dp[number][capacity];
        }
        if(weight[number-1] <= capacity) {
            //include
            int ans1=value[number-1]+knapsack(value, weight,
                    capacity - weight[number-1], number - 1,dp);
            //exclude
            int ans2 = knapsack(value, weight, capacity, number - 1,dp);
            dp[number][capacity] = Math.max(ans1, ans2);
            return dp[number][capacity];
        } else {
            //not valid
            dp[number][capacity] = knapsack(value, weight, capacity, number - 1,dp);
            return dp[number][capacity];
        }
    }
    public static void main(String[] args) {
        int []value ={15,14,10,45,30};
        int []weight = {2,5,1,3,4};
        int capacity = 7;
        int [][] dp = new int[value.length+1][capacity+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsack(value, weight, capacity, value.length,dp));
    }
}
