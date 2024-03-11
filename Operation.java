import java.util.Stack;

public class Operation<T> implements InterfaceFactory<T> {

    // Método execute que recibe una expresión como argumento
    @Override
    public void execute(String exp) {
        String postfixExp = convertToPostfix(exp);
        double resultado = evaluatePostfixExpression(postfixExp);
        System.out.println(resultado);
    }


    public String convertToPostfix(String exp) {
        exp = exp.substring(1, exp.length() - 1); 
        StringBuilder postfixExp = new StringBuilder();
        String[] tokens = exp.split(" ");
        Stack<String> operatorStack = new Stack<>();

        for (String token : tokens) {
            if (signCheck(token)) {
                while (!operatorStack.isEmpty() && hierarchySign(token) <= hierarchySign(operatorStack.peek())) {
                    postfixExp.append(" ").append(operatorStack.pop());
                }
                operatorStack.push(token); 
            } else {
                postfixExp.append(" ").append(token); 
            }
        }

        while (!operatorStack.isEmpty()) {
            postfixExp.append(" ").append(operatorStack.pop());
        }

        return postfixExp.toString().trim();
    }

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