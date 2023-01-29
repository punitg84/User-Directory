package studentdirectory.comparator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import studentdirectory.comparator.usercomparatortestscenario.CompareTestScenario;
import studentdirectory.enums.CourseType;
import studentdirectory.models.User;
import studentdirectory.models.usertestscenario.CompareToTestScenario;

class UserComparatorByNameAscTest {
  private static Stream<CompareTestScenario> generateTestForCompare() {

    User user1 = new User("User 1", 10, "address 1", "Roll No 1",
        Arrays.asList(CourseType.A, CourseType.B, CourseType.C, CourseType.D));
    User user2 = new User("User 2", 18, "address 2", "Roll No 2",
        Arrays.asList(CourseType.A, CourseType.B, CourseType.F, CourseType.D));

    //Test Case 1 User 1 name less than User 2 name
    CompareTestScenario testCase1 = CompareTestScenario.builder()
                                    .firstUser(user1)
                                    .secondUser(user2)
                                    .output(-1)
                                    .testCaseName("second user less")
                                    .errMessage("")
                                    .build();

    //Test Case 2 User 2 name less than User 1 name
    CompareTestScenario testCase2 = CompareTestScenario.builder()
                                    .firstUser(user2)
                                    .secondUser(user1)
                                    .output(1)
                                    .testCaseName("first user less")
                                    .errMessage("")
                                    .build();

    //Test Case 3 Same name
    CompareTestScenario testCase3 = CompareTestScenario.builder()
                                    .firstUser(user1)
                                    .secondUser(user1)
                                    .output(0)
                                    .testCaseName("Equal")
                                    .errMessage("")
                                    .build();

    return Stream.of(testCase1,testCase2,testCase3);
  }

  @ParameterizedTest
  @MethodSource("generateTestForCompare")
  void compare(CompareTestScenario testCase) {
    UserComparatorByNameAsc comparator = new UserComparatorByNameAsc();
    User firstUser = testCase.getFirstUser();
    User secondUser = testCase.getSecondUser();
    int actualOutput = comparator.compare(firstUser, secondUser);
    assertEquals(testCase.getOutput(), actualOutput, testCase.getTestCaseName());
  }
}