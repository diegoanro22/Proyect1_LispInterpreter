public class Comparator<T> implements InterfaceFactory<T> {
    @Override
    public void execute(String exp) {
        try {
            // Elimina espacios extra y los paréntesis al inicio y al final.
            String expression = exp.trim().replaceAll("^\\(|\\)$", "");
            // Divide la expresión en sus componentes: operador, operando izquierdo, operando derecho.
            String[] parts = expression.split("\\s+");

            if (parts.length == 3) {
                String operator = parts[0];
                String leftOperand = parts[1];
                String rightOperand = parts[2];

                // Llama a evaluateComparison con los componentes extraídos.
                boolean result = evaluateComparison(operator, leftOperand, rightOperand);
                System.out.println(result ? "T" : "NIL");
            } else {
                System.out.println("Expresión no reconocida o mal formada.");
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la expresión: " + e.getMessage());
        }
    }

    public boolean evaluateComparison(String operator, String leftOperand, String rightOperand) {
        try {
            // Intenta convertir los operandos a números para una comparación numérica.
            int leftInt = Integer.parseInt(leftOperand);
            int rightInt = Integer.parseInt(rightOperand);
    
            if ("<".equals(operator)) {
                return leftInt < rightInt;
            } else if (">".equals(operator)) {
                return leftInt > rightInt;
            } 
        } catch (NumberFormatException e) {
            // Invertir la lógica de comparación de cadenas para cumplir con "A" > "B" = T
            int comparisonResult = leftOperand.compareTo(rightOperand);
            if ("<".equals(operator)) {
                // Invierte el resultado esperado para '<'
                return comparisonResult > 0;
            } else if (">".equals(operator)) {
                // Invierte el resultado esperado para '>'
                return comparisonResult < 0;
            } 
        }
        System.out.println("Operador no reconocido.");
        return false;
    }    
}