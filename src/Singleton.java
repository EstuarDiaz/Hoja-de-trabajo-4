class Singleton 
{ 
    // static variable single_instance of type Singleton 
    private static iCalculadora single_instance = null; 
  
    // variable of type String 
    public String s; 
  
    // private constructor restricted to this class itself 
    private Singleton() 
    { 
    } 
  
    // static method to create instance of Singleton class 
    public static iCalculadora getCalculadora() 
    { 
        if (single_instance == null) 
            single_instance = new Calculadora(); 
  
        return single_instance; 
    } 
} 