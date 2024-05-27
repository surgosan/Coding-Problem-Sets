package Easy;

// Write a function to find the longest common prefix string amongst an array of strings.

public class LongestCommonPrefix {
//---------------------------------------------------- FIRST ATTEMPT ---------------------------------------------------- O(n^n) Bad
    public static String firstAttempt(String[] strs) {
        // If strs only has one word
        if (strs.length == 1) { return strs[0]; }

        int charIndex = 0; // Initialize character index, current char, while condition, and output string
        char currentChar;
        boolean prefix = true;
        String output = "";

        while(prefix) { // While the prefix still matches
            if (charIndex == strs[0].length()) { break; } // If the end of the first string has ended
            currentChar = strs[0].charAt(charIndex); // Update the char value on each pass
            for(int i = 1; i < strs.length; i++) { // STRING START STRING
                // If the current string has ended or if the chars don't match
                if (charIndex == strs[i].length() || strs[i].charAt(charIndex) != currentChar) {
                    prefix = false; // Update while condition
                    break; // Break the for loop
                }
            }
            if(prefix) { // If the condition has not changed
                output += strs[0].charAt(charIndex);
                charIndex++;
            }
        }
        if(output.isEmpty()) { output = "Null"; }
        return output;
    }

//--------------------------------------------------- HORIZONTAL SCAN --------------------------------------------------- O(n)
    public static String horizontalScan(String[] strs) {
        if (strs.length == 0) return "Null"; // Return nothing if the array is empty
        if(strs.length == 1) return strs[0]; // Return the first item if it is the only item in the array
        String prefix = strs[0]; // Set the prefix as the first item
        for (int i = 1; i < strs.length; i++) while ( // Iterate over the strings
                strs[i].indexOf(prefix) != 0
            // If the prefix begins at the beginning of the current string. (We have cut down prefix enough to make them equal)
            // The index of "flow" from "flower" begins at index 0 in the string "flow". So we are done and move to the next string
        ) {
            prefix = prefix.substring(0, prefix.length() - 1); // Remove the last character from the prefix
            if (prefix.isEmpty()) return "Null"; // Return if we don't have anything left
        }
        return prefix;
    }


//----------------------------------------------------- MAIN METHOD -----------------------------------------------------
    public static void main(String[] args) {
        String[] stringOne = {"flower","flow","flight"};
        String[] stringTwo = {"dog","racecar","car"};
        String[] stringThree = {"STRING", "STRING", "STRING"};


        long bruteStart = System.nanoTime(); // Start timer for brute force
        System.out.println("First attempt [flower, flow, flight] --- " + firstAttempt(stringOne));
        System.out.println("First attempt --- " + firstAttempt(stringTwo));
        System.out.println("First attempt --- " + firstAttempt(stringThree));
        long bruteEnd = System.nanoTime(); // End Timer
        System.out.println("First Attempt Time: " + (bruteEnd - bruteStart) / 1000 + " microseconds");

        System.out.println("\n----------------------------------------------------------------------------------\n");

        long horizontalStart = System.nanoTime(); // Start timer for brute force
        System.out.println("Horizontal Scan [flower, flow, flight] --- " + horizontalScan(stringOne));
        System.out.println("Horizontal Scan: [dog, racecar, car] --- " + horizontalScan(stringTwo));
        System.out.println("Horizontal Scan: [STRING, STRING, STRING] --- " + horizontalScan(stringThree));
        long horizontalEnd = System.nanoTime(); // End Timer
        System.out.println("Horizontal Scan Time: " + (horizontalEnd - horizontalStart) / 1000 + " microseconds");
    }
}

