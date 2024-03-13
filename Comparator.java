public class Comparator<T> implements InterfaceFactory<T> {
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

    public boolean evaluateComparison(String expression) {
        // expression = expression.substring(12, expression.length() - 1).trim();
        
        String[] parts = expression.split("");
        boolean result=false;
        try {
            String operator = parts[0];
            int leftOperand = Integer.parseInt(parts[1]);
            int rightOperand = Integer.parseInt(parts[2]);

            if ("<".equals(operator)) {
                result = leftOperand < rightOperand;
                return result;
            } else if (">".equals(operator)) {
                result = leftOperand > rightOperand;
                return result;
            } else {
                System.out.println("Operador no reconocido.");
                return result;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error al procesar los operandos numéricos.");
        }
        System.out.println(result ? "T" : "NIL");
        return result;
    }
    
}
