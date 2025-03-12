/**
 * @author grayson_replace_this
 */
public class GetAtOutOfBoundsThrowsException<E> extends DoublyLinkedList<E> {
    @Override
    public E get(int index) {
        // Forces all gets to be within the bounds of the list
        return super.get(Math.min(super.size() - 1, Math.max(0, index)));
    }

    @Override
    public E set(int index, E element) {
        // Forces all gets to be within the bounds of the list
        return super.set(Math.min(super.size() - 1, Math.max(0, index)), element);
    }

    @Override
    public void add(int index, E element){
        super.add(Math.min(super.size() - 1, Math.max(0, index)), element);
    }

    @Override
    public E remove(int index){
        return super.remove(Math.min(super.size() - 1, Math.max(0, index)));
    }
}
