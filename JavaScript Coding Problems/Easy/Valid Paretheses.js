//-------------------------------- STACK ------------------------------------------------------------
function isValid(s) {
    // Initialize stack using String s in a list form
    let str = s.split("");
    // Create stack for last open brackets
    let stack = [];

    // Iterate over str array
    for (let i = 0; i < str.length; i++) {
        switch (str[i]) { // If an opening character, add it's closing counterpart to the arraylist
            case "(":
                stack.push(")");
                break;
            case "{":
                stack.push("}");
                break;
            case "[":
                stack.push("]");
                break;
            case ")": // If a closing character, check if the stack is empty or if it doesn't = the current character
                if (stack.length === 0 || stack.pop() !== ")") {
                    return false;
                }
                break;
            case "}":
                if (stack.length === 0 || stack.pop() !== "}") {
                    return false;
                }
                break;
            case "]":
                if (stack.length === 0 || stack.pop() !== "]") {
                    return false;
                }
                break;
        }
    }
    // If there is still items in the stack, return false
    return stack.length === 0;
    // Nothing wrong. Return true
}

//----------------------------------------- FASTEST CHAR METHOD -----------------------------------------
function charMethod(s) {
    // Initialize char list of the string
    let openBrackets = {};
    let openCount = 0; // Count how many open characters

    // Iterate over s using charAt()
    for (let i = 0; i < s.length; i++) {
        let current = s.charAt(i); // Keep track of current character

        // If an opening character, add it to the array. Inform openCount of a new character
        if (current === '(' || current === '{' || current === '[') {
            openBrackets[openCount] = current;
            openCount++;
        } else {
            if (openCount === 0) { // Check if the array is empty
                return false;
            }

            // Take note of the last opened character
            let lastOpen = openBrackets[openCount - 1];
            // Check if they are a match
            if ((current === ')' && lastOpen === '(') ||
                (current === '}' && lastOpen === '{') ||
                (current === ']' && lastOpen === '[')) {
                openCount--;
            } else {
                return false;
            }
        }
    }

    // Check if the array is empty as a boolean
    return openCount === 0;
}


//------------------------------ MAIN METHOD ----------------------------------------------------------
    const sOne = "()";
    const sTwo = "()[]{}";
    const sThree = "(()";
    const sFour = "()({[[]]})";
    const sFive = "]";

    console.log(`Stack Method: (): ${isValid(sOne)}`);
    console.log(`Stack Method: ()[]{}: ${isValid(sTwo)}`);
    console.log(`Stack Method: ()): ${isValid(sThree)}`);
    console.log(`Stack Method: ()({[[]]}): ${isValid(sFour)}`);
console.log(`Char Method: ]: ${isValid(sFive)}`);


    console.log("\n-------------------------------------------------------------\n");

    console.log(`Char Method: (): ${charMethod(sOne)}`);
    console.log(`Char Method: ()[]{}: ${charMethod(sTwo)}`);
    console.log(`Char Method: ()): ${charMethod(sThree)}`);
    console.log(`Char Method: ()({[[]]}): ${charMethod(sFour)}`);
    console.log(`Char Method: ]: ${charMethod(sFive)}`);