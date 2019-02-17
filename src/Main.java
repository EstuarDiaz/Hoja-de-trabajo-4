import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws IOException {


		StackFactory<String> factory = new StackFactory<>();

		Scanner input = new Scanner(System.in);
		//Se elije que tipo de implementacion es generado por la fabrica
		System.out.println("Bienvenido al programa.\n¿Que tipo de implementacion desea generar?\n\t1.ARRAY\n\t2.VECTOR\n\t3.SIMPLE (Lista con nodos simplemente enlazados)\n\t4.DOBLE (Lista con nodos doblemente enlazados)\n\t5.CIRCULAR (Lista circularmente enlazada)");
		System.out.println("Escriba el numero o la palabra en mayusculas: ");
		String respuesta = input.nextLine();
		String implementation;
		if(respuesta.equals("1")||respuesta.equals("ARRAY")){
			implementation = "ARRAY";
		}else if(respuesta.equals("2")||respuesta.equals("VECTOR")){
			implementation = "VECTOR";
		}else if (respuesta.equals("3")||respuesta.equals("SIMPLE")){
			implementation = "SIMPLE";
		}else if (respuesta.equals("4")||respuesta.equals("DOBLE")){
			implementation = "DOBLE";
		}else if (respuesta.equals("5")||respuesta.equals("CIRCULAR")){
			implementation = "CIRCULAR";
		}else{
			System.out.println("La opcion que ingreso no es valida. Se usara la implementacion con arraylist por default.");
			implementation = "ARRAY";
		}
		iPila<String> stack = factory.getPila(implementation);
		iCalculadora calc = Singleton.getCalculadora();
		// Obtener el texto postfix
		System.out.println("Por favor ingrese el texto");
		//obtiene el arcivo contenedor del Postix
      	String nomb = input.nextLine();
        FileReader 	fr = new FileReader(nomb);
        BufferedReader br = new BufferedReader (fr);
        String r = br.readLine();
        String[] texto = r.split(" ");
        // Guardar el texto en el stack
        for (int i = texto.length-1; i >= 0; i--) {
            stack.push(texto[i]);
         }
        // Operar el stack con la calculadora
        try{
		while(stack.size() >= 3) {
        	double a = Double.parseDouble(stack.pop());
        	double b = Double.parseDouble(stack.pop());
        	double awnser = 0;
        	String operacion = stack.pop();
        	switch(operacion) {
        		case "+": awnser = calc.sumar(a, b); break;
        		case "-": awnser = calc.restar(a, b); break;
        		case "*": awnser = calc.multiplicar(a, b); break;
        		case "/": awnser = calc.dividir(a, b); break;
        		default : System.out.println("El texto ingresado no es valido\n");
			        		return; 
	        }
        	stack.push(String.valueOf(awnser));
        }
        // Imprimir el resultado
        System.out.println("Respuesta: "+stack.pop());
        }catch(Exception e){
            System.out.println("Hubo un error en su texto");
        }
        input.close();
	}
}
