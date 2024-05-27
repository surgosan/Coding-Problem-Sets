package Daily;

import java.util.Arrays;

/*
    Challenge 1608. Special Array With X Elements Greater Than or Equal X
    - You are given an array nums of non-negative integers.
    - nums is considered special if there exists a number x such that there are exactly x numbers in nums that are greater than or equal to x.
    - Notice that x does not have to be an element in nums.
    - Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is unique.
*/

//------------------------------------------------------------------------ EXAMPLE (NOT 100% CORRECT) ------------------------------------------------------------------------
public class SpecialArrayXElementsGreaterLessThanX {
    // Create two pointers. One with the for loop and another one using array.length - currentIndex

    public static int specialArray(int[] nums) {
        Arrays.sort(nums); // Sort array
        int previousMatch = -1; // Initialize previousMatch to -1.
        for(int i = 0; i < nums.length; i++) { // Iterate array
            int bound = nums.length - i; // Set bound to arrays length - current index
            if (nums[i] >= bound && previousMatch <= bound) { // If current number is greater or equal to the previousMatch and if previousMatch is less than or equal to the bound
                return bound;
            }
            previousMatch = nums[i]; // Set previousMatch as current item
        }
        return -1;
    }

//------------------------------------------------------------------------- FREQUENCY METHOD O(n) -------------------------------------------------------------------------
    public static int frequencyMethod(int[] nums) {
        // Keep an array for frequency. Make it one bigger to include numbers larger than the array itself.
        int[] frequency = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            // Compare the length and the current number. Choose the smaller one. Go to frequency[smallerNumber] and add 1
            // Numbers larger than the array length will add a point to the last element of frequency
            frequency[Math.min(nums.length, nums[i])]++;
        }
        int atleastNum = 0; // Initialize the number that may be greater than or equal to
        for (int i = nums.length; i >= 1; i--) {
            atleastNum += frequency[i]; // Add the number from the frequency array
            if (i == atleastNum) { // If the current index == the desired number
                return i;
            }
        }
        return -1;
    }

//----------------------------------------------------------------------- MAIN METHOD -----------------------------------------------------------------------
    public static void main(String[] args) {
        int[] numsOne = {3,5}; //2
        int[] numsTwo = {0,0}; //-1
        int[] numsThree = {0,4,3,0,4};  // 3
        int[] numsFour = {15,25,30,25};
        int[] numsFive = {1,2,3,6,10};

        System.out.println("First Attempt [3,5]: " + specialArray(numsOne));
        System.out.println("First Attempt [0,0]: " + specialArray(numsTwo));
        System.out.println("First Attempt [0,4,3,0,4]: " + specialArray(numsThree));
        System.out.println("First Attempt [15,25,30,25]: " + specialArray(numsFour));
        System.out.println("First Attempt [1,2,3,6,10]: " + specialArray(numsFive));

        System.out.println("\n----------------------------------------------------------------------------\n");

        System.out.println("Frequency Method [0,0]: " + frequencyMethod(numsOne));
        System.out.println("Frequency Method [0,0]: " + frequencyMethod(numsTwo));
        System.out.println("Frequency Method [0,4,3,0,4]: " + frequencyMethod(numsThree));
        System.out.println("Frequency Method [15,25,30,25]: " + frequencyMethod(numsFour));
        System.out.println("Frequency Method [1,2,3,6,10]: " + frequencyMethod(numsFive));
    }
}
