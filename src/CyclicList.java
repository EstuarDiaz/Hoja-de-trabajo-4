public class CyclicList<E> extends aLista<E> {

    protected Node<E> tail;
    protected int count;
    @Override
    public int size() {
        return this.count;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public void addFirst(E value)
        // pre: value non-null
        // post: adds element to head of list
        {
            Node<E> temp = new Node<E>(value);
            if (tail == null) { // first value added
                tail = temp;
                tail.setNext(tail);
            } else { // element exists in list
                temp.setNext(tail.next());
                tail.setNext(temp);
            }
            count++;
    }

    @Override
    public E removeFirst() {
        return null;
    }


}
