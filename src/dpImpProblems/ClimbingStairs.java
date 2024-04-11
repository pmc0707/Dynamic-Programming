package dpImpProblems;

public class ClimbingStairs {
    public static int countWays(int number) {
        if(number == 0) return 1;
        if(number<0) return 0;

        return countWays(number-1) + countWays(number-2);
    }
    public static void main(String[] args) {
        int number = 5;
        System.out.println(countWays(number));
    }
}
