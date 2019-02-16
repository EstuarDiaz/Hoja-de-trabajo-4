import java.util.Iterator;

public interface iLista<E> extends iPila<E>{
    E getFirst();
    void addFirst(E value);
    E removeFirst();

}
