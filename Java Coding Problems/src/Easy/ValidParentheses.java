package Easy;

import java.util.ArrayList;

public class ValidParentheses {
//-------------------------------- STACK ------------------------------------------------------------
    public static boolean isValid(String s) {
        // Initialize stack using String s in a list form
        String[] str = s.split("");
        // Create stack for last open brackets
        ArrayList<String> stack = new ArrayList<>();

        // Iterate over str array
        for (String string : str) {
            switch (string) { // If an opening character, add it's closing counterpart to the arraylist
                case "(":
                    stack.add(")");
                    break;
                case "{":
                    stack.add("}");
                    break;
                case "[":
                    stack.add("]");
                    break;
                case ")": // If a closing character, check if the stack is empty or if it doesn't = the current character
                    if (stack.isEmpty() || !stack.remove(stack.size() - 1).equals(")")) {
                        return false;
                    }
                    break;
                case "}":
                    if (stack.isEmpty() || !stack.remove(stack.size() - 1).equals("}")) {
                        return false;
                    }
                    break;
                case "]":
                    if (stack.isEmpty() || !stack.remove(stack.size() - 1).equals("]")) {
                        return false;
                    }
                    break;
            }
        }
        // If there is still items in the stack, return false
        return stack.isEmpty();

        // Nothing wrong. Return true
    }

//----------------------------------------- FASTEST CHAR METHOD -----------------------------------------
    public static boolean charMethod(String s) {
        // Initialize char array of the string
        char[] openBrackets = new char[s.length()];
        int openCount = 0; // Count how many open characters

        // Iterate over s using charAt()
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i); // Keep track of current character

            // If an opening character, add it to the array. Inform openCount of a new character
            if (current == '(' || current == '{' || current == '[') {
                openBrackets[openCount] = current;
                openCount++;
            } else {
                if (openCount == 0) { // Check if the array is empty
                    return false;
                }

                // Take note of the last opened character
                char lastOpen = openBrackets[openCount - 1];
                // Check if they are a match
                if ((current == ')' && lastOpen == '(') ||
                        (current == '}' && lastOpen == '{') ||
                        (current == ']' && lastOpen == '[')) {
                    openCount--;
                } else {
                    return false;
                }
            }
        }

        // Check if the array is empty as a boolean
        return openCount == 0;
    }


//------------------------------ MAIN METHOD ----------------------------------------------------------
    public static void main(String[] args) {
        String sOne = "()";
        String sTwo = "()[]{}";
        String sThree = "(()";
        String sFour = "()({[[]]})";
        String sFive = "]";

        long stackStart = System.nanoTime();
        System.out.printf("Stack Method: (): %b%n", isValid(sOne));
        System.out.printf("Stack Method: ()[]{}: %b%n", isValid(sTwo));
        System.out.printf("Stack Method: ()): %b%n", isValid(sThree));
        System.out.printf("Stack Method: ()({[[]]}): %b%n", isValid(sFour));
        System.out.printf("Stack Method: ]: %b%n", isValid(sFive));
        long stackEnd = System.nanoTime();

        System.out.print("\nStack Method Time: " + (stackEnd - stackStart) / 1000 + " Micro Seconds");

        System.out.println("\n-------------------------------------------------------------\n");

        long charStart = System.nanoTime();
        System.out.printf("Char Method: (): %b%n", charMethod(sOne));
        System.out.printf("Char Method: ()[]{}: %b%n", charMethod(sTwo));
        System.out.printf("Char Method: ()): %b%n", charMethod(sThree));
        System.out.printf("Char Method: ()({[[]]}): %b%n", charMethod(sFour));
        System.out.printf("Char Method: ]: %b%n", charMethod(sFive));
        long charEnd = System.nanoTime();
        System.out.print("\nStack Method Time: " + (charEnd - charStart) / 1000 + " Micro Seconds");


    }
}
