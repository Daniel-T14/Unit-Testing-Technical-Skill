# Unit-Testing-Technical-Skill

Contains material created for devTech3 class 506. Designed to learn java unit testing. 

Overview
The goal of this DevTech is for you to write a series of unit tests for a provided DoublyLinkedList class. This class is a simplified version of the LinkedList class that is provided by java.util.LinkedList. You will write unit tests for each of the provided public methods as well as create broken versions of the DoublyLinkedList class to show that your tests are able to catch faulty implementations.

For each publicly available method one partner should write the test and the other should write the broken implementation. After each test, partners must switch roles. Attribute authors as appropriate for these tasks.

The DoublyLinkedList Class
Doubly linked lists are linked lists that maintain a reference to both the next node but also the previous node. This allows the list to be traversed either from beginning to end or end to beginning. By default LinkedList (from java.util.LinkedList) in Java is a doubly linked list. We have provided you with a simplified version adapted from java.util.LinkedList.

Our DoublyLinkedList class provides the following publicly available functions:

add(int, E) void
addFirst(E) void
addLast(E) void
get(int) E
getFirst() E
getLast() E
isEmpty() boolean
remove(int) E
removeFirst() E
removeLast() E
set(int, E) E
size() int
Descriptions of most of these members are available inside of javadoc comments within the source code. Please do not modify the provided DoublyLinkedList class.

Writing Tests
You are to write unit tests to verify that each of these functions behaves as expected. As you write your tests, you should also create broken versions of the DoublyLinkedList class to prove that the test is able to correctly detect errors.

Each test should include javadoc with the following required elements:

