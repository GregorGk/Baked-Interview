import static org.hamcrest.core.IsEqual.equalTo;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class HighestProductOfThreeTest {

  @Rule
  public ErrorCollector errorCollector;
  private HighestProductOfThree highestProductOfThree;

  public HighestProductOfThreeTest() {
    this.highestProductOfThree = new HighestProductOfThree();
    this.errorCollector = new ErrorCollector();
  }

  @Test
  public void testAll() {
    Map<int[], Integer> testCases = new LinkedHashMap<>();
    testCases.put(new int[] {1, 2, 3}, 6);
    testCases.put(new int[] {1, 2, 3, 10, 20, 30}, 6000);
    testCases.put(new int[] {10, 20, 30, 0, 1, 2, 3}, 6000);
    this.checkThem(testCases);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNumberOfArguments() {
    this.highestProductOfThree.highestProductOfThreeNumbers(new int[] {1, 2});
  }

  @Test
  public void testNegative() {
    Map<int[], Integer> testCases = new LinkedHashMap<>();
    testCases.put(new int[] {-1, 3, 1, 2}, 6);
    testCases.put(new int[] {4, 2, -1, 5}, 40);
    this.checkThem(testCases);
  }

  private void checkThem(Map<int[], Integer> testCases) {
    testCases.forEach((actualInput, expectedOutput)
        -> errorCollector.checkThat(
        this.highestProductOfThree.
            highestProductOfThreeNumbers(actualInput), equalTo(expectedOutput)));
  }
}
