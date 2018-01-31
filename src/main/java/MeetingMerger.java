import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MeetingMerger {

  List<Meeting> mergeRanges(List<Meeting> meetingList) {
    List<Meeting> toReturn = new LinkedList<>(meetingList);
    toReturn.sort(Comparator.comparingInt(Meeting::getStartTime));
    ListIterator<Meeting> iterator = toReturn.listIterator();
    while (iterator.hasNext()) {
      Meeting first = iterator.next();
      Meeting second;
      if (iterator.hasNext()) {
        second = iterator.next();
      } else {
        break;
      }
      if (first.getEndTime() >= second.getStartTime()) {
        first.setEndTime(Math.max(first.getEndTime(), second.getEndTime()));
        iterator.remove();
      }
      iterator.previous();
    }
    return toReturn;
  }
}
