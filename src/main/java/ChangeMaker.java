import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ChangeMaker {

  /**
   * Used to calculate the numer of ways to give change.
   *
   * @param amount amount of money in cents.
   * @param denominations available cent denominations. There is an infinite supply of each of those
   *        denominations.
   * @return the numer of ways to make an <code>amount</code> of money with coins of the available
   * <code>denominatons</code>.
   */
  public int numberOfWays(int amount, int[] denominations) {
    int toReturn = 0;
    Set<Integer> usedDenominations = new HashSet<>();
    for (int denominationIndex = 0;
        denominationIndex < denominations.length;
        denominationIndex++) {
      int current = denominations[denominationIndex];
      if (!usedDenominations.contains(current) && current <= amount) {
        for (int i = current; i <= amount; i += current) {
          if (i == amount) {
            toReturn++;
          } else {
            toReturn +=
                numberOfWays(
                    amount - i,
                    Arrays.copyOfRange(
                        denominations,
                        denominationIndex + 1,
                        denominations.length));
          }
        }
      }
      usedDenominations.add(current);
    }
    return toReturn;
  }
}
