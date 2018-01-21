public class ProductOfAllOther {

  /**
   * Without using division.
   *
   * @param inputArray product of all elements of this array is assumed to produce no overflow.
   * @return an array containing products of all other elements.
   */
  public int[] productOfAllOtherNumbers(int[] inputArray) {
    if (inputArray.length < 2) {
      throw new IllegalArgumentException(
          "At least 2 numbers in the array required to get product of all other numbers.");
    }
    int[] productOfAllElementsExceptAtIndex = new int[inputArray.length];
    for (int i = 0, productSoFar = 1; i < inputArray.length; i++) {
      productOfAllElementsExceptAtIndex[i] = productSoFar;
      productSoFar *= inputArray[i];
    }
    for (int i = inputArray.length - 1, productSoFar = 1; i >= 0; i--) {
      productOfAllElementsExceptAtIndex[i] *= productSoFar;
      productSoFar *= inputArray[i];
    }
    return productOfAllElementsExceptAtIndex;
  }
}
