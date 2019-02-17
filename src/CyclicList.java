/*
    Codigo extraido y adaptado de Java Structures, (Bailey, 2007)

*/

public class CyclicList<E> extends aLista<E> {

    protected Node<E> tail;
    protected int count;
    @Override
    public int size() {
        return this.count;
    }

    @Override
    public E getFirst() {
        return tail.value();
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
    	if(tail.next() == tail) {
    		E value = tail.value();
    		tail = null;
    		count--;
    		return value;
    	}
    	else {
    		E value = tail.value();
    		// gets second
    		Node<E> segundo = tail;
    		for(int i = 0; i < count-1; i++) {
    			segundo = segundo.next();
    		}
    		segundo.setNext(tail.next());
    		tail = segundo;
    		count--;
    		return value;
    	}
    }
}
