import java.util.Stack;

public class Expression<T> {

    Stack<String> stack = new Stack<>();
    Factory<T> stackFactory = new Factory<>();

    public boolean checkParen(String exp) {
        stack.clear();
        String[] expStr = exp.split("");

        if (!expStr[0].equals("(")) {
            throw new IllegalArgumentException("Error, debe empezar con un '('");
        }
        if (!expStr[expStr.length - 1].equals(")")) {
            throw new IllegalArgumentException("Error, debe terminar con un ')'");
        }

        for (String character : expStr) {
            if (character.equals("(")) {
                stack.push(character);
            }
            if (character.equals(")")) {
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("Error de paréntesis, se cierra de más");
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public void checkExpression(String exp) {
        // Verifica paréntesis primero
        if (!checkParen(exp)) {
            System.out.println("Error en la expresión: paréntesis incorrectos.");
            return;
        }

        String[] sign = {"+", "-", "*", "/"};
        boolean containsOperator = false; 

        for (String oper : sign) {
            if (exp.contains(oper)) {
                containsOperator = true;
                break;
            }
        }

        if (containsOperator) {
            InterfaceFactory<T> stackInterface = stackFactory.createStack("operation");
            stackInterface.execute(exp);
            return;
        }

        // Añadir verificación para operadores de comparación
        if (exp.matches("\\(\\s*([<>])\\s+\\w+\\s+\\w+\\s*\\)")) {
            InterfaceFactory<T> comparator = stackFactory.createStack("comparator");
            comparator.execute(exp);
            return;
        }

        String[] expStr = {"setq", "defun", "list", "equal", "quote", "atom", "princ", "comparator","cond"};
        for (String reservedWord : expStr) {
            if (exp.indexOf(reservedWord + " ", 1) == 1) {
                InterfaceFactory<T> stackInterface = stackFactory.createStack(reservedWord);
                stackInterface.execute(exp);
                return;
            }
        }

        System.out.println("Comando no reconocido.");
    }
}
