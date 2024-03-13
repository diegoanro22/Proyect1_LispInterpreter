import java.util.Scanner;

/*La clase {Main} es el punto de entrada del programa.
Las expresiones son validadas y analizadas hasta que el usuario introduce (exit) para finalizar el programa.*/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Expression<String> validate = new Expression<>();
        

        String expression = "";

        /*Las expresiones son analizadas por {Expression}
        para verificar su correcta estructura de paréntesis y clasificarlas para su procesamiento. */
        while (!expression.equals("(exit)")) {
            System.out.print("> ");
            expression = input.nextLine();
            try {
                validate.checkParen(expression);
                validate.checkExpression(expression);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        input.close();
    }
}