import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.rmi.UnexpectedException;
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
  public void testForOneRectangleContainedInAnother() {
    assertEquals(
        this.rectangularLove.intersection(
            new Rectangle(0, 0, 100, 100),
            new Rectangle(10, 10, 1, 1)),
        new Rectangle(10, 10, 1, 1));
  }

  @Test
  public void testWithNegativeCoordinates() {
    assertEquals(
        this.rectangularLove.intersection(
            new Rectangle(-5, -5, 2, 2),
            new Rectangle(-6, -6, 2, 2)
        ),
        new Rectangle(-5, -5, 1, 1)
    );
  }

  @Test
  public void testWithNegativeWidthsAndHeights() {
    assertEquals(
        this.rectangularLove.intersection(
            new Rectangle(3, 3, -3, -3),
            new Rectangle(2, 2, -10, -20)
        ),
        new Rectangle(0, 0, 2, 2)
    );
  }

  /**
   * Special case! Could be handled in a different way.
   */
  @Test(expected = UnexpectedException.class)
  public void testForEmptyIntersections() {
    this.rectangularLove.intersection(
        new Rectangle(0, 0, 1, 1),
        new Rectangle(5, 5, 1, 1));
  }

  /**
   * Special case! Could be handled in a different way.
   */
  @Test(expected = UnexpectedException.class)
  public void testForPointIntersection() {
    this.rectangularLove.intersection(
        new Rectangle(0, 0, 1, 1),
        new Rectangle(1, 1, 1, 1));
  }

  /**
   * Special case! Could be handled in a different way.
   */
  @Test(expected = UnexpectedException.class)
  public void testForSegmentIntersection() {
    this.rectangularLove.intersection(
        new Rectangle(0, 0, 1, 1),
        new Rectangle(1, 0, 1, 1));
  }
}
