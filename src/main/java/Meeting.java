public class Meeting {

  private int startTime;
  private int endTime;

  /**
   * Initializes a meeting.
   *
   * @param startTime start time of the meeting; the number of 30 min blocks past 9:00 am.
   * @param endTime end time of the meeting; number of 30 min blocks past 9:00 am.
   */
  public Meeting(int startTime, int endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public int getStartTime() {
    return startTime;
  }

  public void setStartTime(int startTime) {
    this.startTime = startTime;
  }

  public int getEndTime() {
    return endTime;
  }

  public void setEndTime(int endTime) {
    this.endTime = endTime;
  }

  public String toString() {
    return String.format("Meeting: startTime = %s, endTime = %s.", startTime, endTime);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Meeting)) {
      return false;
    }

    Meeting meeting = (Meeting) o;

    if (getStartTime() != meeting.getStartTime()) {
      return false;
    }
    return getEndTime() == meeting.getEndTime();
  }

  @Override
  public int hashCode() {
    int result = getStartTime();
    result = 31 * result + getEndTime();
    return result;
  }
}