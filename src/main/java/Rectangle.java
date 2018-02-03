public class Rectangle {

  // coordinates of bottom left corner
  private int leftX;
  private int bottomY;

  // dimensions
  private int width;
  private int height;

  /**
   * Rectangle object.
   */
  public Rectangle(int leftX, int bottomY, int width, int height) {
    this.leftX = leftX;
    this.bottomY = bottomY;
    this.width  = width;
    this.height = height;
  }

  public int getLeftX() {
    return leftX;
  }

  public int getBottomY() {
    return bottomY;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Rectangle)) {
      return false;
    }

    Rectangle rectangle = (Rectangle) o;

    if (getLeftX() != rectangle.getLeftX()) {
      return false;
    }
    if (getBottomY() != rectangle.getBottomY()) {
      return false;
    }
    if (getWidth() != rectangle.getWidth()) {
      return false;
    }
    return getHeight() == rectangle.getHeight();
  }

  @Override
  public int hashCode() {
    int result = getLeftX();
    result = 31 * result + getBottomY();
    result = 31 * result + getWidth();
    result = 31 * result + getHeight();
    return result;
  }
}