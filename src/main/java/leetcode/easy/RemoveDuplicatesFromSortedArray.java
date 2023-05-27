package leetcode.easy;

import lecture7_data_structure_collection.lecture.HashSet;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
      int [] nums = {0,0,1,1,1,2,2,3,3,4};
      int [] nums2 = {1,1,2};
      int solution = removeDuplicates( nums);
      System.out.println(Arrays.toString(nums));
      System.out.println((solution));
    }

    public static int removeDuplicates(int[] nums) {
        int insertIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[insertIndex++] = nums[i];
            }
        }
        return insertIndex;
    }
}
