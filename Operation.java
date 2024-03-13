import java.util.Stack;

public class Operation<T> implements InterfaceFactory<T> {

    // Método execute que recibe una expresión como argumento
    @Override
    public void execute(String exp) {
        exp = evaluateExpression(exp);
        double resultado = evaluatePrefixExpression(exp);
        System.out.println(resultado);
    }

    public String evaluateExpression(String expresion){
        expresion = expresion.replace("(", "").replace(")", "");
        return expresion;
    }

    public double evaluatePrefixExpression(String exp) {
        Stack<Double> stack = new Stack<>();
        String[] expStr = exp.split(" ");
    
        // Recorre los tokens de derecha a izquierda
        for (int i = expStr.length - 1; i >= 0; i--) {
            String token = expStr[i];
            if (signCheck(token)) {
                // Si es un operador, saca los dos últimos números de la pila
                double operand1 = stack.pop();
                double operand2 = stack.pop();
                // Realiza la operación correspondiente y coloca el resultado en la pila
                double result = arithmeticOperation(operand1, operand2, token);
                stack.push(result);
            } else {
                // Si es un número, colócalo en la pila
                stack.push(Double.parseDouble(token));
            }
        }
    
        // El resultado final estará en la cima de la pila
        return stack.pop();
    }

    public boolean signCheck(String exp) {
        return exp.matches("[+\\-*/]");
    }

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