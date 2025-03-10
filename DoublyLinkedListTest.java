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
     * @author Diego Navarro
     * @see WrongValueThrowsException
     */ 
    @Test
    public void testGetAtIndex() {
        if (SHOULD_FAIL) list = new WrongValueThrowsException<>();
        //Add to the doubly linked list a couple elements.
        list.addLast(30);
        // Test for valid indexes
        assertEquals(null, list.get(1));
    }
    
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
     * @author Diego Navarro
     * @see WrongValueThrowsException
     */ 
    @Test
    public void testGetFirst() {
        if (SHOULD_FAIL) list = new WrongValueThrowsException<>();
        //Add to the doubly linked list a couple elements.
        list.addLast(10);
        list.addFirst(30);
        // Test for valid indexes
        Assertions.assertEquals(Integer.valueOf(30), list.getFirst());
    }
    
    /**
     * @author Diego Navarro
     * @see GetNoSuchElementException
     */
    @Test
    public void testGetFirstNoSuchElementException() {
        if (SHOULD_FAIL) list = new GetNoSuchElementException<>();
        assertEquals(null, () -> list.getFirst());
    }
    
    // Tests for getLast
    
    
    /**
     * @author Diego Navarro
     * @see WrongValueThrowsException
     */ 
    @Test
    public void testGetLast() {
        if (SHOULD_FAIL) list = new WrongValueThrowsException();
        //Add to the doubly linked list a couple elements.
        list.addLast(10);
        list.addLast(30);
        // Test for valid indexes
        assertEquals(Integer.valueOf(30), list.getLast());
    }
    
    /**
     * @author Diego Navarro
     * @see GetNoSuchElementException
     */
    @Test
    public void testGetLastNoSuchElementException() {
        if (SHOULD_FAIL) list = new GetNoSuchElementException();
        assertEquals(null, () -> list.getLast());
    }
    
    
    //Tests removeFirsts
    /**
     * @author Daniel Thoman
     * @see WrongValueThrowsException
     */
    @Test
    public void testRemoveFirst(){
        if (SHOULD_FAIL) list = new WrongValueThrowsException<>();
        list.addFirst(1);
        list.addLast(2);
        //not sure of this should be of integer value check or E
        assertEquals(Integer.valueOf(1), removeFirst());
    }
    /**
     * @author Daniel Thoman
     * @see NoSuchElementException
     */
    public void testRemoveFirstsNoSuchElement(){
        if (SHOULD_FAIL) list = new NoSuchElementException<>();
        //not sure of this should be of integer value check or E
        assertEquals(null, removeFirst());
    }

    /**
     * @author Daniel Thoman
     * @see WrongValueThrowsException
     */
    public void testRemoveLast(){
        if (SHOULD_FAIL) list = new WrongValueThrowsException<>();
        list.addFirst(1);
        list.addFirst(2);
        //not sure of this should be of integer value check or E
        assertEquals(Integer.valueOf(2), removeLast());
    }

    /**
     * @author Daniel Thoman
     * @see NoSuchElementException
     */
    public void testRemoveLastNoSuchElement(){
        if (SHOULD_FAIL) list = new NoSuchElementException<>();
        //not sure of this should be of integer value check or E
        assertEquals(null, removeLast());
    }


    //tests for isElementIndex
    /**
     * @author Diego Navarro
     * @see WrongValueThrowsException
     */ 
    @Test
    public void testisElementIndex() {
        if (SHOULD_FAIL) list = new WrongValueThrowsException<>();
        //Add to the doubly linked list a couple elements.
        list.addLast(10);
        list.addLast(30);
        // Test for valid indexes
        assertEquals(true, list.testisElementIndex(1));
        assertEquals(false, list.isElementIndex(2));
        assertEquals(false, list.isElementIndex(4));
    }

    
    //Tests for isPositionIndex
    /**
     * @author Diego Navarro
     * @see WrongValueThrowsException
     */ 
    @Test
    public void testisPositionIndex() {
        if (SHOULD_FAIL) list = new WrongValueThrowsException<>();
        //Add to the doubly linked list a couple elements.
        list.addLast(10);
        list.addLast(30);
        // Test for valid indexes
        assertEquals(true, list.isPositionIndex(0));
        assertEquals(true, list.isPositionIndex(2));
        assertEquals(false, list.isPositionIndex(4));
    }
    
    /**
     * @author Diego Navarro
     * @see GetAtOutOfBoundsThrowsException
     */
    @Test
    public void testIsEmptyWhenCreated() {
        if (SHOULD_FAIL) list = new GetAtOutOfBoundsThrowsException<>();
        //Test empty
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    /**
     * @author Daniel Thoman
     * @see WrongValueThrowsException
     */
    @Test
    public void testAdd(){
        if (SHOULD_FAIL) list = new WrongValueThrowsException<>();
        list.add(1, 4);
        assertEquals(Integer.valueOf(4), list.get(1));
    }

    /**
     * @author Daniel Thoman
     * @see GetAtOutOfBoundsThrowsException
     */
    @Test
    public void testAddAtIndexOutOfBoundsThrowsException() {
        if (SHOULD_FAIL) list = new GetAtOutOfBoundsThrowsException<>();
        list.addLast(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 2));//test negative insert
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(3, 4));//test out of bound size
    }

    /**
     * @author Diego Navarro    
     * @see WrongValueThrowsException
     */
    @Test
    public void testAddFirst() {
        if (SHOULD_FAIL) list = new WrongValueThrowsException<>();
        //Add to the doubly linked list a couple elements.
        list.addLast(10); //simulate having the linked list already filled with elements
        list.addFirst(30); //add at the beginning of the doubly linked list

        //Check that the start of the doubly linked list is 30, which is what addFirst should have done
        Assertions.assertEquals(Integer.valueOf(30), () ->list.getFirst()); 
    }

    /**
     * @author Daniel Thoman
     * @see WrongValueThrowsException
     */
    @Test
    public void testAddLast() {
        if (SHOULD_FAIL) list = new WrongValueThrowsException<>();
        list.addLast(1);
        list.addLast(2);
        Assertions.assertEquals(Integer.valueOf(2), list.getLast());
    }

    // Tests for remove

    /**
     * @author Diego Navarro
     * @see WrongValueThrowsException
     */
    @Test
    public void testRemoveAtIndex() {
        if (SHOULD_FAIL) list = new WrongValueThrowsException<>();
        
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        assertEquals(Integer.valueOf(2), list.remove(1));
    }

    /**
     * @author Diego Navarro
     * @see GetAtOutOfBoundsThrowsException
     */
    @Test
    public void testRemoveAtOutOfBoundsThrowsException() {
        if (SHOULD_FAIL) list = new GetAtOutOfBoundsThrowsException<>();
        list.addFirst(1);
        assertThrows(IndexOutOfBoundsException.class, ()-> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, ()-> list.remove(2));
        
    }

    /**
     * @author Daniel Thoman
     * @see WrongValueThrowsException
     */
    @Test
    public void testSize(){
        if (SHOULD_FAIL) list = new WrongValueThrowsException<>();
        list.addFirst(1);
        assertEquals(Integer.valueOf(1), list.size());
    }

    /**
     * @author Daniel Thoman
     * @see WrongValueThrowsException
     */
    @Test
    public void testSet(){
        if (SHOULD_FAIL) list = new WrongValueThrowsException<>();
        list.addFirst(1);
        list.addLast(2);
        assertEquals(Integer.valueOf(2), list.set(1, 5));
    }

    /**
     * @author Daniel Thoman
     * @see GetAtOutOfBoundsThrowsException
     */
    @Test
    public void testsSetGetAtOutOfBoundsThrowsException(){
        if (SHOULD_FAIL) list = new GetAtOutOfBoundsThrowsException<>();
        list.addFirst(1);
        assertThrows(IndexOutOfBoundsException.class, list.set(-1, 3)); //negative bounds
        assertThrows(IndexOutOfBoundsException.class, list.set(2, 3)); //beyond size
    }
}