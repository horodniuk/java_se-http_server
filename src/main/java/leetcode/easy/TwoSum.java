package leetcode.easy;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
      int [] nums = {2,5,5,11};
      int target = 10;
      int[] solution = twoSum( nums, target);
      System.out.println(Arrays.toString(solution));
    }

    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
