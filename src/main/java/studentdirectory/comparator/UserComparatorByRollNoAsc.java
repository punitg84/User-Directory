package studentdirectory.comparator;

import java.util.Comparator;
import studentdirectory.models.User;

public class UserComparatorByRollNoAsc implements Comparator<User> {

  @Override
  public int compare(final User o1, final User o2) {
    return o1.getRollNo().compareTo(o2.getRollNo());
  }
}
