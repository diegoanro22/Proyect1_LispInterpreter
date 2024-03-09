//Clase para operaciones aritmeticas
import java.util.Stack;


public class Operation {
    
    /**Metodo para evaluar la expresion postfix y pasar la cadena ingresada a dato de tipo double
     * @param exp
     * @return
     */
    public double evaluatePostfixExpression(String exp){
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

    
    

    /**Metodo para verificar la existencia de algun signo de operacion
     * @param exp
     * @return
     */
    public boolean signCheck(String exp) {
        return exp.matches("[+\\-*/]");
    }

    
    /**Metodo para aplicar las operaciones aritmeticas
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

