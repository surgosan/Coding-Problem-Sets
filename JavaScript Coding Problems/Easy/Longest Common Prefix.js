//---------------------------------------------- FIRST ATTEMPT O(n^n) BAD ----------------------------------------------
function firstAttempt(strs) {
    // If strs only has one word
    if (strs.length === 1) { return strs[0]; }

    let charIndex = 0; // Initialize character index, current char, while condition, and output string
    let currentChar;
    let prefix = true;
    let output = "";

    while(prefix) { // While the prefix still matches
        if (charIndex === strs[0].length) { break; } // If the end of the first string has ended
        currentChar = strs[0].charAt(charIndex); // Update the char value on each pass
        for(let i = 1; i < strs.length; i++) { // STRING START STRING
            // If the current string has ended or if the chars don't match
            if (charIndex === strs[i].length || strs[i].charAt(charIndex) !== currentChar) {
                prefix = false; // Update while condition
                break; // Break the for loop
            }
        }
        if(prefix) { // If the condition has not changed
            output += strs[0].charAt(charIndex);
            charIndex++;
        }
    }
    if(output.length === 0) { output = "Null"; }
    return output;
}

//------------------------------------------------------ HORIZONTAL SCAN O(n) ------------------------------------------------------
function horizontalScan(strs) {
    if (strs.length === 0) return "Null"; // Return nothing if the array is empty
    if(strs.length === 1) return strs[0]; // Return the first item if it is the only item in the array
    let prefix = strs[0]; // Set the prefix as the first item
    for (let i = 1; i < strs.length; i++) while ( // Iterate over the strings
    strs[i].indexOf(prefix) !== 0
        // If the prefix begins at the beginning of the current string. (We have cut down prefix enough to make them equal)
        // The index of "flow" from "flower" begins at index 0 in the string "flow". So we are done and move to the next string
        ) {
        prefix = prefix.substring(0, prefix.length - 1); // Remove the last character from the prefix
        if (prefix.length === 0) return "Null"; // Return if we don't have anything left
    }
    return prefix;
}


//----------------------------------------------------- MAIN METHODS -----------------------------------------------------
const stringOne = ["flower","flow","flight"];
const stringTwo = ["dog","racecar","car"];
const stringThree = ["STRING", "STRING", "STRING"];


console.log("First attempt [flower, flow, flight] --- " + firstAttempt(stringOne));
console.log("First attempt --- " + firstAttempt(stringTwo));
console.log("First attempt --- " + firstAttempt(stringThree));

console.log("\n----------------------------------------------------------------------------------\n");

console.log("Horizontal Scan [flower, flow, flight] --- " + horizontalScan(stringOne));
console.log("Horizontal Scan: [dog, racecar, car] --- " + horizontalScan(stringTwo));
console.log("Horizontal Scan: [STRING, STRING, STRING] --- " + horizontalScan(stringThree));
