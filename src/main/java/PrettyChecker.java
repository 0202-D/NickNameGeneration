import java.util.Arrays;

/**
 * @author Dm.Petrov
 * DATE: 17.09.2022
 */
public class PrettyChecker {

    public boolean isPalindrome(String nick) {
        StringBuilder sb = new StringBuilder(nick);
        sb.reverse();
        return nick.equals(sb.toString());
    }

    public boolean isOneLetter(String nick) {
        for (int i = 1; i < nick.length(); i++) {
            if (nick.charAt(i) != nick.charAt(0)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSortedNick(String nick) {
        char[] array = nick.toCharArray();
        Arrays.sort(array);
        String sorted = String.valueOf(array);
        return nick.equals(sorted);
    }
}
