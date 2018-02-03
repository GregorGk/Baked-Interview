import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class RectangularLoveTest {

  @Rule
  public ErrorCollector errorCollector;
  private RectangularLove rectangularLove;

  public RectangularLoveTest() {
    this.errorCollector = new ErrorCollector();
    this.rectangularLove = new RectangularLove();
  }

  @Test
  public void testForOneRectangleContainedInAnother() throws TooFewDimensionsException {
    assertEquals(
        this.rectangularLove.intersection(
            new Rectangle(0, 0, 100, 100),
            new Rectangle(10, 10, 1, 1)),
        new Rectangle(10, 10, 1, 1));
  }

  @Test
  public void testWithNegativeCoordinates() throws TooFewDimensionsException {
    assertEquals(
        this.rectangularLove.intersection(
            new Rectangle(-5, -5, 2, 2),
            new Rectangle(-6, -6, 2, 2)
        ),
        new Rectangle(-5, -5, 1, 1)
    );
  }

  @Test
  public void testWithNegativeWidthsAndHeights() throws TooFewDimensionsException {
    assertEquals(
        this.rectangularLove.intersection(
            new Rectangle(3, 3, -3, -3),
            new Rectangle(2, 2, -10, -20)
        ),
        new Rectangle(0, 0, 2, 2)
    );
  }

  /**
   * Special cases follow! Those can be handled in a different way.
   */
  @Test(expected = TooFewDimensionsException.class)
  public void testForEmptyIntersections() throws TooFewDimensionsException {
    this.rectangularLove.intersection(
        new Rectangle(0, 0, 1, 1),
        new Rectangle(5, 5, 1, 1));
  }

  @Test(expected = TooFewDimensionsException.class)
  public void testForPointIntersection() throws TooFewDimensionsException {
    this.rectangularLove.intersection(
        new Rectangle(0, 0, 1, 1),
        new Rectangle(1, 1, 1, 1));
  }

  @Test(expected = TooFewDimensionsException.class)
  public void testForSegmentIntersection() throws TooFewDimensionsException {
    this.rectangularLove.intersection(
        new Rectangle(0, 0, 1, 1),
        new Rectangle(1, 0, 1, 1));
  }
}
