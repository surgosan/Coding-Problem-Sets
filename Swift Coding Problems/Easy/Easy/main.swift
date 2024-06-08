//
//  main.swift
//  Swift Coding Problems
//
//  Created by Sergio Sanchez-Alvares on 6/6/24.
//

import Foundation

//-------------------------------------------------- TWO SUM ---------------------------------------------------
print("--------------------- Two Sum Problem ---------------------\n")
let twoSumNums: [Int] = [2,7,11,15]
let twoSumTarget: Int = 9
let twoSumNumsTwo: [Int] = [3,2,4]
let twoSumTargetTwo: Int = 6
let twoSumNumsThree: [Int] = [3,3]
let twoSumTargetThree: Int = 6          // Dummy Data

let twoSumBruteOne = twoSumBruteMethod(twoSumNums, twoSumTarget)
let twoSumBruteTwo = twoSumBruteMethod(twoSumNumsTwo, twoSumTargetTwo)
let twoSumBruteThree = twoSumBruteMethod(twoSumNumsThree, twoSumTargetThree)
print(String(format: "Two Sum Brute Force 1 [2,7,11,15]:  [%d, %d]", twoSumBruteOne[0], twoSumBruteOne[1]))
print(String(format: "Two Sum Brute Force 2 [3,2,4]:  [%d, %d]", twoSumBruteTwo[0], twoSumBruteTwo[1]))
print(String(format: "Two Sum Brute Force 3 [3,3]:  [%d, %d]\n", twoSumBruteThree[0], twoSumBruteThree[1]))

let twoSumDictOne = twoSumDictionaryMethod(twoSumNums, twoSumTarget)
let twoSumDictTwo = twoSumDictionaryMethod(twoSumNumsTwo, twoSumTargetTwo)
let twoSumDictThree = twoSumDictionaryMethod(twoSumNumsThree, twoSumTargetThree)
print(String(format: "Two Sum Dictionary Method 1 [2,7,11,15]:  [%d, %d]", twoSumDictOne[0], twoSumDictOne[1]))
print(String(format: "Two Sum Dictionary Method 2 [3,2,4]:  [%d, %d]", twoSumDictTwo[0], twoSumDictTwo[1]))
print(String(format: "Two Sum Dictionary Method 3 [3,3]:  [%d, %d]\n", twoSumDictThree[0], twoSumDictThree[1]))

//-------------------------------------------------- PALIDROME ---------------------------------------------------
print("--------------------- Palidrome Problem ---------------------\n")
let palidromeNum1: Int = 121;
let palidromeNum2: Int = 122;
let palidromeNum3: Int = 12321;
let palidromeNum4: Int = 124321;        // Dummy Data

print("Palidrome Brute Force 1 (121): \(palidromeBruteForce(palidromeNum1))")
print("Palidrome Brute Force 2 (122): \(palidromeBruteForce(palidromeNum2))")
print("Palidrome Brute Force 3 (12321): \(palidromeBruteForce(palidromeNum3))")
print("Palidrome Brute Force 4 (124321): \(palidromeBruteForce(palidromeNum4))\n")

print("Palidrome Semi Reversal 1 (121): \(palidromeSemiReverse(palidromeNum1))")
print("Palidrome Semi Reversal 2 (122): \(palidromeSemiReverse(palidromeNum2))")
print("Palidrome Semi Reversal 3 (12321): \(palidromeSemiReverse(palidromeNum3))")
print("Palidrome Semi Reversal 4 (124321): \(palidromeSemiReverse(palidromeNum4))\n")
