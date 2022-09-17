import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dm.Petrov
 * DATE: 17.09.2022
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicIntegerLength3 = new AtomicInteger();
        AtomicInteger atomicIntegerLength4 = new AtomicInteger();
        AtomicInteger atomicIntegerLength5 = new AtomicInteger();
        PrettyChecker checker = new PrettyChecker();
        String[] checked = NickNameSelection.generateArrayNickNames(30, "abc");
        System.out.println(Arrays.toString(checked));
        Thread findPalindrome = new Thread(() -> {
            for (String nick : checked) {
                if (nick.length() == 3 && checker.isPalindrome(nick) && !checker.isOneLetter(nick)) {
                    atomicIntegerLength3.incrementAndGet();
                }
                if (nick.length() == 4 && checker.isPalindrome(nick) && !checker.isOneLetter(nick)) {
                    atomicIntegerLength4.incrementAndGet();
                }
                if (nick.length() == 5 && checker.isPalindrome(nick) && !checker.isOneLetter(nick)) {
                    atomicIntegerLength5.incrementAndGet();
                }
            }
        });
        Thread findOneLetterNick = new Thread(() -> {
            for (String nick : checked) {
                if (nick.length() == 3 && checker.isOneLetter(nick)) {
                    atomicIntegerLength3.incrementAndGet();
                }
                if (nick.length() == 4 && checker.isOneLetter(nick)) {
                    atomicIntegerLength4.incrementAndGet();
                }
                if (nick.length() == 5 && checker.isOneLetter(nick)) {
                    atomicIntegerLength5.incrementAndGet();
                }
            }
        });
        Thread findSortedNick = new Thread(() -> {
            for (String nick : checked) {
                if (nick.length() == 3 && checker.isSortedNick(nick) && !checker.isOneLetter(nick)) {
                    atomicIntegerLength3.incrementAndGet();
                }
                if (nick.length() == 4 && checker.isSortedNick(nick) && !checker.isOneLetter(nick)) {
                    atomicIntegerLength4.incrementAndGet();
                }
                if (nick.length() == 5 && checker.isSortedNick(nick) && !checker.isOneLetter(nick)) {
                    atomicIntegerLength5.incrementAndGet();
                }
            }
        });
        findPalindrome.start();
        findOneLetterNick.start();
        findSortedNick.start();
        findPalindrome.join();
        findOneLetterNick.join();
        findSortedNick.join();


        System.out.println("Pretty nick length3 : " + atomicIntegerLength3);
        System.out.println("Pretty nick length4 : " + atomicIntegerLength4);
        System.out.println("Pretty nick length5 : " + atomicIntegerLength5);

    }
}
