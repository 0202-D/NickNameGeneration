import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Dm.Petrov
 * DATE: 17.09.2022
 */
public class PrettyCheckerTest {
    PrettyChecker checker = new PrettyChecker();

    @ParameterizedTest()
    @MethodSource("source")
    void testPalindrome(String str, boolean expected) {
        boolean result = checker.isPalindrome(str);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> source() {
        return Stream.of(Arguments.of("aba", true),
                Arguments.of("abd", false),
                Arguments.of("abaaba", true),
                Arguments.of("baacb", false));
    }
    @ParameterizedTest()
    @MethodSource("source2")
    void testOneLetter(String str, boolean expected) {
        boolean result = checker.isOneLetter(str);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> source2() {
        return Stream.of(Arguments.of("aaa", true),
                Arguments.of("abd", false),
                Arguments.of("abaaba", false),
                Arguments.of("acb", false),
                Arguments.of("baacb", false));
    }
    @ParameterizedTest()
    @MethodSource("source3")
    void testSorted(String str, boolean expected) {
        boolean result = checker.isSortedNick(str);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> source3() {
        return Stream.of(Arguments.of("aaa", true),
                Arguments.of("dac",false),
                Arguments.of("kmzzzz", true),
                Arguments.of("baacb", false));
    }
}
