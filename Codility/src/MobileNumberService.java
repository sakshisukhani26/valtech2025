

import java.util.Scanner;

public class MobileNumberService {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        
        // Get number input from the user
        System.out.print("Enter a number: ");
        String number = scanner.nextLine();
        
        // Call the rateNumber method to calculate the memorability score
        int score = rateNumber(number);
        
        // Output the memorability rating
        System.out.println("Memorability rating for " + number + ": " + score);
	}
	
	public static int rateNumber(String number) {
        int score = 0;
        
        if (number.length() <= 3) {
            score += 3; // Easier to remember
        } else if (number.length() <= 5) {
            score += 2; // Moderate
        } else {
            score += 1; // Harder to remember
        }
        if (isPalindrome(number)) {
            score += 3; // Palindromes are easier to remember
        }
        if (hasRepeatingDigits(number)) {
            score += 2; // Repeating digits are easier to remember
        }
        return score;
    }

	public static boolean isPalindrome(String number) {
        for (int i = 1; i < number.length()/2; i++) {
            if (number.charAt(i) != number.charAt(number.length()-i-1)) {
                return false;
            }
        }
        return true;
    } 
	
	   public static boolean hasRepeatingDigits(String number) {
	        for (int i = 1; i < number.length(); i++) {
	            if (number.charAt(i) != number.charAt(0)) {
	                return false;
	            }
	        }
	        return true;
	    }
	
}
