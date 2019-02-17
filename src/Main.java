import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws IOException {
		iPila<String> stack = new Pila<String>();
		iCalculadora calc = Singleton.getCalculadora();
		Scanner input = new Scanner(System.in);
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
