package studentdirectory.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class UserCollection {

  private static final UserCollection USER_COLLECTION = new UserCollection();

  private final Map<String, User> userMap = new TreeMap<>();

  public static UserCollection getInstance() {
    return USER_COLLECTION;
  }

  public void addUser(final User user) {
    userMap.put(user.getRollNo(), user);
  }

  public void deleteUser(final String rollNo) {
    userMap.remove(rollNo);
  }

  public void clearUserList() {
    userMap.clear();
  }

  public List<User> getUserList() {
    return new ArrayList<>(userMap.values());
  }

  public Map<String, User> getUserMap() {
    return userMap;
  }

  private UserCollection() {

  }
}
