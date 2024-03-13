import java.util.ArrayList;
import java.util.Scanner;

/*La clase {Main} es el punto de entrada del programa.
Las expresiones son validadas y analizadas hasta que el usuario introduce (exit) para finalizar el programa.*/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Expression<String> validate = new Expression<>();
        Archivo archivoLisp = new Archivo("Lisp.txt");


        
        String expression = "";
        
        while (!expression.equals("(exit)")) {
            System.out.print("> ");
            try {
                ArrayList<String> listPosfix = archivoLisp.leerArchivo();
                expression = input.nextLine();
                for (String linea : listPosfix) {
                    validate.checkParen(linea);
                    validate.checkExpression(linea);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        input.close();
    }
}