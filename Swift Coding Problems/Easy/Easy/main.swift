//
//  main.swift
//  Swift Coding Problems
//
//  Created by Sergio Sanchez-Alvares on 6/6/24.
//

import Foundation

//-------------------------------------------------- TWO SUM ---------------------------------------------------
let twoSumNums = [2,7,11,15]
let twoSumTarget = 9
let twoSumNumsTwo = [3,2,4]
let twoSumTargetTwo = 6
let twoSumNumsThree = [3,3]
let twoSumTargetThree = 6

let twoSumBruteOne = twoSumBruteMethod(twoSumNums, twoSumTarget)
let twoSumBruteTwo = twoSumBruteMethod(twoSumNumsTwo, twoSumTargetTwo)
let twoSumBruteThree = twoSumBruteMethod(twoSumNumsThree, twoSumTargetThree)
print(String(format: "Two Sum Brute Force 1 [2,7,11,15]:  [%d, %d]", twoSumBruteOne[0], twoSumBruteOne[1]))
print(String(format: "Two Sum Brute Force 2 [3,2,4]:  [%d, %d]", twoSumBruteTwo[0], twoSumBruteTwo[1]))
print(String(format: "Two Sum Brute Force 3 [3,3]:  [%d, %d]\n\n", twoSumBruteThree[0], twoSumBruteThree[1]))

let twoSumDictOne = twoSumDictionaryMethod(twoSumNums, twoSumTarget)
let twoSumDictTwo = twoSumDictionaryMethod(twoSumNumsTwo, twoSumTargetTwo)
let twoSumDictThree = twoSumDictionaryMethod(twoSumNumsThree, twoSumTargetThree)
print(String(format: "Two Sum Dictionary Method 1 [2,7,11,15]:  [%d, %d]", twoSumDictOne[0], twoSumDictOne[1]))
print(String(format: "Two Sum Dictionary Method 2 [3,2,4]:  [%d, %d]", twoSumDictTwo[0], twoSumDictTwo[1]))
print(String(format: "Two Sum Dictionary Method 3 [3,3]:  [%d, %d]", twoSumDictThree[0], twoSumDictThree[1]))

