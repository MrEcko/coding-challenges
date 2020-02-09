package world.coding.challenges.useful;

import java.io.Console;
import java.util.Arrays;
import java.util.Stack;

public class Recursion {

    /**
     * Reverse a string
     */
    public static String reverse(String input) {
        int n = input.length();
        if (n == 1) return input;
        return reverse(input.substring(1, n)) + input.charAt(0);
    }

    public static String reverseExplicit(String input) {
        StringBuilder output = new StringBuilder();

        Stack<String> explicitStack = new Stack<>();
        explicitStack.add(input);
        while (!explicitStack.empty()) {
            String str = explicitStack.pop();
            if (str.length() == 1) {
                output.append(str);
            } else {
                output.append(str.charAt(str.length() - 1));
                explicitStack.add(str.substring(0, str.length() - 1));
            }
        }
        return output.toString();
    }


    /**
     * Go through an array and print out all of the elements
     */
    public static void printArrayElements(int[] input) {
        print(input[0]);
        if (input.length > 1)
            printArrayElements(Arrays.copyOfRange(input, 1, input.length));
    }

    public static void printArrayElementsExplicit(int[] input) {
        Stack<int[]> explicitStack = new Stack<>();
        explicitStack.add(input);
        while (!explicitStack.empty()) {
            int[] arr = explicitStack.pop();
            print(arr[0]);
            if (arr.length > 1)
                explicitStack.add(Arrays.copyOfRange(arr, 1, arr.length));
        }
    }

    /**
     * Determine whether or not a string is a palindrome
     */
    public static boolean isStringPalindrome(String input) {
        if (input.length() < 2) return true;
        return input.charAt(0) == input.charAt(input.length() - 1) && isStringPalindrome(input.substring(1, input.length() - 1));
    }

    public static boolean isStringPalindromeExplicit(String input) {
        Stack<String> explicitStack = new Stack<>();
        explicitStack.add(input);
        while (!explicitStack.isEmpty()) {
            String str = explicitStack.pop();
            if (str.length() >= 2) {
                if (str.charAt(0) != str.charAt(str.length() - 1)) return false;
                explicitStack.add(str.substring(1, str.length() - 1));
            }
        }
        return true;
    }

    /**
     * Calculate a raised to the power of b
     */
    public static long pow(int a, int b) {
        if (b==1) return a;
        //first case only
        if (b==0) return 1;
        return a * pow(a,b-1);
    }

    public static long powExplicit(int a, int b) {
        Stack<Integer> explicitStack = new Stack<>();
        if (b==0) return 1;
        long output = 1;
        explicitStack.add(b);
        while (!explicitStack.isEmpty()) {
            explicitStack.pop();
            if (b>=1) {
                output*=a;
                explicitStack.add(--b);
            }
        }

        return output;
    }


    public static void print(Object input) {
        System.out.println(input);
    }

}
