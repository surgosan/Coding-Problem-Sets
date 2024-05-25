// NOTE THAT IN JAVASCRIPT, YOU MUST USE MATH.FLOOR TO KEEP NUMBERS AN INTEGER WHEN DIVIDING. TO PREVENT 121/10 = 12.1 AND INSTEAD GET 121/10 = 12


//--------------------------------------------------------------------------------------------- BRUTE FORCE ---------------------------------------------------------------------------------------------
function completeReverse(num) {
    // Cannot be negative
    if(num < 0) {return false;}

//     Store original number and initialize reversedNum
    let originalNum = num; // We are storing this to compare at the end. We will be changing num
    let reversedNum = 0;

//     Reverse the number
    while(num !== 0) {          // While num is not empty
        let digit = num % 10;   // Get last digit of original number
        reversedNum = reversedNum*10 + digit; // Multiply by 10 to make space for digit and append the digit
        num = Math.floor(num / 10); // Remove the last digit of the original number
    }

//     Check if the reversed number equals the original and return it
    return originalNum === reversedNum;
}

//--------------------------------------------------------------------------------------------- SEMI REVERSE ---------------------------------------------------------------------------------------------
function semiReverse(num) {
    // Number cannot be negative | Number cannot end in 0 but does not count if the number is 0 (It would be a palindrome then (difference between 10 and 0 )
    if(num < 0 || num % 10 === 0 && num !== 0) {
        return false;
    }

//     Initialize reverted number
    let revertedNumber = 0;
    while(num > revertedNumber) { // While x is larger than reverted number
        /*  1. Multiply by 10 to gain a 0 (121 * 10 = 1210)
                    1a. Done on reverted number to prepare to add a new digit in that empty slot
                2. mod(%) original number by 10 (121 % 10 = 1)
                    2a. This is done to get the last digit of the original number
                3. Divide(/) original number by 10
                    3a. This is done to move the decimal to the left 1 digit. (121 / 10 = 12)
                    3b. Since the type is integer, it will round down to nearest whole number
             */
        revertedNumber = Math.floor(revertedNumber * 10 + (num % 10));
        num = Math.floor(num / 10);
    }
    /*
            This method does not reverse the complete number.
            EX: In 12321, at the end of the loop we get num=12 and revertedNum=123 because num is now less than the reverted num
                EXa. This only happens if there are an odd number of digits, otherwise, num and revertedNum will equal each-other
            This is fine. Simply divide(/) by 10 to remove the last digit.
            Now the comparison is 12 == 12. The middle digit does not matter since the middle digit equals itself

            EVEN DIGITS EXAMPLE
                1221 -> num=12  revertedNum=12
                num == 12 ✓
            ODD DIGITS EXAMPLE
                12321 -> num = 12  revertedNum == 123
                revertedNum / 10 = 12
                num == revertedNum
        */
    return num === revertedNumber || num === Math.floor(revertedNumber / 10);
}

//---------------------------------------------------------------------------------------------- MAIN METHOD ----------------------------------------------------------------------------------------------

const num1 = 121;
const num2 = 122;
const num3 = 12321;
const num4 = 124321;

console.log("Complete Reverse (121): " + completeReverse(num1));
console.log("Complete Reverse (122): " + completeReverse(num2));
console.log("Complete Reverse (12321): " + completeReverse(num3));
console.log("Complete Reverse (124321): " + completeReverse(num4));

console.log("Semi Reverse (121): " + semiReverse(num1));
console.log("Semi Reverse (122): " + semiReverse(num2));
console.log("Semi Reverse (12321): " + semiReverse(num3));
console.log("Semi Reverse (124321): " + semiReverse(num4));
