/*
  Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
  You may assume that each input would have exactly one solution, and you may not use the same element twice.
  You can return the answer in any order.
*/


//---------------------------------------------------- BRUTE FORCE ----------------------------------------------------
function bruteForceMethod(nums, target) {
    for(let i = 0; i < nums.length; i++) {
        for(let j = 0; j < nums.length; j++) {
            if(i === j) {
                continue;
            }
            if(nums[i] + nums[j] === target) {
                return [i, j];
            }
        }
    }
    return null;
}
//------------------------------------------------------- HASHMAP -------------------------------------------------------
function hashMapMethod(nums, target) {
    const map = new Map();
    for(let i = 0; i < nums.length; i++) {
        const complement = target - nums[i];
        if(map.has(complement)) {
            return [map.get(complement), i];
        }
        map.set(nums[i], i);
    }
    return null;
}
//---------------------------------------------------- MAIN METHOD ----------------------------------------------------
const nums = [2,7,11,15];
const target = 9;

const bruteResult = bruteForceMethod(nums, target);
const hashResult = hashMapMethod(nums, target);

console.log(`Brute Result: ${bruteResult}. Time Complexity = O(n^2)`);
console.log(`Hash Result: ${hashResult}. Time Complexity = O(n)`);