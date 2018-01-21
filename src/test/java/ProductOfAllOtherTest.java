import static org.hamcrest.core.IsEqual.equalTo;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class ProductOfAllOtherTest {

  @Rule
  public ErrorCollector errorCollector;
  private ProductOfAllOther productOfAllOther;

  public ProductOfAllOtherTest() {
    this.productOfAllOther = new ProductOfAllOther();
    this.errorCollector = new ErrorCollector();
  }

  @Test
  public void checkProductOfAllOther() {
    Map<int[], int[]> testCases = new LinkedHashMap<>();
    testCases.put(new int[] {1, 7, 3, 4}, new int[] {84, 12, 28, 21});
    testCases.put(new int[] {0, 1, 2, 3}, new int[]{6, 0, 0, 0});
    testCases.put(new int[] {1, 0, 0, 1}, new int[]{0, 0, 0, 0});
    testCases.put(new int[] {2, 1}, new int[]{1, 2});
    testCases.forEach((actualInput, expectedOutput)
        -> errorCollector.checkThat(
        this.productOfAllOther
            .productOfAllOtherNumbers(actualInput), equalTo(expectedOutput)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNumbersOfArguments() {
    this.productOfAllOther
        .productOfAllOtherNumbers(new int[] {1});
  }
}
