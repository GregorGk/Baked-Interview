public class Segment {

  private int lower;
  private int higher;

  public Segment(int first, int second) throws TooFewDimensionsException {
    if (first == second) {
      throw new TooFewDimensionsException(TooFewDimensionsException.Reason
          .ZERO_DIMENSIONAL_INTERSECTION);
    }
    if (first < second) {
      this.lower = first;
      this.higher = second;
    } else {
      this.lower = second;
      this.higher = first;
    }
  }

  public int getLower() {
    return lower;
  }

  public int getHigher() {
    return higher;
  }
}
