public class PasswordStrengthChecker {
    
    public String strengthCheck(String password) {
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSymbol = false;
        boolean hasNumber = false;

        // Define character types used
        for (int i = 0; i < password.length(); i++) {
            for (int upperCaseCounter = 0; upperCaseCounter < Alphabet.UPPERCASE_LETTERS.length(); upperCaseCounter++) {
                if (password.charAt(i) == Alphabet.UPPERCASE_LETTERS.charAt(upperCaseCounter)) {
                    hasUpperCase = true;
                    break;
                }
            }

            for (int lowerCaseCounter = 0; lowerCaseCounter < Alphabet.LOWERCASE_LETTERS.length(); lowerCaseCounter++) {
                if (password.charAt(i) == Alphabet.LOWERCASE_LETTERS.charAt(lowerCaseCounter)) {
                    hasLowerCase = true;
                    break;
                }
            }

            for (int symbolCounter = 0; symbolCounter < Alphabet.SYMBOLS.length(); symbolCounter++) {
                if (password.charAt(i) == Alphabet.SYMBOLS.charAt(symbolCounter)) {
                    hasSymbol = true;
                    break;
                }
            }

            for (int numberCounter = 0; numberCounter < Alphabet.NUMBERS.length(); numberCounter++) {
                if (password.charAt(i) == Alphabet.NUMBERS.charAt(numberCounter)) {
                    hasNumber = true;
                    break;
                }
            }
        }

        // Define message to be displayed
        if (hasUpperCase && hasLowerCase && hasSymbol && hasNumber) {
            return "This is a very strong password!";
        } else if (hasLowerCase && hasSymbol && (hasUpperCase || hasNumber) || hasLowerCase && hasNumber && hasUpperCase || hasSymbol && hasNumber && (hasUpperCase || hasLowerCase)
        ) {
            return "This password is strong, try adding one more uppercase or lowercase character, symbol, or number to maximize the strength.";
        } else if ((hasUpperCase && hasLowerCase) || (hasUpperCase && hasSymbol) || (hasUpperCase && hasNumber) ||
                (hasLowerCase && hasSymbol) || (hasLowerCase && hasNumber) || (hasSymbol && hasNumber)
        ) {
            return "This is a weak password, try adding upper and lowercase characters, symbols, and numbers to strengthen your password.";
        } else if (hasUpperCase || hasLowerCase || hasSymbol || hasNumber) {
            return "This is a very weak password, try adding upper and lowercase characters, symbols, and numbers to strengthen your password.";
        } else {
            return "Please add a valid password.";
        }

    }
}
