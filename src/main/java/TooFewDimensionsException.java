public class TooFewDimensionsException extends Exception {

  Reason reason;

  public TooFewDimensionsException(Reason reason) {
    super(reason.name());
    this.reason = reason;
  }

  public Reason getReason() {
    return reason;
  }

  public enum Reason {
    EMPTY_SET,
    ZERO_DIMENSIONAL_INTERSECTION,
    UNIDIMENSIONAL_INTERSECTION;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TooFewDimensionsException)) {
      return false;
    }

    TooFewDimensionsException that = (TooFewDimensionsException) o;

    return getReason() == that.getReason();
  }

  @Override
  public int hashCode() {
    return getReason() != null ? getReason().hashCode() : 0;
  }
}
