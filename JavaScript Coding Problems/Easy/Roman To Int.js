/* Given a roman numeral, convert it to an integer. */

//-------------------------------------------------------- SETUP --------------------------------------------------------
const romanMap = {
    "I": 1,
    "V": 5,
    "X": 10,
    "L": 50,
    "C": 100,
    "D,": 500,
    "M": 1000
};

//----------------------------------------------------- BRUTE FORCE -----------------------------------------------------
function bruteForce(s) {
    let output = 0; // Initialize output to 0
    const reversedString = s.split("").reverse().join(""); // Reverse the string

    for(let i = 0; i < reversedString.length; i++) {
        // If we are currently on the last index, simply add its value
        if(i === reversedString.length - 1) {
            let val = romanMap[reversedString[i]]; // Get value
            output += val; // Add the value
            break; // End the loop
        }
        // Check if the next number is less than the current index. Signals numbers such as IV
        if(romanMap[reversedString[i]] > romanMap[reversedString[i+1]]) {
            let val = Math.abs(romanMap[reversedString[i]] - romanMap[reversedString[i+1]]); // Current(V) - next (I)
            output += val;  // Add the value
            i++;    // Skip the next number
            continue;   // Avoid running the code below
        }
        // Get the value of the current index and add its value to output
        let val = romanMap[reversedString[i]];
        output += val;
    }
    return output;
}

//----------------------------------------------------- WHILE METHOD -----------------------------------------------------
function whileMethod(s) {
    let lastSymbol = s[s.length - 1]; // Initialize last symbol
    let lastValue = romanMap[lastSymbol]; // Initialize previous value
    let total = lastValue; // Set total to last value

    for (let i = s.length - 2; i >= 0; i--) { // Iterate over string backwards. Skip the last symbol; We already covered it.
        let currentSymbol = s[i];   // Set current symbol
        let currentValue = romanMap[currentSymbol]; // Get value of current symbol
        if (currentValue < lastValue) { // If the current value is less than the previous (I < V)
            total -= currentValue; // Subtract that value. We already added 5(V) so subtract 1(I) to get 4(IV)
        } else {
            total += currentValue; // Add the current value
        }
        lastValue = currentValue; // Set the previous value as the current value
    }
    return total;
}

//----------------------------------------------------- SWITCH METHOD -----------------------------------------------------
function switchMethod(s) {
    let output = 0; // Initialize output, previous, and current
    let prev = 0;
    let curr;

    for (let i = s.length - 1; i >= 0; i--) {
        curr = 0;
        switch (s[i]) {  // Use switch to check the values with charAt instead of substring
            case 'I':
                curr = 1;
                break;
            case 'V':
                curr = 5;
                break;
            case 'X':
                curr = 10;
                break;
            case 'L':
                curr = 50;
                break;
            case 'C':
                curr = 100;
                break;
            case 'D':
                curr = 500;
                break;
            case 'M':
                curr = 1000;
                break;
        }
        if (curr < prev) { // If current value is less than the previous. Checking string in reverse order so IV looks like VI
            output -= curr; // Previous was 5, so - current (1) to get 4
        } else {
            output += curr;
        }
        prev = curr; // Set previous as current
    }
    return output;
}

//--------------------------------------- BRUTE FORCE ---------------------------------------
console.log("Brute Force Method(III): " + bruteForce("III"));
console.log("Brute Force Method(LVIII): " + bruteForce("LVIII"));
console.log("Brute Force Method(MCMXCIV): " + bruteForce("MCMXCIV"));

console.log("\n-------------------------------------------------------------\n");

console.log("While Loop Method(III): " + whileMethod("III"));
console.log("While Loop Method(LVIII): " + whileMethod("LVIII"));
console.log("While Loop Method(MCMXCIV): " + whileMethod("MCMXCIV"));

console.log("\n-------------------------------------------------------------\n");

console.log("Switch Method(III): " + switchMethod("III"));
console.log("Switch Method(LVIII): " + switchMethod("LVIII"));
console.log("Switch Method(MCMXCIV): " + switchMethod("MCMXCIV"));
