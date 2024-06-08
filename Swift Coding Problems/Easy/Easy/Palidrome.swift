//
//  Palidrome.swift
//  Swift Coding Problems
//
//  Created by Sergio Sanchez-Alvares on 6/6/24.
//

// --------------------------------------------- BRUTE FORCE O(n) ---------------------------------------------
func palidromeBruteForce(_ num: Int) -> Bool {
    var num: Int = num // Create another variable called num to make it mutable
    // Negative numbers are not palidromes
    if(num < 0) { return false }
    
    // Store the original number
    let originalNum: Int = num
    var reversedNum: Int = 0
    
    // Reverse the integer
    while(num != 0) {
        let digit = num % 10 // Borrow the last digit
        reversedNum = reversedNum*10 + digit // Add a 0 to the end (*10) and add the digit we removed to that slot
        num /= 10 // Divide num by 10 to remove the last digit
    }
    
    // Check if the reversed number is equal to the original number
    return originalNum == reversedNum
}

func palidromeSemiReverse(_ num: Int) -> Bool {
    var num: Int = num // Create another variable called num to make it mutable
    // num cannot be negative | num cannot end in 0, but does not count if num is 0 (It would be a palidrome them (difference between 10 and 0))
    if(num < 0 || (num % 10 == 0 && num != 0)) { return false }
    
    // Initialize reverted number
    var revertedNumber = 0
    while(num > revertedNumber) {
        /*  1. Multiply by 10 to gain a 0 (121 * 10 = 1210)
                1a. Done on reverted number to prepare to add a new digit in that empty slot
            2. mod(%) original number by 10 (121 % 10 = 1)
                2a. This is done to get the last digit of the original number
            3. Divide(/) original number by 10
                3a. This is done to move the decimal to the left 1 digit. (121 / 10 = 12)
                3b. Since the type is integer, it will round down to nearest whole number
         */
        revertedNumber = revertedNumber * 10 + (num % 10)
        num /= 10
    }
    /*
        This method does not reverse the complete number.
        EX: In 12321, at the end of the loop we get x=12 and revertedNum=123 because x is now less than the reverted num
            EXa. This only happens if there are an odd number of digits, otherwise, x and revertedNum will equal each-other
        This is fine. Simply divide(/) by 10 to remove the last digit.
        Now the comparison is 12 == 12. The middle digit does not matter since the middle digit equals itself

        EVEN DIGITS EXAMPLE
            1221 -> x=12  revertedNum=12
            x == 12 ✓
        ODD DIGITS EXAMPLE
            12321 -> x = 12  revertedNum == 123
            revertedNum / 10 = 12
            x == revertedNum
    */
    
    return num == revertedNumber || num == revertedNumber / 10
}
