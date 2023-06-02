import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class PasswordGenerator {

    public String password = "";

    public String generate(String characterType, String password){
        int min = 2;
        int max = 10;
        Random randomize = new Random();
        int randomizedLength = randomize.nextInt(max - min + 1) + min;
        int count = 0;

        while (count < randomizedLength) {
            password = password + characterType.charAt(randomize.nextInt(randomizedLength));
            //System.out.println(password);
            count++;
        }

        // Jumble order
        password = jumbleString(password);;

        this.password = password;
        return password;
    }

    public static String jumbleString(String input) {
        // Convert the string to a character array
        char[] charArray = input.toCharArray();

        // Convert the character array to a list for shuffling
        List<Character> charList = new ArrayList<>();
        for (char c : charArray) {
            charList.add(c);
        }

        // Shuffle the list
        Collections.shuffle(charList);

        // Convert the shuffled list back to a character array
        char[] shuffledArray = new char[charList.size()];
        for (int i = 0; i < charList.size(); i++) {
            shuffledArray[i] = charList.get(i);
        }

        // Convert the character array to a string
        String shuffledString = new String(shuffledArray);

        return shuffledString;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
