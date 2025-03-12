/**
 * @author Daniel Thoman
 */
public class GetWrongReturn<E> extends DoublyLinkedList<E>{
    
    
    @Override
    public E get(int index) {
    
        return super.get(index-1);
    }

    @Override
    public boolean isEmpty(){
        return false;
    }

    @Override
    public E getFirst(){
        return super.getLast();
    }

    @Override
    public E getLast(){
        return super.getFirst();
    }

    @Override
    public E removeFirst(){
        return super.removeLast();
    }

    @Override
    public E removeLast(){
        return super.removeFirst();
    }
    
}
