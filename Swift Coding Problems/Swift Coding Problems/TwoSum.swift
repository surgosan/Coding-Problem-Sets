//
//  TwoSum.swift
//
//
//  Created by Sergio Sanchez-Alvares on 6/6/24.
//

/*
  Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
  You may assume that each input would have exactly one solution, and you may not use the same element twice.
  You can return the answer in any order.
*/

//------------------------------------------------ BRUTE FORCE (n^2) ------------------------------------------------
func twoSumBruteMethod(_ nums: [Int], _ target: Int) -> [Int] {
    let n = nums.count // Initialize n as the numbers array length
    
    for i in 0 ..< n { // Iterate over array
        for j in i+1 ..< n { // Set another iteration starting at 1
            if nums[i] + nums[j] == target { // If a match, return it
                return [i, j]
            }
        }
    }
    return [] // Otherwise return en empty array
}

//---------------------------------------------- DICTIONARY METHOD (n) ----------------------------------------------
func twoSumDictionaryMethod(_ nums: [Int], _ target: Int) -> [Int] {
    var dict = [Int: Int]() // Create an empty dictionary
    
    for(index, value) in nums.enumerated() { // Iterate over the enumerated array
        if let addent = dict[value] { // If they add up to the target
            return [addent, index] // Return the answer
        } else {
            dict[target - value] = index // Else, set a new index to compare to
        }
    }
    return [] // Or return nothing
}
