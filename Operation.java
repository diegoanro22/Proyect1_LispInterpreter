import java.util.Stack;

public class Operation<T> implements InterfaceFactory<T> {

    // Método execute que recibe una expresión como argumento
    @Override
    public void execute(String exp) {
        String postfixExp = convertToPostfix(exp);
        double resultado = evaluatePostfixExpression(postfixExp);
        System.out.println("El resultado de la expresión en Operation es: " + resultado);
    }

    /**Metodo convertir la entrada a portfix
     * @param exp
     * @return
     */
    public String convertToPostfix(String exp) {
        exp = exp.substring(1, exp.length() - 1); 
        StringBuilder postfixExp = new StringBuilder();
        String[] tokens = exp.split(" ");
        Stack<String> operatorStack = new Stack<>();

        for (String token : tokens) {
            if (signCheck(token)) {
                // Verifica la jerarquia de operadores
                while (!operatorStack.isEmpty() && hierarchySign(token) <= hierarchySign(operatorStack.peek())) {
                    postfixExp.append(" ").append(operatorStack.pop());
                }
                operatorStack.push(token); 
            } else {
                postfixExp.append(" ").append(token); 
            }
        }

        // Se envian los signos de operacion ya ordenados por jerarquia
        while (!operatorStack.isEmpty()) {
            postfixExp.append(" ").append(operatorStack.pop());
        }

        return postfixExp.toString().trim();
    }

    /**Metodo para evaluar la expresion
     * @param exp
     * @return
     */
    public double evaluatePostfixExpression(String exp) {
        Stack<Double> stack = new Stack<>();
        String[] expStr = exp.split(" ");

        for (String token : expStr) {
            if (signCheck(token)) {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = arithmeticOperation(operand1, operand2, token);
                stack.push(result);
            } else {
                stack.push(Double.parseDouble(token));
            }
        }

        return stack.pop();
    }

    /**Metodo para verificar la existencia se signos
     * @param exp
     * @return
     */
    public boolean signCheck(String exp) {
        return exp.matches("[+\\-*/]");
    }

    /**Metodo para aplicar la jerarquia de operaciones
     * @param operator
     * @return
     */
    public int hierarchySign(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }

    /**Metodo para realizar las operaciones arithmeticas
     * @param a
     * @param b
     * @param operator
     * @return
     */
    public double arithmeticOperation(double a, double b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) throw new IllegalArgumentException("División por cero");
                return a / b;
            default: throw new IllegalArgumentException("Operador desconocido: " + operator);
        }
    }
}
