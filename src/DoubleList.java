public class DoubleList<E> extends aLista<E> {
    protected int count;
    protected DoublyLinkedNode<E> head;
    protected DoublyLinkedNode<E> tail;

    public DoubleList()
// post: constructs an empty list
    {
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public E getFirst()
    // pre: list is not empty
    // post: returns first value in list
    {
        return head.value();
    }

    @Override
    public void addFirst(E value)
    // pre: value is not null
    // post: adds element to head of list
    {
        tail = new DoublyLinkedNode<E>(value, null, tail);
        count++;
    }

    @Override
    public E removeFirst() {
        DoublyLinkedNode<E> temp = head;
        head = head.next(); // move head down list
        count--;
        return temp.value();
    }
}
