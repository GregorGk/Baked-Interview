import java.util.Arrays;
import java.util.Comparator;

public class RectangularLove {

  public Rectangle intersection(Rectangle first, Rectangle second)
      throws TooFewDimensionsException {
    Segment onXAxis = null;
    Segment onYAxis = null;
    TooFewDimensionsException[] exceptions = new TooFewDimensionsException[2];
    try {
      onXAxis = this.uniDimensionalIntersection(
          new Segment(first.getLeftX(), first.getLeftX() + first.getWidth()),
          new Segment(second.getLeftX(), second.getLeftX() + second.getWidth()));
    } catch (TooFewDimensionsException e) {
      exceptions[0] = e;
    }
    try {
      onYAxis = this.uniDimensionalIntersection(
          new Segment(first.getBottomY(), first.getBottomY() + first.getHeight()),
          new Segment(second.getBottomY(), second.getBottomY() + second.getHeight()));
    } catch (TooFewDimensionsException e) {
      exceptions[1] = e;
    }
    int exceptionCount = 0;
    for (TooFewDimensionsException e : exceptions) {
      if (e != null) {
        exceptionCount++;
        if (e.equals(TooFewDimensionsException.Reason.EMPTY_SET)) {
          throw e;
        }
      }
      if (exceptionCount == 2) {
        throw new TooFewDimensionsException(TooFewDimensionsException.Reason
            .ZERO_DIMENSIONAL_INTERSECTION);
      } else if (exceptionCount == 1) {
        throw new TooFewDimensionsException(TooFewDimensionsException.Reason
            .UNIDIMENSIONAL_INTERSECTION);
      }
    }
    return new Rectangle(
        onXAxis.getLower(), onYAxis.getLower(),
        onXAxis.getHigher() - onXAxis.getLower(),
        onYAxis.getHigher() - onYAxis.getLower());
  }

  private Segment uniDimensionalIntersection(
      Segment firstSegment,
      Segment secondSegment)
      throws TooFewDimensionsException {
    Segment[] byLowerCoordinate = new Segment[]{firstSegment, secondSegment};
    Arrays.sort(byLowerCoordinate, Comparator.comparingInt(Segment::getLower));
    Segment firstByLowerCoordinate = byLowerCoordinate[0];
    Segment secondByLowerCoordinate = byLowerCoordinate[1];
    if (firstByLowerCoordinate.getHigher() == secondByLowerCoordinate.getLower()) {
      throw new TooFewDimensionsException(TooFewDimensionsException.Reason
          .ZERO_DIMENSIONAL_INTERSECTION);
    } else if (firstByLowerCoordinate.getHigher() < secondByLowerCoordinate.getLower()) {
      throw new TooFewDimensionsException(TooFewDimensionsException.Reason
          .EMPTY_SET);
    }
    return new Segment(secondByLowerCoordinate.getLower(),
        Math.min(firstByLowerCoordinate.getHigher(), secondByLowerCoordinate.getHigher()));
  }
}
