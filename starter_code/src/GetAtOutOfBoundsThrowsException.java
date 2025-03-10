/**
 * @author Daniel_Thoman
 * @author Diego_Navarro
 *	dkthoman@wisc.edu
 *Notes:
 * 	Recall that super.func calls the parent class func.
 * 	So the given example overide of get(index) grabs 
 * 	parent get(min((listSize-1), max(0, paramIndex))). 
 * 	So this override resizes the index to be within the 
 * 	bounds of the list instead of throwing an error.
 * 	Hense the essense of minimal viable error.
 *
 * 	"When creating the broken subclasses of DoublyLinkedList 
 * 	you are to break as little functionality as is possible."
 * 	-DevTech3 Canvas Page
 * 
 * 	The intended purpose of this file.  
  */

public class GetAtOutOfBoundsThrowsException<E> extends DoublyLinkedList<E> {
    /*
     * @author grayson (TA)
     */
    @Override
    public E get(int index) {
        // Forces all gets to be within the bounds of the list
        return super.get(Math.min(super.size() - 1, Math.max(0, index)));
    }
    /*
     * @author Daniel Thoman
     */
    @Override
    public E set(int index, E element){
        return super.set(Math.min(super.size() - 1, Math.max(0, index)),element);
    }
     /*
     * @author Diego Navarro
     */
    @Override
    public void add(int index, E element){
        return super.get(Math.min(super.size() - 1, Math.max(0, index)),element);
    }

    /*
     * @author Diego Navarro
     */
    @Override
    public E remove(int index, E element){
        return super.remove(Math.min(super.size() - 1, Math.max(0, index)),element);
    }

}


