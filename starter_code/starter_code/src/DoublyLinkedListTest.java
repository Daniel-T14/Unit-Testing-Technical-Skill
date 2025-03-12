import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

public class DoublyLinkedListTest {
    /**
     * Use this to toggle between using the DoublyLinkedList class and your broken classes
     * You may submit with either true or false.
     */
    boolean SHOULD_FAIL = false;
    //boolean SHOULD_FAIL = true;

    private DoublyLinkedList<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new DoublyLinkedList<>();
    }

    // Broken implementations should make the error not be thrown, therefore breaking the tes

    /**
     * @author grayson_replace_this
     * @see GetAtOutOfBoundsThrowsException
     */
    @Test
    public void testGetAtOutOfBoundsThrowsException() {
        if (SHOULD_FAIL) list = new GetAtOutOfBoundsThrowsException<>();

        list.addLast(1);
        list.addLast(2);
           
        /* When SHOULD_FAIL == true junit_test:
        | [ERROR]   DoublyLinkedListTest.testGetAtOutOfBoundsThrowsException:33 
        Expected java.lang.IndexOutOfBoundsException to be thrown, but nothing was thrown. */
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    /**
     * @author Daniel Thoman
     * @see GetWrongReturn
     * 
     * This method should test that there is an item at the given index
     */
    @Test
    public void testGetAtIndex() {
        if (SHOULD_FAIL) list = new GetWrongReturn<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    /**
     * @author Daniel Thoman
     * @see GetWrongReturn
     */
    @Test
    public void testIsEmptyWhenCreated() {
        if (SHOULD_FAIL) list = new GetWrongReturn<>();
        assertEquals(true, list.isEmpty());
    }


    /**
     * @author Daniel Thoman
     * @see GetAtOutOfBoundsThrowsException
     */
    @Test
    public void testAddAtIndexOutOfBoundsThrowsException() {
        if (SHOULD_FAIL) list = new GetAtOutOfBoundsThrowsException<>();

        list.addLast(1);
        list.addLast(2);
           
        /* When SHOULD_FAIL == true junit_test:
        | [ERROR]   DoublyLinkedListTest.testAddAtIndexOutOfBoundsThrowsException:81 
        Expected java.lang.IndexOutOfBoundsException to be thrown, but nothing was thrown. */
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(3, 40));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 40));
    }


    /**
     * @author Daniel Thoman
     * @see GetWrongReturn
     */
    @Test
    public void testAddFirstAddsElement() {
        if (SHOULD_FAIL) list = new GetWrongReturn<>();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        assertEquals(3, list.getFirst());
    }


    /**
     * @author Daniel Thoman
     * @see GetWrongReturn
     */
    @Test
    public void testAddLastAddsElement() {
        if (SHOULD_FAIL) list = new GetWrongReturn<>();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertEquals(1, list.getFirst());
    }

    /**
     * @author Daniel Thoman
     * @see GetWrongReturn
     */
    @Test
    public void testRemoveAtIndex() {
       if (SHOULD_FAIL) list = new GetWrongReturn<>();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        list.remove(0);
        assertEquals(2, list.getFirst()); 

    }

    /**
     * @author Daniel Thoman
     * @see GetAtOutOfBoundsThrowsException
     */
    @Test
    public void testRemoveIndexOutOfBoundsException() {
       if (SHOULD_FAIL) list = new GetAtOutOfBoundsThrowsException<>();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        assertThrows(IndexOutOfBoundsException.class, ()-> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, ()-> list.remove(4));

    }

    /**
     * @author Diego Navarro
     * @see GetWrongReturn
     */
    @Test
    public void testAdd() {
        if (SHOULD_FAIL) list = new GetWrongReturn<>();

        list.addLast(10);
        list.addLast(20);
        list.add(1, 15); // Insert 15 between 10 and 20

        assertEquals(15, list.get(1));
        assertEquals(20, list.get(2));
    }

    /**
     * @author Diego Navarro
     * @see GetWrongReturn
     */
    @Test
    public void testSize() {
        if (SHOULD_FAIL) list = new GetWrongReturn<>();
        assertEquals(0, list.size());
        list.addLast(1);
        assertEquals(1, list.size());
    }
    /**
     * @author Diego Navarro
     * @see GetWrongReturn
     */
    @Test
    public void testSet() {
        if (SHOULD_FAIL) list = new GetWrongReturn<>();
        list.addLast(5);
        list.addLast(10);
        list.set(1, 20); // Change element at index 1 from 10 to 20
        assertEquals(5, list.get(0));
        assertEquals(20, list.get(1));
    }
    /**
     * @author Diego Navarro
     * @see GetWrongReturn
     */
    @Test
    public void testGetFirst() {
        if (SHOULD_FAIL) list = new GetWrongReturn<>();
    
        list.addLast(100);
        list.addFirst(50);
        assertEquals(50, list.getFirst());
    }
    

    /**
     * @author Diego Navarro
     * @see GetWrongReturn
     */
    @Test
    public void testGetLastIndex() {
        if (SHOULD_FAIL) list = new GetWrongReturn<>();
        //Add to the doubly linked list a couple elements.
        list.addLast(10);
        list.addLast(30);
        // Test for valid indexes
        assertEquals(30, list.getLast());
    }

     /**
     * @author Daniel Thoman
     * @see GetNoSuchElementException
     */
    @Test
    public void testGetLastNoSuchElementException() {
       if (SHOULD_FAIL) list = new GetNoSuchElementException<>();

        assertThrows(NoSuchElementException.class, ()-> list.getLast());

    }

     /**
     * @author Daniel Thoman
     * @see GetNoSuchElementException
     */
    @Test
    public void testGetFirstNoSuchElementException() {
       if (SHOULD_FAIL) list = new GetNoSuchElementException<>();

        assertThrows(NoSuchElementException.class, ()-> list.getFirst());

    }

     /**
     * @author Daniel Thoman
     * @see GetNoSuchElementException
     */
    @Test
    public void testRemoveLastNoSuchElementException() {
       if (SHOULD_FAIL) list = new GetNoSuchElementException<>();

        assertThrows(NoSuchElementException.class, ()-> list.removeLast());

    }

     /**
     * @author Daniel Thoman
     * @see GetNoSuchElementException
     */
    @Test
    public void testRemoveFirstNoSuchElementException() {
       if (SHOULD_FAIL) list = new GetNoSuchElementException<>();

        assertThrows(NoSuchElementException.class, ()-> list.removeFirst());

    }

     /**
     * @author Daniel Thoman
     * @see GetOutOfBoundsThrowsException
     */
    @Test
    public void testSetIndexOutOfBounds() {
       if (SHOULD_FAIL) list = new GetAtOutOfBoundsThrowsException<>();
        list.addFirst(10);
        assertThrows(IndexOutOfBoundsException.class, ()-> list.set(-1,40));
        assertThrows(IndexOutOfBoundsException.class, ()-> list.set(3,68));
    }

    /**
     * @author Daniel Thoman
     * @see GetWrongReturn
     */
    @Test
    public void testRemoveFirst(){
        if (SHOULD_FAIL) list = new GetWrongReturn<>();
        list.addFirst(1);
        list.addLast(2);
        //not sure of this should be of integer value check or E
        assertEquals(1, list.removeFirst());
    }

    /**
     * @author Daniel Thoman
     * @see GetWrongReturn
     */
    @Test
    public void testRemoveLast(){
        if (SHOULD_FAIL) list = new GetWrongReturn<>();
        list.addFirst(1);
        list.addLast(2);
        //not sure of this should be of integer value check or E
        assertEquals(2, list.removeLast());
    }
   
}


