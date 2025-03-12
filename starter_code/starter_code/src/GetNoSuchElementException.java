public class GetNoSuchElementException<E> extends DoublyLinkedList<E>{
    private E value;
    @Override
    public E getLast(){
        return value;
    }
    @Override
    public E getFirst(){
        return value;
    }
    @Override
    public E removeFirst(){
        return value;
    }

    @Override
    public E removeLast(){
        return value;
    }
}