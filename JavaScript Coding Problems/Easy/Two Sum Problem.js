/*
  Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
  You may assume that each input would have exactly one solution, and you may not use the same element twice.
  You can return the answer in any order.
*/


//---------------------------------------------------- BRUTE FORCE ----------------------------------------------------
function bruteForceMethod(nums, target) {
    for(let i = 0; i < nums.length; i++) {      // Iterate over each num
        for(let j = 0; j < nums.length; j++) { // Iterate each time every num
            if(i === j) {                               // If the indices are the same, skip it
                continue;
            }
            if(nums[i] + nums[j] === target) {// If the sum equals the target, return it
                return [i, j];
            }
        }
    }
    return null; // Return null if no answer found
}
//------------------------------------------------------- HASHMAP -------------------------------------------------------
function hashMapMethod(nums, target) {
    const map = new Map();                          // Create new Map
    for(let i = 0; i < nums.length; i++) {          // Iterate over nums
        const complement = target - nums[i];    // Create the complement number
        if(map.has(complement)) {                   // Check if the complement already exists
            return [map.get(complement), i];       // If it does, return it
        }
        map.set(nums[i], i);                            // On each iterate, add the current number and it's index
    }
    return null; // Return null if no answer found
}
//---------------------------------------------------- MAIN METHOD ----------------------------------------------------
const nums = [2,7,11,15];
const target = 9;

const bruteResult = bruteForceMethod(nums, target);
const hashResult = hashMapMethod(nums, target);

console.log(`Brute Result: ${bruteResult}. Time Complexity = O(n^2)`);
console.log(`Hash Result: ${hashResult}. Time Complexity = O(n)`);