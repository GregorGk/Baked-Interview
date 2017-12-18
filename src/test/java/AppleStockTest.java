import static org.hamcrest.core.IsEqual.equalTo;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class AppleStockTest {

  @Rule
  public ErrorCollector errorCollector;
  private AppleStock appleStock;

  public AppleStockTest() {
    this.appleStock = new AppleStock();
    this.errorCollector = new ErrorCollector();
  }

  @Test
  public void testTypicalStockGains() {
    Map<int[], Integer> testCases = new LinkedHashMap<>();
    testCases.put(new int[]{1, 2, 3}, 2);
    testCases.put(new int[]{1, 1, 1}, 0);
    testCases.put(new int[]{3, 2, 1}, -1);
    testCases.put(new int[]{1, 2}, 1);
    testCases.put(new int[]{10, 7, 5, 8, 11, 9}, 6);
    testCases.put(new int[]{3, 2, 1, 2, 3, 4}, 3);
    testCases.put(new int[]{3, 2, 1, 2, 5, 4, 1}, 4);
    testCases.put(new int[]{1, 2, 3, 2}, 2);
    testCases.put(new int[]{0, Integer.MAX_VALUE}, Integer.MAX_VALUE);
    testCases.forEach((actualInput, expectedOutput)
        -> errorCollector.checkThat(
        this.appleStock.getMaxProfit(actualInput), equalTo(expectedOutput)));
  }

  @Test(expected = Exception.class)
  public void testNumberOfArgumentsFirst() {
    appleStock.getMaxProfit(new int[]{});
  }

  @Test(expected = Exception.class)
  public void testNumberOfArgumentsSecond() {
    appleStock.getMaxProfit(new int[]{1});
  }
}
