import java.util.Scanner;

public class Comparator<T> implements InterfaceFactory<T> {

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(String exp) {
        try {
            String expression = exp.trim();
            if (expression.matches("\\(comparator\\s*(<|>)\\s*\\d+\\s*\\d+\\)")) {
                evaluateComparison(expression);
            } else {
                System.out.println("Expresión no reconocida o mal formada.");
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la expresión: " + e.getMessage());
        }
    }

    private void evaluateComparison(String expression) {
        expression = expression.substring(12, expression.length() - 1).trim();
        
        String[] parts = expression.split("\\s+");
        try {
            String operator = parts[0];
            int leftOperand = Integer.parseInt(parts[1]);
            int rightOperand = Integer.parseInt(parts[2]);

            boolean result;
            if ("<".equals(operator)) {
                result = leftOperand < rightOperand;
            } else if (">".equals(operator)) {
                result = leftOperand > rightOperand;
            } else {
                System.out.println("Operador no reconocido.");
                return;
            }

            System.out.println(result ? "T" : "NIL");
        } catch (NumberFormatException e) {
            System.out.println("Error al procesar los operandos numéricos.");
        }
    }
    
}
