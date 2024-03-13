import java.util.Stack;

public class Comparator<T> implements InterfaceFactory<T> {
    
    @Override
    public void execute(String exp) {
        try {
            // Eliminar paréntesis y espacios extra
            String expression = exp.replaceAll("[()]", "").trim();
            // Dividir la expresión en sus partes
            String[] parts = expression.split("\\s+");
            // Asegurarse de que la expresión es válida (operador + dos operandos)
            if (parts.length == 3) {
                String operator = parts[0];
                String leftOperand = parts[1];
                String rightOperand = parts[2];
                boolean result = compare(operator, leftOperand, rightOperand);
                System.out.println(result ? "T" : "NIL");
            } else {
                System.out.println("Expresión no válida.");
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la expresión: " + e.getMessage());
        }
    }

    private boolean compare(String operator, String left, String right) {
        try {
            // Intentar convertir los operandos a números para comparación numérica
            int leftInt = Integer.parseInt(left);
            int rightInt = Integer.parseInt(right);
            return operator.equals("<") ? leftInt < rightInt : leftInt > rightInt;
        } catch (NumberFormatException e) {
            // Si la conversión falla, asumir operandos de texto y comparar según orden alfabético inverso
            int comparisonResult = left.compareTo(right);
            if (operator.equals("<")) {
                // Aquí, 'A' > 'B' se considera verdadero, así que se invierte el resultado esperado para '<'
                return comparisonResult > 0;
            } else {
                // Para '>', 'A' < 'B' se considera verdadero, siguiendo el orden alfabético inverso
                return comparisonResult < 0;
            }
        }
    }
}