import java.util.Comparator;

/**
 * Comparator that allows for comparison of characters and
 * counting said comparisons.
 *
 * This MUST BE USED for character comparisons. Using any other form of
 * comparison for characters will result in test failures.
 *
 * DO NOT CREATE INSTANCES OF THIS CLASS
 *
 * DO NOT MODIFY THIS FILE!!
 *
 * @author CS 1332 TAs
 * @version 1.0
 */
public class CharacterComparator implements Comparator<Character> {

    private int comparisonCount;

    /**
     * To be used when comparing characters. Keeps count of
     * how many times this method has been called.
     *
     * @param a First character to be compared.
     * @param b Second character to be compared.
     * @return  Negative value if a is less than b, positive
     *          if a is greater than b, and 0 otherwise.
     */
    @Override
    public int compare(Character a, Character b) {
        comparisonCount++;
        return a - b;
    }

    /**
     * Gets the number of times compare has been used.
     *
     * @return The comparison count.
     */
    public int getComparisonCount() {
        return comparisonCount;
    }
}