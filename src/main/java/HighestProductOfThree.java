import java.util.Arrays;

public class HighestProductOfThree {

  /**
   * Used to calculate the highest possible product of 3 elements of the array.
   *
   * @param inputArray the highest product of 3 elements of this array
   *        is assumed to produce no overflow.
   * @return the highest product of 3 integers from the <code>inputArray</code>.
   */
  public int highestProductOfThreeNumbers(int[] inputArray) {
    if (inputArray.length < 3) {
      throw new IllegalArgumentException("An array of at least 3 elements needed.");
    }
    int[] sortee = Arrays.copyOfRange(inputArray, 0, 3);
    Arrays.sort(sortee);
    int lowest = sortee[0];
    int secondLowest = sortee[1];
    int highest = sortee[2];
    int secondHighest = sortee[1];
    int thirdHighest = sortee[0];
    for (int i = 3; i < inputArray.length; i++) {
      int element = inputArray[i];
      if (element < lowest) {
        secondLowest = lowest;
        lowest = element;
      } else if (element < secondLowest) {
        secondLowest = element;
      }
      if (element > highest) {
        thirdHighest = secondHighest;
        secondHighest = highest;
        highest = element;
      } else if (element > secondHighest) {
        thirdHighest = secondHighest;
        secondHighest = element;
      } else if (element > thirdHighest) {
        thirdHighest = element;
      }
    }
    return Math.max(
        highest * secondHighest * thirdHighest,
        highest * lowest * secondLowest);
  }
}