import static org.hamcrest.core.IsEqual.equalTo;

import java.util.LinkedHashMap;
import java.util.Map;
import javafx.util.Pair;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class ChangeMakerTest {

  @Rule
  public ErrorCollector errorCollector;
  private ChangeMaker changeMaker;

  public ChangeMakerTest() {
    this.errorCollector = new ErrorCollector();
    this.changeMaker = new ChangeMaker();
  }

  @Test
  public void testAll() {
    Map<Pair<Integer, int[]>, Integer> testCases = new LinkedHashMap<>();
    testCases.put(new Pair<>(4, new int[]{1, 2, 3}), 4);
    testCases.put(new Pair<>(10, new int[]{3}), 0);
    testCases.put(new Pair<>(5, new int[]{1, 3, 5}), 3);
    testCases.forEach((actualInput, expectedOutput)
        -> errorCollector.checkThat(
        this.changeMaker.numberOfWays(actualInput.getKey(), actualInput.getValue()),
        equalTo(expectedOutput)));
  }
}