@see <RelatedBrokenClass> where <RelatedBrokenClass> is the precise name of the class used to test that this test catches errors
@author <author> where <author> is the name of the partner who wrote the test
Below you can see the first part of the starter test code that you were provided with:

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DoublyLinkedListTest {
    /**
     * Use this to toggle between using the DoublyLinkedList class and your broken classes
     * You may submit with either true or false.
     */
    boolean SHOULD_FAIL = false;

    private DoublyLinkedList<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new DoublyLinkedList<>();
    }

    // Tests for get

    /**
     * @author grayson_replace_this
     * @see GetAtOutOfBoundsThrowsException
     */
    @Test
    public void testGetAtOutOfBoundsThrowsException() {
        if (SHOULD_FAIL) list = new GetAtOutOfBoundsThrowsException<>();

        list.addLast(1);
        list.addLast(2);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    /**
     * @author
     * @see
     */
    @Test
    public void testGetAtIndex() {
        fail("Not yet implemented");
    }
		...
For your convenience there is a SHOULD_FAIL boolean. You will see in the provided test SHOULD_FAIL being true replaces the provided DoublyLinkedList with a new version that was designed to purposely fail the test when used with the get function. Please do the same for each of your tests.

Additionally, some test method stubs have been provided (e.g. testGetAtIndex). These are not all the tests. You will have to add more and choose appropriate names for them.

Before writing any tests, please read the "Graded Components" section to learn what tests you need to write.

Writing Broken Implementations
To create a broken version of DoublyLinkedList you will create a new class that inherits from DoublyLinkedList and override the methods that you wish to modify.

Each class should include javadoc with the following required element:

@author <author> where <author> is the name of the partner who wrote the class
Below you can see the example broken library that is used for the isEmpty tests, called GetAtOutOfBoundsThrowsException:

/**
 * @author grayson_replace_this
 */
public class GetAtOutOfBoundsThrowsException<E> extends DoublyLinkedList<E> {
    @Override
    public E get(int index) {
        // Forces all gets to be within the bounds of the list
        return super.get(Math.min(super.size() - 1, Math.max(0, index)));
    }
}
As you can see, I overrode the get function to incorrectly force all calls to get to stay within the bounds of the list, which is a reasonably possible "mistake" to have made while implementing the data structure. Additionally, you can see that this class inherits from our provided DoublyLinkedList class to reduce code duplication and make swapping it in for testing easier.

When creating the broken subclasses of DoublyLinkedList you are to break as little functionality as is possible. In other words try to break the functionality of the overridden methods only enough that just that test will fail (where possible).

Running Tests
To run your tests you can either use your IDE's built in test tools, or the provided docker compose file.

The command docker compose up (or for some systems docker-compose up) will run the tests. If there are test failures you may see something like the following:

junit_test  | [ERROR] 
junit_test  | [ERROR] Please refer to /app/target/surefire-reports for the individual test results.
junit_test  | [ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
junit_test  | [ERROR] -> [Help 1]
junit_test  | [ERROR] 
junit_test  | [ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
junit_test  | [ERROR] Re-run Maven using the -X switch to enable full debug logging.
junit_test  | [ERROR] 
junit_test  | [ERROR] For more information about the errors and possible solutions, please read the following articles:
junit_test  | [ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
junit_test exited with code 1
If you scroll up, however, you will see the testing summary and cause of the failures:

junit_test  | [INFO] 
junit_test  | [INFO] Results:
junit_test  | [INFO] 
junit_test  | [ERROR] Failures: 
junit_test  | [ERROR]   DoublyLinkedListTest.testAddAtIndexOutOfBoundsThrowsException:41 Not yet implemented
junit_test  | [ERROR]   DoublyLinkedListTest.testAddFirstAddsElement:52 Not yet implemented
junit_test  | [ERROR]   DoublyLinkedListTest.testAddLastAddsElement:63 Not yet implemented
junit_test  | [ERROR]   DoublyLinkedListTest.testGetAtIndex:74 Not yet implemented
junit_test  | [ERROR]   DoublyLinkedListTest.testGetAtOutOfBoundsThrowsException:83 Not yet implemented
junit_test  | [ERROR]   DoublyLinkedListTest.testRemoveAtIndex:100 Not yet implemented
junit_test  | [ERROR]   DoublyLinkedListTest.testRemoveFirstOnEmptyListThrowsException:111 Not yet implemented
junit_test  | [INFO] 
junit_test  | [ERROR] Tests run: 8, Failures: 7, Errors: 0, Skipped: 0
junit_test exited with code 1
If all the test pass, it will look like this:

junit_test  | [INFO] Running DoublyLinkedListTest
junit_test  | [INFO] Tests run: #, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.025 s -- in DoublyLinkedListTest
junit_test  | [INFO] 
junit_test  | [INFO] Results:
junit_test  | [INFO] 
junit_test  | [INFO] Tests run: #, Failures: 0, Errors: 0, Skipped: 0
junit_test  | [INFO] 
junit_test  | [INFO] ------------------------------------------------------------------------
junit_test  | [INFO] BUILD SUCCESS
junit_test  | [INFO] ------------------------------------------------------------------------
junit_test  | [INFO] Total time:  0.878 s
junit_test  | [INFO] Finished at: 2024-10-06T00:28:46Z
junit_test  | [INFO] ------------------------------------------------------------------------
junit_test exited with code 0
The docker containers can be removed with docker compose down (or for some systems docker-compose down). If you are having issues with the testing container, try taking it down and then re-running the up command.

Graded Components
You should submit a zip archive of your tests and all your broken libraries on Canvas.

The following is an incomplete list of requirements to get full credit:

At least one test for each publicly available method

A properly linked (using @see) broken implementation that will cause each test to fail

Each of the tests and broken implementations include the @author javadoc with the name of the partner who wrote it

Please be consistent with how you spell/format your names
Tests that cover all the main cases for each of the following methods (e.g. getting the first element when the list has elements, getting the first element while the list is empty, the function returns the correct value, etc.). Your tests should be small enough in scope that they test a single testable element (a single unit). We will be checking your tests for these methods against some known broken implementations to see if your tests correctly detect the bugs. This will likely required somewhere around 10 tests to cover all four of the methods. We will not be providing you the list of required tests to detect the bugs.

get
remove
set
isEmpty
Your code should build (you can check this using the provided docker compose file)

Parts of this assignment are auto-graded. Do not change the structure of the assignment.
