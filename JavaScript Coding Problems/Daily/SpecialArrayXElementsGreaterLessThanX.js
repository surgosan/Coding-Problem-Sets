/*
    Challenge 1608. Special Array With X Elements Greater Than or Equal X
    - You are given an array nums of non-negative integers.
    - nums is considered special if there exists a number x such that there are exactly x numbers in nums that are greater than or equal to x.
    - Notice that x does not have to be an element in nums.
    - Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is unique.
*/

//------------------------------------------------------------------------ EXAMPLE (NOT 100% CORRECT) ------------------------------------------------------------------------
function specialArray(nums) {
    nums.sort((a, b) => a - b); // Sort array
    let previousMatch = -1; // Initialize previousMatch to -1.

    for(let i = 0; i < nums.length; i++) { // Iterate array
        let bound = nums.length - i; // Set bound to arrays length - current index
        if (nums[i] >= bound && previousMatch <= bound) { // If current number is greater or equal to the previousMatch and if previousMatch is less than or equal to the bound
            return bound;
        }
        previousMatch = nums[i]; // Set previousMatch as current item
    }
    return -1;
}

function frequencyMethod(nums) {
    // Keep an array for frequency. Make it one bigger to include numbers larger than the array itself.
    let frequency = new Array(nums.length + 1).fill(0);
    // Compare the length and the current number. Choose the smaller one. Go to frequency[smallerNumber] and add 1
    // Numbers larger than the array length will add a point to the last element of frequency
    for(let i = 0; i < nums.length; i++) {
        frequency[Math.min(nums.length, nums[i])]++;
    }
    let atleastNum = 0; // Initialize the number that may be greater than or equal to
    for(let i = nums.length; i >= 1; i--) {
        atleastNum += frequency[i]; // Add the number from the frequency array
        if(i === atleastNum) { // If the current index == the desired number
            return i;
        }
    }
    return -1;
}

function winnerFunction(nums) {
    let high = nums.length;
    let low = 0;

    while ( low <= high ){
        let mid = Math.floor(( high + low )/ 2);
        let counter = 0;
        for ( let i = 0; i < nums.length; i++ ){
            if ( nums[i] >= mid ) counter++;
        }
        if ( counter === mid ) {
            return mid;
        } else if ( counter > mid ) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return -1;
}

//--------------------------------------------------------------------------------- MAIN METHODS ---------------------------------------------------------------------------------

const numsOne = [3,5]; //2
const numsTwo = [0,0]; //-1
const numsThree = [0,4,3,0,4];  // 3
const numsFour = [15,25,30,25];
const numsFive = [1,2,3,6,10];

console.log("First Attempt [3,5]: " + specialArray(numsOne));
console.log("First Attempt [0,0]: " + specialArray(numsTwo));
console.log("First Attempt [0,4,3,0,4]: " + specialArray(numsThree));
console.log("First Attempt [15,25,30,25]: " + specialArray(numsFour));
console.log("First Attempt [1,2,3,6,10]: " + specialArray(numsFive));

console.log("\n----------------------------------------------------------------------------\n");

console.log("Frequency Method [0,0]: " + frequencyMethod(numsOne));
console.log("Frequency Method [0,0]: " + frequencyMethod(numsTwo));
console.log("Frequency Method [0,4,3,0,4]: " + frequencyMethod(numsThree));
console.log("Frequency Method [15,25,30,25]: " + frequencyMethod(numsFour));
console.log("Frequency Method [1,2,3,6,10]: " + frequencyMethod(numsFive));

console.log("\n----------------------------------------------------------------------------\n");

console.log("\n----------------------------------------------------------------------------\n");

console.log("Winner Function [0,0]: " + winnerFunction(numsOne));
console.log("Winner Function [0,0]: " + winnerFunction(numsTwo));
console.log("Winner Function [0,4,3,0,4]: " + winnerFunction(numsThree));
console.log("Winner Function [15,25,30,25]: " + winnerFunction(numsFour));
console.log("Winner Function [1,2,3,6,10]: " + winnerFunction(numsFive));