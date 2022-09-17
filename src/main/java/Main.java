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
        String[] checked = NickNameSelection.generateArrayNickNames(100000, "abc");
        Thread findPalindrome = new Thread(() -> {
            for (String nick : checked) {
                if (checker.isPalindrome(nick) && nick.length() == 3) {
                    atomicIntegerLength3.incrementAndGet();
                }
                if (checker.isPalindrome(nick) && nick.length() == 4) {
                    atomicIntegerLength4.incrementAndGet();
                }
                if (checker.isPalindrome(nick) && nick.length() == 5) {
                    atomicIntegerLength5.incrementAndGet();
                }
            }
        });
        Thread findOneLetterNick = new Thread(() -> {
            for (String nick : checked) {
                if (checker.isOneLetter(nick) && nick.length() == 3) {
                    atomicIntegerLength3.incrementAndGet();
                }
                if (checker.isOneLetter(nick) && nick.length() == 4) {
                    atomicIntegerLength4.incrementAndGet();
                }
                if (checker.isOneLetter(nick) && nick.length() == 5) {
                    atomicIntegerLength5.incrementAndGet();
                }
            }
        });
        Thread findSortedNick = new Thread(() -> {
            for (String nick : checked) {
                if (checker.isSortedNick(nick) && nick.length() == 3) {
                    atomicIntegerLength3.incrementAndGet();
                }
                if (checker.isSortedNick(nick) && nick.length() == 4) {
                    atomicIntegerLength4.incrementAndGet();
                }
                if (checker.isSortedNick(nick) && nick.length() == 5) {
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
