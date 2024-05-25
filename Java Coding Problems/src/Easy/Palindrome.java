package Easy;

public class Palindrome {

//-------------------------------------------------- COMPLETE REVERSAL O(n) --------------------------------------------------
    public static boolean completeReverse(int num) {
        // Negative numbers are not palindromes
        if (num < 0) {
            return false;
        }

        // Store the original number
        int originalNum = num;
        int reversedNum = 0;

        // Reverse the integer
        while (num != 0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }

        // Check if the reversed number is equal to the original number
        if (originalNum == reversedNum) {
            return true;
        } else {
            return false;
        }
    }
//-------------------------------------------------- SEMI REVERSAL O(log10(n)) --------------------------------------------------
    public static boolean semiReverse(int x) {
        // X cannot be negative | X cannot end in 0 | X cannot be 0
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        // Initialize reverted number
        int revertedNumber = 0;
        while (x > revertedNumber) {    // While x is larger than the revertedNumber
            /*  1. Multiply by 10 to gain a 0 (121 * 10 = 1210)
                    1a. Done on reverted number to prepare to add a new digit in that empty slot
                2. mod(%) original number by 10 (121 % 10 = 1)
                    2a. This is done to get the last digit of the original number
                3. Divide(/) original number by 10
                    3a. This is done to move the decimal to the left 1 digit. (121 / 10 = 12)
                    3b. Since the type is integer, it will round down to nearest whole number
             */
            revertedNumber = revertedNumber * 10 + (x % 10);
            x /= 10;
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
        */
        return x == revertedNumber || x == revertedNumber / 10;
    }

//----------------------------------------------------- MAIN METHOD -----------------------------------------------------
    public static void main(String[] args) {
        int num1 = 121;
        int num2 = 122;
        int num3 = 12321;
        int num4 = 124321;

        System.out.println("Complete Reverse (121): " + completeReverse(num1));
        System.out.println("Complete Reverse (122): " + completeReverse(num2));
        System.out.println("Complete Reverse (12321): " + completeReverse(num3));
        System.out.println("Complete Reverse (124321): " + completeReverse(num4));

        System.out.println("Semi Reverse (121): " + semiReverse(num1));
        System.out.println("Semi Reverse (122): " + semiReverse(num2));
        System.out.println("Semi Reverse (12321): " + semiReverse(num3));
        System.out.println("Semi Reverse (124321): " + semiReverse(num4));

    }
}
