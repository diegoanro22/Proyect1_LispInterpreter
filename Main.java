import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Expression<String> validate = new Expression<>();
        Map<String, String> variableValues = new HashMap<>();

        String expression = "";

        while (!expression.equals("(exit)")) {
            System.out.print("> ");
            expression = input.nextLine();
            try {
                validate.checkParen(expression);
                validate.checkExpression(expression, variableValues);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        input.close();
    }
}