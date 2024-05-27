package Easy;

import java.util.HashMap;
import java.util.Map;

/* Given a roman numeral, convert it to an integer. */

public class RomanToInteger {
//----------------------------------------------------------------------- SETUP -----------------------------------------------------------------------
    // Hard Code roman values in a map
    static Map<String, Integer> romanMap = new HashMap<>(){{
        put("I", 1);
        put("V", 5);
        put("X", 10);
        put("L", 50);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
    }};

//-------------------------------------------------------------------- BRUTE FORCE --------------------------------------------------------------------
    // Very slow compared to other methods
    public static int bruteForce(String s) {
        int output = 0; // Initialize output to 0
        String reversed = new StringBuilder(s).reverse().toString();    // Reverse the string

        for(int i = 0; i < reversed.length(); i++) {
            // If we are currently on the last index, simply add its value
            if(i == reversed.length() - 1) {
                int val = romanMap.get(reversed.substring(i, i+1)); // Get value
                output += val;  // Add the value
                break;  // End the loop
            }
            // Check if the next number is less than the current index. Signals numbers such as IV
            if(romanMap.get(reversed.substring(i, i+1)) > romanMap.get(reversed.substring(i+1, i+2))) {
                int val = Math.abs(romanMap.get(reversed.substring(i, i+1)) - romanMap.get(reversed.substring(i+1, i+2))); // Current(V) - next (I)
                output += val;  // Add the value
                i++;    // Skip the next number
                continue;   // Avoid running the code below
            }
            // Get the value of the current index and add its value to output
            int val = romanMap.get(reversed.substring(i, i+1));
            output += val;
        }
        return output;
    }

//-------------------------------------------------------------------- WHILE LOOP --------------------------------------------------------------------
    public static int whileMethod(String s) {
        int sum = 0; // Initialize sum and i(index)
        int i = 0;
        while (i < s.length()) {
            String currentSymbol = s.substring(i, i + 1); // Check this character
            int currentValue = romanMap.get(currentSymbol); // Find its value
            int nextValue = 0; // Initialize
            if (i + 1 < s.length()) { // If not on the last index
                String nextSymbol = s.substring(i + 1, i + 2); // Get the next character and assign it to nextValue
                nextValue = romanMap.get(nextSymbol);
            }

            // If denoting a number like IV
            if (currentValue < nextValue) {
                sum += (nextValue - currentValue);
                i += 2;
            } else { // Else add this one and move on
                sum += currentValue;
                i += 1;
            }
        }
        return sum;
    }

//----------------------------------------------------------------- SWITCH STATEMENT -----------------------------------------------------------------
    public static int switchMethod(String s) {
        int output = 0; // Initialize output, previous, and current
        int prev = 0;
        int curr;

        for (int i = s.length() - 1; i >= 0; i--) {
            curr = 0;
            switch (s.charAt(i)) {  // Use switch to check the values with charAt instead of substring
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

    public static void main(String[] args) {
//--------------------------------------- BRUTE FORCE ---------------------------------------
        long bruteStart = System.nanoTime(); // Start timer for brute force
        System.out.println("Brute Force Method(III): " + bruteForce("III"));
        System.out.println("Brute Force Method(LVIII): " + bruteForce("LVIII"));

        System.out.print("Brute Force Method(MCMXCIV): " + bruteForce("MCMXCIV"));
        long bruteEnd = System.nanoTime(); // End Timer
        System.out.println(" | Time taken: " + (bruteEnd - bruteStart) / 1000 + " Micro Seconds");

        System.out.println("\n-------------------------------------------------------------\n");
//--------------------------------------- WHILE LOOP ---------------------------------------
        long whileStart = System.nanoTime(); // Start timer for brute force
        System.out.println("While Method(III): " + whileMethod("III"));
        System.out.println("While Method(LVIII): " + whileMethod("LVIII"));

        System.out.print("While Method(MCMXCIV): " + whileMethod("MCMXCIV"));
        long whileEnd = System.nanoTime(); // End Timer
        System.out.println(" | Time taken: " + (whileEnd - whileStart) / 1000 + " Micro Seconds");

        System.out.println("\n-------------------------------------------------------------\n");
//-------------------------------------- SWITCH METHOD --------------------------------------
        long switchStart = System.nanoTime(); // Start timer for brute force
        System.out.println("Switch Method(III): " + switchMethod("III"));
        System.out.println("Switch Method(LVIII): " + switchMethod("LVIII"));

        System.out.print("Switch Method(MCMXCIV): " + switchMethod("MCMXCIV"));
        long switchEnd = System.nanoTime(); // End Timer
        System.out.println(" | Time taken: " + (switchEnd - switchStart) / 1000 + " Micro Seconds");
    }
}
