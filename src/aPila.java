abstract public class aPila<E> 
implements iPila<E>
{
      public boolean isEmpty()
   // post: regresa true si el stack esta vacio
   {
      return size() == 0;
   }
}