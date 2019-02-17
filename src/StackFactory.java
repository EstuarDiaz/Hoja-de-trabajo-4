class StackFactory<E> {
//selecciona la implementacion a utilizar para un stack
//se utiliza el patron Factory
   public iPila<E> getPila(String entry) {
    // seleccion de la implementacion a utilizar:
	if (entry.equals("ARRAYLIST"))
      return new StackArrayList<E>(); //regresa ArrayList
	else if (entry.equals("VECTOR"))
      return new StackVector<E>(); //regresa Vector
	else if (entry.equals("SIMPLE"))
	      return new SimpleList<E>(); //regresa Vector
	else if (entry.equals("DOUBLE"))
	      return new DoubleList<E>(); //regresa Vector
	else if (entry.equals("CIRCULAR"))
	      return new CyclicList<E>(); //regresa Vector
	else 
		return new StackArrayList<E>();
   }
}