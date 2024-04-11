package dpImpProblems.knapSackProblems;

public class knapsack0_1 {
    //with recursion
    public static int knapsack(int[] value, int[] weight, int capacity, int number){
        if(capacity == 0 || number == 0){
            return 0;
        }
        if(weight[number-1] <= capacity) {
            //include
            int ans1=value[number-1]+knapsack(value, weight,
                    capacity - weight[number-1], number - 1);
            //exclude
            int ans2 = knapsack(value, weight, capacity, number - 1);
            return Math.max(ans1, ans2);
        } else {
            //not valid
            return knapsack(value, weight, capacity, number - 1);
        }
    }
    public static void main(String[] args) {
        int []value ={15,14,10,45,30};
        int []weight = {2,5,1,3,4};
        int capacity = 7;
        System.out.println(knapsack(value, weight, capacity, value.length));
    }
}
