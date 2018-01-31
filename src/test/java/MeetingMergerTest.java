import static org.hamcrest.core.IsEqual.equalTo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class MeetingMergerTest {

  @Rule
  public ErrorCollector errorCollector;
  private MeetingMerger meetingMerger;

  public MeetingMergerTest() {
    this.errorCollector = new ErrorCollector();
    this.meetingMerger = new MeetingMerger();
  }

  @Test
  public void testAll() {
    Map<List<Meeting>, List<Meeting>> testCases = new LinkedHashMap<>();
    testCases.put(
        List.of(new Meeting(0, 1), new Meeting(0, 2)),
        List.of(new Meeting(0, 2)));
    testCases.put(
        List.of(new Meeting(0, 2), new Meeting(0, 1)),
        List.of(new Meeting(0, 2)));
    testCases.put(
        List.of(new Meeting(1, 2), new Meeting(2, 3)),
        List.of(new Meeting(1, 3)));
    testCases.put(
        List.of(new Meeting(3, 5), new Meeting(1, 3)),
        List.of(new Meeting(1, 5)));
    testCases.put(
        List.of(new Meeting(1, 2), new Meeting(2, 3), new Meeting(2, 3)),
        List.of(new Meeting(1, 3)));
    testCases.put(
        List.of(new Meeting(4, 5), new Meeting(10, 11), new Meeting(1, 2)),
        List.of(new Meeting(1, 2), new Meeting(4, 5), new Meeting(10, 11)));
    testCases.put(
        List.of(new Meeting(1, 4), new Meeting(2, 3), new Meeting(5, 8)),
        List.of(new Meeting(1, 4), new Meeting(5, 8)));
    testCases.forEach((actualInput, expectedOutput)
        -> errorCollector.checkThat(
        String.format(
            "For the meetings list: %s"
                + "the expected condensed meeting list should look like this: %s.",
            actualInput, expectedOutput),
        this.meetingMerger.mergeRanges(actualInput), equalTo(expectedOutput)));
  }
}
