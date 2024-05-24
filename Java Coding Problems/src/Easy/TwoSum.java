package Easy;
import java.util.Map;
import java.util.HashMap;

/*
  Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
  You may assume that each input would have exactly one solution, and you may not use the same element twice.
  You can return the answer in any order.
*/

public class TwoSum {
//----------------------------------------------------- BRUTE FORCE -----------------------------------------------------
    // Time Complexity: O(n^2)
    public static int[] bruteForceMethod(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {      // Iterate over the list
             for(int j = 0; j < nums.length; j++) { // Per Each number, compare to every other number
                 if(i == j) {                       // Skip if they are on the same number
                     continue;
                 }
                 if(nums[i] + nums[j] == target) {  // Check if the sum equals the target
                     return new int[] { i, j };     // Create a new integer array and return
                 }
             }
         }
        // If no answer found, return null
        return null;
    }

//------------------------------------------------------ HASH MAP ------------------------------------------------------
    // Time Complexity: O(n)
    public static int[] hashMapMethod(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }

//----------------------------------------------------- MAIN METHOD -----------------------------------------------------
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] bruteResult = bruteForceMethod(nums, target);
        int[] hashResult = hashMapMethod(nums, target);

        System.out.printf("Brute Force Method: [%d, %d]\n", bruteResult[0], bruteResult[1]);
        System.out.printf("Hash Map Method: [%d, %d]\n", hashResult[0], hashResult[1]);
    }
}
